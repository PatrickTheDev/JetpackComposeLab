package com.github.patrickpaul.jetpackcomposelab.animations.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.github.patrickpaul.jetpackcomposelab.animations.AnimationsScreenActions.*
import com.github.patrickpaul.jetpackcomposelab.animations.AnimationsScreen
import com.github.patrickpaul.jetpackcomposelab.animations.DESTINATION_ANIMATIONS_OVERVIEW
import com.github.patrickpaul.jetpackcomposelab.animations.properties.AnimatedColorScreen
import com.github.patrickpaul.jetpackcomposelab.animations.properties.AnimatedPositionScreen
import com.github.patrickpaul.jetpackcomposelab.animations.properties.AnimatedSizeScreen
import com.github.patrickpaul.jetpackcomposelab.animations.properties.AnimatedVisibilityScreen
import com.github.patrickpaul.jetpackcomposelab.animations.properties.DESTINATION_ANIMATED_COLOR
import com.github.patrickpaul.jetpackcomposelab.animations.properties.DESTINATION_ANIMATED_POSITION
import com.github.patrickpaul.jetpackcomposelab.animations.properties.DESTINATION_ANIMATED_SIZE
import com.github.patrickpaul.jetpackcomposelab.animations.properties.DESTINATION_ANIMATED_VISIBILITY

const val ROUTE_ANIMATIONS = "animations"

fun NavGraphBuilder.animationsGraph(navController: NavController) =
    navigation(
        route = ROUTE_ANIMATIONS,
        startDestination = DESTINATION_ANIMATIONS_OVERVIEW
    ) {
        composable(DESTINATION_ANIMATIONS_OVERVIEW) {
            AnimationsScreen(
                actions = { action ->
                    when (action) {
                        is BackNavigation -> navController.navigateUp()
                        is NavToAnimatedVisibility -> navController.navigate(DESTINATION_ANIMATED_VISIBILITY)
                        is NavToAnimatedColor -> navController.navigate(DESTINATION_ANIMATED_COLOR)
                        is NavToAnimatedSize -> navController.navigate(DESTINATION_ANIMATED_SIZE)
                        is NavToAnimatedPosition -> navController.navigate(DESTINATION_ANIMATED_POSITION)
                    }
                }
            )
        }

        composable(DESTINATION_ANIMATED_VISIBILITY) {
            AnimatedVisibilityScreen {
                navController.navigateUp()
            }
        }

        composable(DESTINATION_ANIMATED_COLOR) {
            AnimatedColorScreen {
                navController.navigateUp()
            }
        }

        composable(DESTINATION_ANIMATED_SIZE) {
            AnimatedSizeScreen {
                navController.navigateUp()
            }
        }

        composable(DESTINATION_ANIMATED_POSITION) {
            AnimatedPositionScreen {
                navController.navigateUp()
            }
        }
    }