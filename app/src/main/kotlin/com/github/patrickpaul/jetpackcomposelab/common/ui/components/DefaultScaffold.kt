package com.github.patrickpaul.jetpackcomposelab.common.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.github.patrickpaul.jetpackcomposelab.R

@Composable
fun DefaultScaffold(
    onBackNav: () -> Unit,
    content: @Composable (innerPadding: PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = {
            DefaultAppBar(
                titleResId = R.string.title_animated_color_screen,
                onBackNav = { onBackNav() },
            )
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}