package com.laohu.study.platform.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

private const val ANIMATION_DURATION = 300

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandablePanel(
    expanded: Boolean = false,
    animationDurationMillis: Int = ANIMATION_DURATION,
    onExpandChanged: ((Boolean) -> Unit)? = null,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    val duration by rememberUpdatedState(animationDurationMillis)
    var currentExpanded by remember { mutableStateOf(expanded) }
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = duration,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(duration))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = duration,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(duration))
    }
    Column {
        Box(modifier = Modifier.clickable {
            currentExpanded = !currentExpanded
            onExpandChanged?.invoke(currentExpanded)
        }) {
            header.invoke()
        }
        AnimatedVisibility(
            visible = currentExpanded,
            enter = enterExpand.plus(enterFadeIn),
            exit = exitCollapse.plus(exitFadeOut),
        ) {
            content.invoke()
        }
    }
}

@Composable
fun ExpandableArrowPanel(
    expanded: Boolean = false,
    animationDurationMillis: Int = ANIMATION_DURATION,
    isArrowLeft: Boolean = false,
    arrow: @Composable () -> Unit = @Composable {
        Icon(Icons.Sharp.KeyboardArrowRight, "")
    },
    headerModifier: Modifier = Modifier,
    headerContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    val defaultExpanded by rememberUpdatedState(expanded)
    val duration by rememberUpdatedState(animationDurationMillis)
    val arrowLeft by rememberUpdatedState(isArrowLeft)
    var currentExpanded by remember { mutableStateOf(expanded) }
    val rotate by animateFloatAsState(if (!currentExpanded) 0f else 90f)
    ExpandablePanel(
        expanded = defaultExpanded,
        animationDurationMillis = duration,
        onExpandChanged = {
            currentExpanded = it
        },
        header = {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = headerModifier) {
                if (arrowLeft) {
                    Box(Modifier.rotate(rotate)) {
                        arrow.invoke()
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
                headerContent.invoke()
                if (!arrowLeft) {
                    Spacer(modifier = Modifier.weight(1f))
                    Box(Modifier.rotate(rotate)) {
                        arrow.invoke()
                    }
                }
            }
        },
        content = content
    )
}