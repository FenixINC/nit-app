package com.inquisitor.nit.ui.home

import androidx.lifecycle.viewModelScope
import com.example.navigation.Navigator
import com.inquisitor.domain.model.CollectionModel
import com.inquisitor.domain.model.PhotoModel
import com.inquisitor.domain.model.VideoModel
import com.inquisitor.domain.usecase.CollectionUseCase
import com.inquisitor.domain.usecase.PhotoUseCase
import com.inquisitor.domain.usecase.VideoUseCase
import com.inquisitor.nit.base.BaseViewModel
import com.inquisitor.nit.constants.MediaConstants.MEDIA_TYPE_ANIMALS
import com.inquisitor.nit.constants.MediaConstants.MEDIA_TYPE_NATURE
import com.inquisitor.nit.constants.MediaConstants.MEDIA_TYPE_RECOMMENDED
import com.inquisitor.nit.constants.MediaConstants.MEDIA_TYPE_TRENDS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator,
    private val collectionUseCase: CollectionUseCase,
    private val photoUseCase: PhotoUseCase,
    private val videoUseCase: VideoUseCase
) : BaseViewModel<HomeEvent, HomeState, HomeEffect>(), Navigator by navigator {

    init {
        navigator.topBar(isShowTopBar = true)
    }

    override fun setInitialState() = HomeState()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            is HomeEvent.CloseApp -> {
                navigator.onCloseApp()
            }
            is HomeEvent.LoadMedia -> {
                loadMediaAsync()
            }
            is HomeEvent.OpenCollectionDetails -> {
//                navigator.navigate(
//                    route = CollectionDetailsDestination.createCollectionDetailsDestination(
//                        collectionId = event.collectionId
//                    )
//                )
            }
        }
    }

    // TODO: rewrite this implementation! (Used a lot of async calls because of api implementation)
    private fun loadMediaAsync() {
        val collectionList = mutableListOf<CollectionModel>()

        val recommendedPhotoList = mutableListOf<PhotoModel>()
        val recommendedVideoList = mutableListOf<VideoModel>()

        val animalsPhotoList = mutableListOf<PhotoModel>()
        val animalsVideoList = mutableListOf<VideoModel>()

        val naturePhotoList = mutableListOf<PhotoModel>()
        val natureVideoList = mutableListOf<VideoModel>()

        val trendsPhotoList = mutableListOf<PhotoModel>()
        val trendsVideoList = mutableListOf<VideoModel>()

        viewModelScope.launch {
            val collectionsAsync = async {
                collectionUseCase.loadCollectionList(
                    onSuccess = { list ->
                        collectionList.addAll(elements = list)
                    },
                    onError = { throwable ->
                        navigator.onError(throwable = throwable)
                    }
                )
            }

            val recommendedPhotoAsync = async {
                photoUseCase.loadPhotoListBySearchKey(
                    searchKey = MEDIA_TYPE_RECOMMENDED,
                    onSuccess = { list ->
                        recommendedPhotoList.addAll(elements = list)
                    },
                    onError = { throwable ->
                        navigator.onError(throwable = throwable)
                    }
                )
            }
            val recommendedVideoAsync = async {
                videoUseCase.loadVideoListBySearchKey(
                    searchKey = MEDIA_TYPE_RECOMMENDED,
                    onSuccess = { list ->
                        recommendedVideoList.addAll(elements = list)
                    },
                    onError = { throwable ->
                        navigator.onError(throwable = throwable)
                    }
                )
            }

            val animalsPhotoAsync = async {
                photoUseCase.loadPhotoListBySearchKey(
                    searchKey = MEDIA_TYPE_ANIMALS,
                    onSuccess = { list ->
                        animalsPhotoList.addAll(elements = list)
                    },
                    onError = { throwable ->
                        navigator.onError(throwable = throwable)
                    }
                )
            }

            val animalsVideoAsync = async {
                videoUseCase.loadVideoListBySearchKey(
                    searchKey = MEDIA_TYPE_ANIMALS,
                    onSuccess = { list ->
                        animalsVideoList.addAll(elements = list)
                    },
                    onError = { throwable ->
                        navigator.onError(throwable = throwable)
                    }
                )
            }

            val naturePhotoAsync = async {
                photoUseCase.loadPhotoListBySearchKey(
                    searchKey = MEDIA_TYPE_NATURE,
                    onSuccess = { list ->
                        naturePhotoList.addAll(elements = list)
                    },
                    onError = { throwable ->
                        navigator.onError(throwable = throwable)
                    }
                )
            }

            val natureVideoAsync = async {
                videoUseCase.loadVideoListBySearchKey(
                    searchKey = MEDIA_TYPE_NATURE,
                    onSuccess = { list ->
                        natureVideoList.addAll(elements = list)
                    },
                    onError = { throwable ->
                        navigator.onError(throwable = throwable)
                    }
                )
            }

            val trendsPhotoAsync = async {
                photoUseCase.loadPhotoListBySearchKey(
                    searchKey = MEDIA_TYPE_TRENDS,
                    onSuccess = { list ->
                        trendsPhotoList.addAll(elements = list)
                    },
                    onError = { throwable ->
                        navigator.onError(throwable = throwable)
                    }
                )
            }

            val trendsVideoAsync = async {
                videoUseCase.loadVideoListBySearchKey(
                    searchKey = MEDIA_TYPE_TRENDS,
                    onSuccess = { list ->
                        trendsVideoList.addAll(elements = list)
                    },
                    onError = { throwable ->
                        navigator.onError(throwable = throwable)
                    }
                )
            }

            awaitAll(
                collectionsAsync,
//                recommendedPhotoAsync,
//                recommendedVideoAsync,
//                animalsPhotoAsync,
//                animalsVideoAsync,
//                naturePhotoAsync,
//                natureVideoAsync,
//                trendsPhotoAsync,
//                trendsVideoAsync
            )

            setState {
                copy(
                    collectionList = collectionList,
                    recommendedPhotoList = recommendedPhotoList,
                    recommendedVideoList = recommendedVideoList,
                    animalsPhotoList = animalsPhotoList,
                    animalsVideoList = animalsVideoList,
                    naturePhotoList = naturePhotoList,
                    natureVideoList = natureVideoList,
                    trendsPhotoList = trendsPhotoList,
                    trendsVideoList = trendsVideoList
                )
            }
        }
    }
}