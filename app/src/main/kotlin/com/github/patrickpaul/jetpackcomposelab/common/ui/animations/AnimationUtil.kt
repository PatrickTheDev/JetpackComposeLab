package com.github.patrickpaul.jetpackcomposelab.common.ui.animations

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.IntOffset

fun defaultTween(): FiniteAnimationSpec<IntOffset> = tween(150)