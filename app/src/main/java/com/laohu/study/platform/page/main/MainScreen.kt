package com.laohu.study.platform.page.main

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.laohu.study.platform.ui.theme.StudyPlatformTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerScreen()
        }
    ) {

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewMainContent() {
    StudyPlatformTheme {
        MainScreen()
    }
}