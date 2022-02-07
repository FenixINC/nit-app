package com.inquisitor.nit.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.inquisitor.domain.model.CollectionModel
import com.inquisitor.nit.ui.resources.space55dp
import com.inquisitor.nit.ui.resources.space8dp
import com.inquisitor.nit.ui.resources.spaceDefault

@Composable
fun CollectionRow(
    collectionModel: CollectionModel,
    onCollectionClick: (CollectionModel) -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .height(height = space55dp)
            .clip(shape = RoundedCornerShape(size = space8dp))
            .background(color = Color.Gray)
            .clickable(onClick = { onCollectionClick(collectionModel) })
            .padding(all = spaceDefault),
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