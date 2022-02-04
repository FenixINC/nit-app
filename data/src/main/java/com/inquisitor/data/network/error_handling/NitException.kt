package com.inquisitor.data.network.error_handling

interface NitException {
    val statusCode: Int?
    val errorMessage: String?
}