package com.ebf.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelApp()
        }
    }
}

//@Composable
//fun TravelApp() {
//    val allScreens = listOf(
//        TravelAppScreen(label = "Home", icon = Icons.Rounded.Home),
//        TravelAppScreen(label = "Search", icon = Icons.Rounded.Search),
//        TravelAppScreen(label = "Bookmark", icon = Icons.Rounded.Bookmark),
//        TravelAppScreen(label = "Account", icon = Icons.Rounded.Person)
//    )
//    var currentScreen by rem
//
//    TravelAppTheme {
//        Scaffold(
//            bottomBar = {
//                TravelAppBottomNav(
//                    allScreens = allScreens,
//                    onScreenSelected = { navigateTo(it.label) },
//                    currentScreen = allScreens.first()
//                )
//            }
//        ) {
//
//        }
//    }
//}


