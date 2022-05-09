package com.example.feature_home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common_resources.grayText
import com.example.common_resources.textSalary
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun CardItemView(
    cardModel: CardModel,
    isLoading: Boolean
) {
    Column(
        modifier = Modifier
            .size(width = 148.dp, height = 170.dp)
            .background(
                shape = RoundedCornerShape(size = 30.dp),
                color = cardModel.backgroundColor
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Text(
            text = textSalary,
            color = grayText,
            fontSize = 12.sp,
            modifier = Modifier
                .wrapContentWidth()
                .placeholder(
                    visible = isLoading,
                    color = Color.Gray,
                    shape = RoundedCornerShape(4.dp),
                    highlight = PlaceholderHighlight.fade(
                        highlightColor = Color.White,
                    )
                )
        )

        Text(
            text = cardModel.moneyAmount,
            color = grayText,
            fontSize = 16.sp,
            modifier = Modifier.wrapContentSize()
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 26.dp)
        )

        Text(
            text = "** ${cardModel.number.takeLast(n = 4)}",
            color = grayText,
            fontSize = 12.sp,
            modifier = Modifier.wrapContentSize()
        )
    }
}