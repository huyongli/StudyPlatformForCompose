package com.laohu.study.platform.page.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.laohu.study.platform.extensions.handled
import com.laohu.study.platform.helper.DBHelper
import com.laohu.study.platform.page.main.MainActivity
import com.laohu.study.platform.ui.component.Loading
import com.laohu.study.platform.ui.theme.StudyPlatformTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    @Inject
    lateinit var dbHelper: DBHelper
    @Inject
    lateinit var coroutineScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyPlatformTheme {
                SplashScreen()
            }
        }
        coroutineScope.launch {
            try {
                dbHelper.initializeDatabase()
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            } catch (throwable: Throwable) {
                throwable.handled()
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