package com.github.patrickpaul.jetpackcomposelab.start

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
import androidx.compose.ui.tooling.preview.Preview
import com.github.patrickpaul.jetpackcomposelab.R
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.DefaultAppBar
import com.github.patrickpaul.jetpackcomposelab.common.ui.theme.JetpackComposeLabTheme
import com.github.patrickpaul.jetpackcomposelab.start.StartScreenActions.*

const val DESTINATION_START = "start"

sealed class StartScreenActions {

    data object NavToAnimations : StartScreenActions()
}

@Composable
fun StartScreen(
    actions: (action: StartScreenActions) -> Unit,
) {
    Scaffold(
        topBar = {
            DefaultAppBar(titleResId = R.string.app_name)
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
    actions: (action: StartScreenActions) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { actions(NavToAnimations) }
        ) {
            Text("Animations")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    JetpackComposeLabTheme {
        StartScreen(
            actions = {}
        )
    }
}