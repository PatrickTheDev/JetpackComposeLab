package com.github.patrickpaul.jetpackcomposelab.animations.properties

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.patrickpaul.jetpackcomposelab.R
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.DefaultScaffold
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.VerticalSpacer
import com.github.patrickpaul.jetpackcomposelab.common.ui.theme.AppColors
import com.github.patrickpaul.jetpackcomposelab.common.util.flip

const val DESTINATION_ANIMATED_VISIBILITY = "animated-visibilty"

@Composable
fun AnimatedVisibilityScreen(
    onBackNav: () -> Unit,
) {
    DefaultScaffold(onBackNav = onBackNav) { innerPadding ->
        Content(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
) {
    val visible = remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable { visible.flip() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(stringResource(id = R.string.information_tap_anywhere))

        VerticalSpacer()

        AnimatedVisibility(visible.value) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(AppColors.AndroidGreen)
            )
        }

        VerticalSpacer()

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(AppColors.AndroidBlue)
        )
    }
}