package com.example.coffeeapp.Presentation.Screens.HomeScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Domain.Model.Product


@Composable
fun ProductsGrid(
    products: List<Product>,
    navController: NavController,
    topContent: @Composable () -> Unit,



) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {


        item {
            topContent()
        }

        items(
            products.chunked(2)
        ) { rowItems ->

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ProductCard(
                    product = rowItems[0], modifier = Modifier.weight(1f),
                    navController = navController

                )
                if (rowItems.size == 2) {
                    ProductCard(
                        product = rowItems[1], modifier = Modifier.weight(1f),
                                navController = navController
                    )

                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

        }
    }

}