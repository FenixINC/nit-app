package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.open_sea_nft.MainBundleResponse
import com.inquisitor.domain.model.BundleModel
import com.inquisitor.domain.model.MainBundleModel

fun MainBundleResponse.mapToModel() = MainBundleModel(
    bundleList = this.bundleList?.map { bundleResponse ->
        BundleModel(
            name = bundleResponse.name,
            slug = bundleResponse.slug,
            description = bundleResponse.description,
            externalLink = bundleResponse.externalLink,
            permalink = bundleResponse.permalink,
            mainUser = bundleResponse.mainUser?.mapToModel(),
            assetList = bundleResponse.assetList?.mapToModel()
        )
    }
)