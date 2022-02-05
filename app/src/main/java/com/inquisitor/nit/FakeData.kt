package com.inquisitor.nit

data class FakeHotCollectionModel(
    val collectionList: List<Int>,
    val username: String,
    val userImage: Int
)

data class FakeItemModel(
    val id: Int,
    val itemImage: Int,
    val itemName: String,
    val isFavorite: Boolean,
    val userImage: Int,
    val username: String,
    val userType: String
)

object FakeData {
//    fun getFakeHotCollectionList() = mutableListOf(
//        FakeHotCollectionModel(
//
//        )
//    )

    fun getFakeItemList() = mutableListOf(
        FakeItemModel(
            id = 1,
            itemImage = R.drawable.item1,
            itemName = "Silent Wave",
            isFavorite = false,
            userImage = R.drawable.user1,
            username = "Pawel Czerwinski",
            userType = "Creator"
        ),
        FakeItemModel(
            id = 2,
            itemImage = R.drawable.item1,
            itemName = "Silent Wave",
            isFavorite = false,
            userImage = R.drawable.user1,
            username = "Pawel Czerwinski",
            userType = "Creator"
        ),
        FakeItemModel(
            id = 2,
            itemImage = R.drawable.item1,
            itemName = "Silent Wave",
            isFavorite = false,
            userImage = R.drawable.user1,
            username = "Pawel Czerwinski",
            userType = "Creator"
        ),
        FakeItemModel(
            id = 3,
            itemImage = R.drawable.item1,
            itemName = "Silent Wave",
            isFavorite = false,
            userImage = R.drawable.user1,
            username = "Pawel Czerwinski",
            userType = "Creator"
        ),
        FakeItemModel(
            id = 4,
            itemImage = R.drawable.item1,
            itemName = "Silent Wave",
            isFavorite = false,
            userImage = R.drawable.user1,
            username = "Pawel Czerwinski",
            userType = "Creator"
        ),
        FakeItemModel(
            id = 5,
            itemImage = R.drawable.item1,
            itemName = "Silent Wave",
            isFavorite = false,
            userImage = R.drawable.user1,
            username = "Pawel Czerwinski",
            userType = "Creator"
        ),
        FakeItemModel(
            id = 6,
            itemImage = R.drawable.item1,
            itemName = "Silent Wave",
            isFavorite = false,
            userImage = R.drawable.user1,
            username = "Pawel Czerwinski",
            userType = "Creator"
        ),
        FakeItemModel(
            id = 7,
            itemImage = R.drawable.item1,
            itemName = "Silent Wave",
            isFavorite = false,
            userImage = R.drawable.user1,
            username = "Pawel Czerwinski",
            userType = "Creator"
        )
    )
}