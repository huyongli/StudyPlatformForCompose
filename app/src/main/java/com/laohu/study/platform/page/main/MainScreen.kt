package com.laohu.study.platform.page.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.laohu.study.platform.R
import com.laohu.study.platform.ui.theme.StudyPlatformTheme
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerScreen()
        },
        topBar = {
            val scope = rememberCoroutineScope()
            MainTopAppBar(openDrawer = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        content = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "MainScreen", color = Color.Black)
            }
        }
    )
}

@Composable
fun MainTopAppBar(openDrawer: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.national_study_platform),
                style = MaterialTheme.typography.subtitle1
            )
        },
        navigationIcon = {
            IconButton(onClick = openDrawer) {
                Icon(Icons.Filled.Menu, null)
            }
        },
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewMainContent() {
    StudyPlatformTheme {
        MainScreen()
    }
}