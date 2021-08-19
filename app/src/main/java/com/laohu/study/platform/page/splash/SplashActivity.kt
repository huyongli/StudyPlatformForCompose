package com.laohu.study.platform.page.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.laohu.study.platform.ui.component.Loading
import com.laohu.study.platform.ui.theme.StudyPlatformTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            StudyPlatformTheme {
                SplashScreen()
            }
        }
    }
}

@Composable
fun SplashScreen() {
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            Loading()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSplashScreen() {
    StudyPlatformTheme {
        SplashScreen()
    }
}