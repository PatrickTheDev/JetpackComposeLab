package com.github.patrickpaul.jetpackcomposelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.patrickpaul.jetpackcomposelab.animations.DESTINATION_ANIMATIONS_OVERVIEW
import com.github.patrickpaul.jetpackcomposelab.animations.navigation.ROUTE_ANIMATIONS
import com.github.patrickpaul.jetpackcomposelab.animations.navigation.animationsGraph
import com.github.patrickpaul.jetpackcomposelab.common.ui.theme.JetpackComposeLabTheme
import com.github.patrickpaul.jetpackcomposelab.start.DESTINATION_START
import com.github.patrickpaul.jetpackcomposelab.start.StartScreen
import com.github.patrickpaul.jetpackcomposelab.start.StartScreenActions.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            JetpackComposeLabTheme {
                NavHost(
                    navController = navController,
                    startDestination = DESTINATION_START
                ) {
                    composable(DESTINATION_START) {
                        StartScreen(
                            actions = { action ->
                                when (action) {
                                    NavToAnimations -> { navController.navigate(DESTINATION_ANIMATIONS_OVERVIEW) }
                                }
                            }
                        )
                    }

                    animationsGraph(navController)
                }
            }
        }
    }
}