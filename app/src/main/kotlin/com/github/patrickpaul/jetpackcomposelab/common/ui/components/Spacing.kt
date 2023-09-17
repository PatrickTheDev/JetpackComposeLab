package com.github.patrickpaul.jetpackcomposelab.common.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpacer(
    spacing: Dp = 8.dp,
) {
    Spacer(modifier = Modifier.padding(top = spacing))
}

@Composable
fun HorizontalSpacer(
    spacing: Dp = 8.dp,
) {
    Spacer(modifier = Modifier.padding(end = spacing))
}

