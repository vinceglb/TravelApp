package com.ebf.travelapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ebf.travelapp.ui.MainDestinations.PLACE_DETAIL_ID
import com.ebf.travelapp.ui.MainDestinations.PLACE_DETAIL_ROUTE
import com.ebf.travelapp.ui.home.HomeTabs
import com.ebf.travelapp.ui.home.addHomeGraph
import com.ebf.travelapp.ui.placedetail.PlaceDetailsScreen

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val PLACE_DETAIL_ROUTE = "place"
    const val PLACE_DETAIL_ID = "placeId"
}

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.HOME_ROUTE
) {
    val actions = remember { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        navigation(
            route = MainDestinations.HOME_ROUTE,
            startDestination = HomeTabs.FEED.route
        ) {
            addHomeGraph(
                navController = navController,
                navToPlaceDetail = { actions.navigateToPlaceDetail("temp") },
                modifier = modifier
            )
        }
        composable(
            route = "$PLACE_DETAIL_ROUTE/{$PLACE_DETAIL_ID}",
            arguments = listOf(
                navArgument(PLACE_DETAIL_ID) { type = NavType.StringType }
            )
        ) {
            PlaceDetailsScreen(
                navBack = { navController.navigateUp() },
                navigateToBookmark = { navController.navigate(HomeTabs.BOOKMARK.route) },
                modifier = modifier
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    val navigateToPlaceDetail = { placeId: String ->
        navController.navigate(route = "$PLACE_DETAIL_ROUTE/$placeId")
    }
}
