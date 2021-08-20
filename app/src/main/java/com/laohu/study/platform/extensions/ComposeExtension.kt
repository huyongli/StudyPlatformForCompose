package com.laohu.study.platform.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun Modifier.circle(radius: Dp, color: Color) =
    this.size(radius.times(2)).clip(RoundedCornerShape(radius)).background(color = color)