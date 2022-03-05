package com.example.feature_home.test_home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.inquisitor.domain.model.CollectionModel

@Composable
fun CollectionRow(
    collectionModel: CollectionModel,
    onCollectionClick: (CollectionModel) -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .height(height = 55.dp)
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(color = Color.Gray)
            .clickable(onClick = { onCollectionClick(collectionModel) })
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = collectionModel.title ?: "ERROR",
            modifier = Modifier.wrapContentSize(),
            color = Color.White
        )

        Row(
            modifier = Modifier.wrapContentSize()
        ) {

        }
    }
}