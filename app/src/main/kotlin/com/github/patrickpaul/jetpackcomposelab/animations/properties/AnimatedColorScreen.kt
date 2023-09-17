package com.github.patrickpaul.jetpackcomposelab.animations.properties

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.github.patrickpaul.jetpackcomposelab.R
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.DefaultAppBar
import com.github.patrickpaul.jetpackcomposelab.common.ui.theme.AppColors

const val DESTINATION_ANIMATED_COLOR = "animated-color"

@Composable
fun AnimatedColorScreen(
    onBackNav: () -> Unit,
) {
    Scaffold(
        topBar = {
            DefaultAppBar(
                titleResId = R.string.title_animated_color_screen,
                onBackNav = { onBackNav() },
            )
        }
    ) { innerPadding ->
        Content(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
) {
    val animateBackgroundColor = remember { mutableStateOf(true) }

    val animatedColor = animateColorAsState(
        if (animateBackgroundColor.value) AppColors.AndroidGreen else AppColors.AndroidBlue,
        label = "color"
    )

    Column(
        modifier = modifier
            .clickable { animateBackgroundColor.value = !animateBackgroundColor.value }
            .fillMaxSize()
            .drawBehind {
                drawRect(animatedColor.value)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.information_tap_anywhere),
            color = Color.Black,
        )
    }
}