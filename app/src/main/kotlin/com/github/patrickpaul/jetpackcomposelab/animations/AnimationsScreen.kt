package com.github.patrickpaul.jetpackcomposelab.animations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.patrickpaul.jetpackcomposelab.R
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.DefaultAppBar
import com.github.patrickpaul.jetpackcomposelab.animations.AnimationsScreenActions.*
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.VerticalSpacer

const val DESTINATION_ANIMATIONS_OVERVIEW = "animations-overview"

sealed class AnimationsScreenActions {

    data object BackNavigation : AnimationsScreenActions()

    data object NavToAnimatedVisibility : AnimationsScreenActions()
    data object NavToAnimatedColor : AnimationsScreenActions()
    data object NavToAnimatedSize : AnimationsScreenActions()
}

@Composable
fun AnimationsScreen(
    actions: (action: AnimationsScreenActions) -> Unit,
) {
    Scaffold(
        topBar = {
            DefaultAppBar(
                titleResId = R.string.title_animations_screen,
                onBackNav = { actions(BackNavigation) },
            )
        }
    ) { innerPadding ->
        Content(
            actions = actions,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
private fun Content(
    actions: (action: AnimationsScreenActions) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { actions(NavToAnimatedVisibility) }
        ) {
            Text("Animate appearing / disappearing")
        }

        VerticalSpacer()

        Button(
            onClick = { actions(NavToAnimatedColor) }
        ) {
            Text(text = "Animate color")
        }

        VerticalSpacer()

        Button(
            onClick = { actions(NavToAnimatedSize) }
        ) {
            Text(text = "Animate size")
        }
    }
}