package com.example.coffeeapp.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.coffeeapp.Presentation.Screens.CartScreen.CartScreen
import com.example.coffeeapp.Presentation.Screens.DetailsScreen.DetailsScreen
import com.example.coffeeapp.Presentation.Screens.HomeScreen.HomeScreen
import com.example.coffeeapp.Presentation.Screens.ProfileScreen.ProfileScreen
import com.example.coffeeapp.Presentation.Screens.WelcomeScreen.WelcomeScreen
import com.example.coffeeapp.Presentation.Screens.favouritesScreen.FavouritesScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen ) {

        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Routes.DetailScreen> { backStackEntry ->

            val args = backStackEntry.toRoute<Routes.DetailScreen>()
            DetailsScreen(productId = args.productId, navController)
        }

        composable<Routes.CartScreen> {
            CartScreen(navController)
        }

        composable<Routes.FavouritesScreen> {
            FavouritesScreen(navController)
        }

        composable<Routes.ProfileScreen> {
            ProfileScreen(navController)
        }
    }
}