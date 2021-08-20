package com.laohu.study.platform.page.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.accompanist.insets.ProvideWindowInsets
import com.laohu.study.platform.page.home.ui.HomeScreen
import com.laohu.study.platform.ui.theme.StudyPlatformTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvideWindowInsets {
                StudyPlatformTheme {
                    HomeScreen()
                }
            }
        }
    }
}