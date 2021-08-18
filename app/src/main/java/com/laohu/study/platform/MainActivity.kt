package com.laohu.study.platform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.laohu.study.platform.main.MainScreen
import com.laohu.study.platform.ui.theme.CourseStudyPlatformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseStudyPlatformTheme {
                MainScreen()
            }
        }
    }
}