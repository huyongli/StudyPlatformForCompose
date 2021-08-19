package com.laohu.study.platform.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val primary = Color(0xFF0171C5)
private val primary_variant = Color(0xFF0171C5)
private val secondary = Color(0xFF0171C5)

private val DarkColorPalette = darkColors(
    primary = primary,
    primaryVariant = primary_variant,
    secondary = secondary
)

private val LightColorPalette = lightColors(
    primary = primary,
    primaryVariant = primary_variant,
    secondary = secondary
)

@Composable
fun StudyPlatformTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}