package com.github.patrickpaul.jetpackcomposelab.animations.properties

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.github.patrickpaul.jetpackcomposelab.R
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.DefaultScaffold
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.VerticalSpacer
import com.github.patrickpaul.jetpackcomposelab.common.ui.theme.AppColors
import com.github.patrickpaul.jetpackcomposelab.common.util.flip
import kotlin.math.roundToInt

const val DESTINATION_ANIMATED_POSITION = "animated-position"

@Composable
fun AnimatedPositionScreen(
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
    val moved = remember { mutableStateOf(false) }
    val pxToMove = with(LocalDensity.current) { 50.dp.toPx().roundToInt() }

    val offset = animateIntOffsetAsState(
        targetValue = if (moved.value) {
            IntOffset(pxToMove, pxToMove)
        } else {
            IntOffset.Zero
        },
        label = "offset"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable { moved.flip() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(stringResource(id = R.string.information_tap_anywhere))

        VerticalSpacer()

        Box(
            modifier = Modifier
                .offset { offset.value }
                .size(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(AppColors.AndroidGreen)
        )
    }
}