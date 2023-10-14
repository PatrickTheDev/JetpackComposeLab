package com.github.patrickpaul.jetpackcomposelab.animations.properties

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
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
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.DefaultAppBar
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.DefaultScaffold
import com.github.patrickpaul.jetpackcomposelab.common.ui.components.VerticalSpacer
import com.github.patrickpaul.jetpackcomposelab.common.ui.theme.AppColors
import com.github.patrickpaul.jetpackcomposelab.common.util.flip

const val DESTINATION_ANIMATED_SIZE = "animated-size"

@Composable
fun AnimatedSizeScreen(
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
    val expanded = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable { expanded.flip() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(stringResource(id = R.string.information_tap_anywhere))

        VerticalSpacer()

        Box(
            modifier = Modifier
                .animateContentSize()
                .width(200.dp)
                .height( if (expanded.value) 400.dp else 200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(AppColors.AndroidGreen)
        )
    }
}
