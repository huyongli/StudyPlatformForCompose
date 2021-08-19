package com.laohu.study.platform.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


private val colors =
    listOf(Color.Red, Color.Transparent, Color.Blue, Color.Yellow, Color.Green, Color.Magenta)

private fun getColor(index: Int): Color {
    val actualIndex = index % colors.size
    return colors[actualIndex]
}

@Composable
fun Loading() {
    var state by remember {
        mutableStateOf(0f)
    }
    LaunchedEffect(state) {
        delay(500)
        state += 1
    }
    val factor by animateFloatAsState(targetValue = state)
    LoadingScreen(6.dp, 6.dp, factor)
}

@Composable
private fun LoadingScreen(radius: Dp, space: Dp, factor: Float) {
    val width: Dp = radius.times(2).times(2).plus(space)
    val height: Dp = radius.times(2).times(3).plus(space.times(2))
    Canvas(modifier = Modifier.size(width, height)) {
        drawCircle(
            color = getColor(0),
            radius = radius.toPx(),
            center = calOffset(radius, space, factor)
        )
        drawCircle(
            color = getColor(1),
            radius = radius.toPx(),
            center = calOffset(radius, space, factor + 1)
        )
        drawCircle(
            color = getColor(2),
            radius = radius.toPx(),
            center = calOffset(radius, space, factor + 2)
        )
        drawCircle(
            color = getColor(3),
            radius = radius.toPx(),
            center = calOffset(radius, space, factor + 3)
        )
        drawCircle(
            color = getColor(4),
            radius = radius.toPx(),
            center = calOffset(radius, space, factor + 4)
        )
        drawCircle(
            color = getColor(5),
            radius = radius.toPx(),
            center = calOffset(radius, space, factor + 5)
        )
    }
}

private fun DrawScope.calOffset(radius: Dp, space: Dp, factor: Float): Offset {
    val distance = radius.times(2).plus(space)
    val step = distance.times(factor - factor.toInt())
    return when (factor.toInt() % 6) {
        0 -> {
            Offset(radius.plus(step).toPx(), radius.toPx())
        }
        1 -> {
            Offset(
                radius.times(3).plus(space).toPx(),
                radius.plus(step).toPx()
            )
        }
        2 -> {
            Offset(
                radius.times(3).plus(space).toPx(),
                radius.times(3).plus(space).plus(step).toPx()
            )
        }
        3 -> {
            Offset(
                radius.times(3).plus(space).minus(step).toPx(),
                radius.times(5).plus(space.times(2)).toPx()
            )
        }
        4 -> {
            Offset(
                radius.toPx(),
                radius.times(5).plus(space.times(2).minus(step)).toPx()
            )
        }
        else -> {
            Offset(
                radius.toPx(),
                radius.times(3).plus(space).minus(step).toPx()
            )
        }
    }
}

@Preview
@Composable
private fun PreviewLoading() {
    LoadingScreen(10.dp, 10.dp, 0f)
}