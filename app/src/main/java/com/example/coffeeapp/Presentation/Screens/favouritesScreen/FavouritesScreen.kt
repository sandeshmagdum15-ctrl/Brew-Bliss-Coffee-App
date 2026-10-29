package com.example.coffeeapp.Presentation.Screens.favouritesScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Domain.Model.Product
import com.example.coffeeapp.Presentation.Screens.DetailsScreen.FavouritesScreenTopBar
import com.example.coffeeapp.Presentation.UI_Components.MyBottomNavBar
import com.example.coffeeapp.R
import kotlin.random.Random


@Composable
fun FavouritesScreen(navController: NavController) {

    var favouritesItems by remember {

        mutableStateOf(
            listOf(

                Product(
                    id = 1,
                    name = "Espresso",
                    description = "strong And rich",
                    price = 10.0,
                    imageRes = R.drawable.coffee_2
                ), Product(
                    id = 2,
                    name = "Latte",
                    description = "smooth and Creamy",
                    price = 20.0,
                    imageRes = R.drawable.coffee_3
                ), Product(
                    id = 3,
                    name = "Cappuccino ",
                    description = "With Chocklate",
                    price = 30.0,
                    imageRes = R.drawable.coffee_1
                )

            )

        )
    }

    Scaffold(
        topBar = { FavouritesScreenTopBar() },
        bottomBar = { MyBottomNavBar(navController = navController, "Favourites") }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {

            item {
                favouritesItems.forEach { product ->
                    FavouritesItemCard(
                        product,
                        onRemove = { favouritesItems = favouritesItems - product }

                    )
                }

            }
        }
    }

}