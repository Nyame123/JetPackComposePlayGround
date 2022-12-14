package com.bismark.feature.foryou.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bismark.core.navigation.JPGNavigationDestination
import com.bismark.feature.foryou.ForYouRoute

object ForYouDestination : JPGNavigationDestination {

    override val route = "for_you_route"
    override val destination = "for_you_destination"
}

fun NavGraphBuilder.forYouGraph(
    windowSizeClass: WindowSizeClass
){
    composable(route = ForYouDestination.route){
        ForYouRoute(windowSizeClass)
    }
}
