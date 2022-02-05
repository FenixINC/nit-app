package com.inquisitor.data.constants

internal object NetworkConstants {
    const val TIME_OUT = 60_000

    const val EMPTY_TEXT = ""
    const val V1 = "v1"

    const val BASE_URL_OPEN_SEA_NFT = "rinkeby-api.opensea.io" /*"api.opensea.io"*/
    const val BASE_URL_ANIME_HEROKU = "ghibliapi.herokuapp.com"

    /**
     * GET
     **/
    const val GET_FILM_LIST = "films"

    const val GET_ASSET_LIST = "assets"
    const val GET_BUNDLE_LIST = "bundles"

    /**
     * QUERY
     **/

    const val QUERY_LIMIT_DEFAULT = 20
    const val QUERY_LIMIT = "limit"
    const val QUERY_OFFSET = "offset"

    /**
     *
     *
     *
     *
     * PEXELS API
     *
     *
     *
     *
     **/

    const val API_KEY = "563492ad6f91700001000001598075e713ef4db392b0a110654c1a3c"
    const val BASE_URL_PEXELS = "api.pexels.com"

    /**
     * GET
     **/

    const val GET_SEARCH_PHOTO = "search"
    const val GET_SEARCH_VIDEO = "videos/search"

    /**
     * QUERY
     **/

    const val QUERY_PARAM = "query" // query=space
}