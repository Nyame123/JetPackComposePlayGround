package com.bismark.feature.interests.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bismark.core.navigation.JPGNavigationDestination
import com.bismark.feature.interests.InterestsRoute

object InterestsDestination : JPGNavigationDestination {
    override val route = "interests_route"
    override val destination = "interests_destination"
}

fun NavGraphBuilder.interestsGraph(
    navigateToTopic: (String) -> Unit,
    navigateToAuthor: (String) -> Unit
) {
    composable(route = InterestsDestination.route) {
        InterestsRoute(
            navigateToTopic = navigateToTopic,
            navigateToAuthor = navigateToAuthor,
        )
    }
}
