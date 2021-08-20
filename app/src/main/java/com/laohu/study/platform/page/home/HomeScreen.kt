package com.laohu.study.platform.page.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.laohu.study.platform.R
import com.laohu.study.platform.model.CoursePhase
import com.laohu.study.platform.page.home.viewmodel.HomeViewModel
import com.laohu.study.platform.ui.theme.StudyPlatformTheme
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerScreen(onMenuChanged = {})
        },
        topBar = {
            val scope = rememberCoroutineScope()
            MainTopAppBar(openDrawer = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        bottomBar = {
            MainBottomNavigation(onBottomNavItemChanged = {

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
                Icon(Icons.Filled.Menu, "")
            }
        },
    )
}

@Composable
fun MainBottomNavigation(
    onBottomNavItemChanged: (CoursePhase) -> Unit,
    homeViewModel: HomeViewModel = viewModel()
) {
    val currentOnBottomNavItemChanged by rememberUpdatedState(onBottomNavItemChanged)
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White
    ) {
        val phases by homeViewModel.coursePhase.observeAsState(emptyList())
        var currentIndex by rememberSaveable { mutableStateOf(0) }
        phases.forEachIndexed { index, phase ->
            BottomNavigationItem(
                icon = { Icon(painterResource(R.drawable.ic_school), "") },
                label = { Text(text = phase.phaseName) },
                selected = currentIndex == index,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                onClick = {
                    if (currentIndex != index) {
                        currentIndex = index
                        currentOnBottomNavItemChanged(phase)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewMainContent() {
    StudyPlatformTheme {
        MainScreen()
    }
}