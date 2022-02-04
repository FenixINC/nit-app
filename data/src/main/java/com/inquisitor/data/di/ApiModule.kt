package com.inquisitor.data.di

import com.inquisitor.data.constants.NetworkConstants.BASE_URL_OPEN_SEA_NFT
import com.inquisitor.data.constants.NetworkConstants.TIME_OUT
import com.inquisitor.data.network.error_handling.ErrorResponse
import com.inquisitor.data.network.error_handling.HttpException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideKtorClient(): HttpClient {
        return HttpClient(engineFactory = Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })

                engine {
                    connectTimeout = TIME_OUT
                    socketTimeout = TIME_OUT
                }
            }

            HttpResponseValidator {
                validateResponse { response ->
                    when (val statusCode = response.status.value) {
                        /**
                         * Handle different exceptions
                         * */
                        in 400..499 -> throw HttpException(statusCode = statusCode)
                    }
                }

                handleResponseException { cause ->
                    val responseException =
                        cause as? ResponseException ?: return@handleResponseException
                    val response = responseException.response
                    val bytes = response.receive<ByteArray>()
                    val string = bytes.decodeToString()
                    val errorResponse = kotlinx.serialization.json.Json.decodeFromString(
                        ErrorResponseSerializer,
                        string
                    )
                    throw HttpException(
                        statusCode = errorResponse.code?.toInt() ?: 400,
                        statusMessage = errorResponse.message,
                        url = errorResponse.name
                    )
                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
//                        Log.v("Logger Ktor =>", message)
                    }

                }
                level = LogLevel.ALL
            }

            install(ResponseObserver) {
                onResponse { response ->
//                    Log.d("HTTP status:", "${response.status.value}")
                }
            }

            install(DefaultRequest, ::interceptors)

            defaultRequest {
                url {
                    host = BASE_URL_OPEN_SEA_NFT
                    protocol = URLProtocol.HTTPS
                }
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }

    private fun interceptors(builder: HttpRequestBuilder) {
        builder.apply {
            headers.apply { append(name = "Accept", value = "application/json") }
        }
    }

    private object ErrorResponseSerializer : KSerializer<ErrorResponse> {
        override val descriptor: SerialDescriptor =
            buildClassSerialDescriptor(serialName = "UnknownProject") {
                element<String>(elementName = "name")
                element<String>(elementName = "message")
                element<String>(elementName = "code")
                /**
                 * For custom objects
                 * */
//        element<JsonElement>("details")
            }

        override fun deserialize(decoder: Decoder): ErrorResponse {
            val jsonInput = decoder as? JsonDecoder ?: error("Can be deserialized only by JSON")
            val json = jsonInput.decodeJsonElement().jsonObject
            val name = json.getValue(key = "name").jsonPrimitive.content
            val message = json.getValue(key = "message").jsonPrimitive.content
            val code = json.getValue(key = "code").jsonPrimitive.content
            return ErrorResponse(name, message, code)
        }

        override fun serialize(encoder: Encoder, value: ErrorResponse) {
            error("Serialization is not supported for $value")
        }
    }
}