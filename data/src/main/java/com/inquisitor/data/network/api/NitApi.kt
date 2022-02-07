package com.inquisitor.data.network.api

import com.inquisitor.data.constants.NetworkConstants.GET_COLLECTION_DETAILS
import com.inquisitor.data.constants.NetworkConstants.GET_COLLECTION_LIST
import com.inquisitor.data.constants.NetworkConstants.GET_FILM_LIST
import com.inquisitor.data.constants.NetworkConstants.GET_SEARCH_PHOTO
import com.inquisitor.data.constants.NetworkConstants.GET_SEARCH_VIDEO
import com.inquisitor.data.constants.NetworkConstants.QUERY_PARAM
import com.inquisitor.data.network.response.anime.FilmResponse
import com.inquisitor.data.network.response.pexels.CollectionDetailsResponse
import com.inquisitor.data.network.response.pexels.MainCollectionResponse
import com.inquisitor.data.network.response.pexels.MainPhotoResponse
import com.inquisitor.data.network.response.pexels.MainVideoResponse
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NitApi @Inject constructor(
    private val ktorClient: HttpClient // TODO: add qualifiers for different network client (ktor, retrofit, etc.)
) {
    suspend fun login(username: String, password: String): String {
        delay(timeMillis = 1500L)
        return "Hello"
    }

    suspend fun loadFilmList(): List<FilmResponse> {
        return ktorClient.get {
            url { path(GET_FILM_LIST) }
        }
    }

    /**
     *
     *
     *
     * PEXELS API
     *
     *
     *
     **/

    suspend fun loadCollectionList(): MainCollectionResponse {
        return ktorClient.get {
            url { path(GET_COLLECTION_LIST) }
        }
    }

    suspend fun loadCollectionDetails(collectionId: String): CollectionDetailsResponse {
        return ktorClient.get {
            url { path("$GET_COLLECTION_DETAILS/$collectionId") }
        }
    }

    suspend fun loadPhotoListBySearchKey(searchKey: String = "Popular"): MainPhotoResponse {
        return ktorClient.get {
            url { path(GET_SEARCH_PHOTO) }
            parameter(key = QUERY_PARAM, value = searchKey)
        }
    }

    suspend fun loadVideoListBySearchKey(searchKey: String = "Popular"): MainVideoResponse {
        return ktorClient.get {
            url { path(GET_SEARCH_VIDEO) }
            parameter(key = QUERY_PARAM, value = searchKey)
        }
    }

    /**
     * GET request with parameter
     **/
//    suspend fun getSomeDataById(id: String): SomeResponse {
//        return httpClient.get {
//            url { path(GET_SOME_DATA) }
//            parameter(key = QUERY_ID, value = id)
//        }
//    }

    /**
     * POST request
     **/
//    suspend fun createUser(userDto: UserDto) {
//        return httpClient.post {
//            url { path(POST_SOME_DATA) }
//
//            body = json.encodeToJsonElement(
//                serializer = UserDto.serializer(),
//                value = UserDto
//            )
//        }
//    }
}