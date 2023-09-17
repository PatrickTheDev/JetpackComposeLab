package com.github.patrickpaul.jetpackcomposelab.common.ui.components

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.patrickpaul.jetpackcomposelab.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(
    @StringRes titleResId: Int,
    onBackNav: (() -> Unit)? = null,
) {
    TopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(stringResource(id = titleResId))
        },
        navigationIcon = {
            onBackNav?.let {
                IconButton(onClick = it) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultAppBarPreview() {
    DefaultAppBar(R.string.title_animations_screen)
}