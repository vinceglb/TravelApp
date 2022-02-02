package com.ebf.travelapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ebf.travelapp.ui.home.HomeTabs
import com.ebf.travelapp.ui.home.TravelAppBottomBar
import com.ebf.travelapp.ui.theme.TravelAppTheme

@Composable
fun TravelApp() {
    TravelAppTheme {
        val tabs = remember { HomeTabs.values() }
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { TravelAppBottomBar(tabs = tabs, navController = navController) }
        ) { innerPadding ->
            NavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
