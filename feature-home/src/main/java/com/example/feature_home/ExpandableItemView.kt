package com.example.feature_home

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ExpandableItemView(
    model: Expandable,
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    val transitionState = remember {
        MutableTransitionState(isExpanded).apply {
            targetState = !isExpanded
        }
    }

    val transition = updateTransition(transitionState = transitionState, label = "transition")

    val arrowRotationDegree by transition.animateFloat(
        {
            tween(durationMillis = 700)
        },
        label = "rotationDegreeTransition"
    ) {
        if (isExpanded) {
            0f
        } else {
            180f
        }
    }
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier.weight(weight = 0.85f)
            ) {
                Text(
                    text = "model.title",
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp)
                )
            }
            Column(
                modifier = Modifier.weight(0.15f)
            ) {
                CardArrow(
                    degrees = arrowRotationDegree,
                    onClick = onClick
                )
            }
        }
//        ExpandableContent(isExpanded = isExpanded)
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent(isExpanded: Boolean = true) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = 700,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(durationMillis = 700))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = 700,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(durationMillis = 700))
    }

    AnimatedVisibility(
        visible = isExpanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp)
        ) {
            Text(
                text = "Make It Easy Description",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                color = Color.Green
            )
        }
    }
}

@Composable
fun CardArrow(
    degrees: Float,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "Expandable Arrow",
                modifier = Modifier.rotate(degrees),
            )
        }
    )
}