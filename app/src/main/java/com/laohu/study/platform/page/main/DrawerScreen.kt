package com.laohu.study.platform.page.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laohu.study.platform.R
import com.laohu.study.platform.extensions.circle
import com.laohu.study.platform.model.DrawerMenu
import com.laohu.study.platform.ui.theme.StudyPlatformTheme

@Composable
fun DrawerScreen(onMenuChanged: (DrawerMenu) -> Unit) {
    val currentOnMenuChanged by rememberUpdatedState(newValue = onMenuChanged)
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .circle(50.dp, MaterialTheme.colors.primary)
        ) {
            Text(
                text = stringResource(R.string.app_name),
                color = Color.White,
                style = MaterialTheme.typography.h6
            )
        }
        Spacer(Modifier.height(20.dp))
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            var currentMenu by rememberSaveable { mutableStateOf(DrawerMenu.Platform) }
            DrawerMenu.values().forEach { menu ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray.copy(alpha = 0.5f))
                        .padding(start = 20.dp, end = 20.dp, bottom = 10.dp, top = 10.dp)
                        .apply {
                            if (currentMenu == menu) {
                                clickable {
                                    currentMenu = menu
                                    currentOnMenuChanged(menu)
                                }
                            }
                        },
                    text = stringResource(menu.text),
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewDrawerScreen() {
    StudyPlatformTheme {
        DrawerScreen(onMenuChanged = {

        })
    }
}