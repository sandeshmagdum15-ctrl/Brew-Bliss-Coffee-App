package com.example.coffeeapp.Presentation.Screens.CartScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.Domain.Model.Product
import com.example.coffeeapp.Presentation.Navigation.Routes
import com.example.coffeeapp.Presentation.Screens.DetailsScreen.CartScreenTopBar
import com.example.coffeeapp.Presentation.UI_Components.MyBottomNavBar
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.R


@Composable
fun CartScreen(navController: NavController) {

    val cartProducts = listOf(

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

    var amount by remember { mutableStateOf(12.50) }
    var charges by remember { mutableStateOf(1.50) }
    var totalAmount by remember { mutableStateOf(amount + charges) }

    Scaffold(
        topBar = { CartScreenTopBar() },
        bottomBar = { MyBottomNavBar(navController = navController, "cart") }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .padding(innerPadding)
        ) {
            item {

                Row() {
                    Text(
                        text = "Delivery ",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                cartProducts.forEach { product ->
                    CartItemCard(product)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Payment Summary",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Price",
                        fontSize = 18.sp
                    )

                    Text(
                        text = "$ $amount",
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Delivery Charges",
                        fontSize = 18.sp
                    )
                    Text(
                        text = "$ $charges",
                        fontSize = 18.sp
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                PaymentModeSelectionCard(totalAmount)
            }

        }
    }

}