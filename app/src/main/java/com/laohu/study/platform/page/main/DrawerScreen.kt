package com.laohu.study.platform.page.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.laohu.study.platform.R
import com.laohu.study.platform.ui.theme.StudyPlatformTheme

@Composable
fun DrawerScreen() {
    Column {
        Text(text = stringResource(R.string.national_study_platform))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewDrawerScreen() {
    StudyPlatformTheme {
        DrawerScreen()
    }
}