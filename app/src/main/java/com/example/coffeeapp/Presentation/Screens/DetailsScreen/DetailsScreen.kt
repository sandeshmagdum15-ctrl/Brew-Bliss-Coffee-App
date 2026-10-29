package com.example.coffeeapp.Presentation.Screens.DetailsScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.coffeeapp.Domain.Model.Product
import com.example.coffeeapp.R


@Composable
fun DetailsScreen(productId: Int, navController: NavController) {
    val products = listOf(

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
        ), Product(
            id = 4,
            name = "Moccha",
            description = "With Coca Flavour",
            price = 40.0,
            imageRes = R.drawable.coffee_4
        ), Product(
            id = 5,
            name = "Macchiato",
            description = "Bold and Milky",
            price = 50.0,
            imageRes = R.drawable.coffee_5
        ), Product(
            id = 6,
            name = "Flat White",
            description = "Valventy Smooth",
            price = 60.0,
            imageRes = R.drawable.coffee_6
        ), Product(
            id = 7,
            name = "Iced Mocha",
            description = "Refreshing and smooth",
            price = 70.0,
            imageRes = R.drawable.coffee_4
        )

    )

    val selectedProduct = products.find { it.id == productId }

    if (selectedProduct == null){
        Text(text= "Product not found!", color = Color.Red)
        return
    }
    Scaffold(
        topBar = { DetailsScreenTopAppBar(navController) },
        bottomBar = { DetailsScreenBottomBar(selectedProduct) }
    ) { innerPadding ->

        LazyColumn {
            item {


                    ProductDetailsContent(
                        selectedProduct,
                        innerPadding
                    )

            }
        }

    }
}