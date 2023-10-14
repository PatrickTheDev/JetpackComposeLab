package com.github.patrickpaul.jetpackcomposelab.common.util

import androidx.compose.runtime.MutableState

fun MutableState<Boolean>.flip() {
    this.value = !this.value
}