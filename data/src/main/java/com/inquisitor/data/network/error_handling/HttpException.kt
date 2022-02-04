package com.inquisitor.data.network.error_handling

class HttpException(
    override val errorMessage: String? = null,
    override val statusCode: Int? = 0,
    val url: String? = null,
    cause: Throwable? = null
) : Exception(null, cause), NitException