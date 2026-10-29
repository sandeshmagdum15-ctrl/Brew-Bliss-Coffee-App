package com.example.coffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.coffeeapp.Presentation.Navigation.NavGraph
import com.example.coffeeapp.Presentation.Screens.CartScreen.CartScreen
import com.example.coffeeapp.Presentation.Screens.DetailsScreen.DetailsScreen
import com.example.coffeeapp.Presentation.Screens.HomeScreen.HomeScreen
import com.example.coffeeapp.Presentation.Screens.favouritesScreen.FavouritesScreen
import com.example.coffeeapp.Presentation.theme.CoffeeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeAppTheme {

                NavGraph()
            }
        }
    }
}


