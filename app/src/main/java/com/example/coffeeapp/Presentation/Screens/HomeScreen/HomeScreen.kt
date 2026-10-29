package com.example.coffeeapp.Presentation.Screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.Domain.Model.Product
import com.example.coffeeapp.R
import com.example.coffeeapp.Presentation.UI_Components.MyBottomNavBar

@Composable
fun HomeScreen(navController: NavController) {

    val location = "Rankala, Kolhapur"


    Scaffold(
        bottomBar = { MyBottomNavBar(navController, "Home") }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030), Color(0xFF1F1F1F), Color(0xFF121212)
                        )
                    )
                )

        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {


            //displying products
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

            ProductsGrid(products = products, navController = navController) {

                Text(
                    text = "Location", color = Color.LightGray, fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = location,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "ArrowDropDown",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))

                MySearchBar()

                Spacer(modifier = Modifier.height(40.dp))


                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Banner Image"
                )
                Spacer(modifier = Modifier.height(16.dp))

                HomeScreenCategoris()

            }
        }
    }
}