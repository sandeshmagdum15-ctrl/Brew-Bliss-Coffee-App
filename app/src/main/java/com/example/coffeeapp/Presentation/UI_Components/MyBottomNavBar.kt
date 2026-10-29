package com.example.coffeeapp.Presentation.UI_Components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.Navigation.Routes
import com.example.coffeeapp.R
import com.example.coffeeapp.Presentation.theme.LightBrown


@Composable
fun MyBottomNavBar(navController: NavController, routes: String) {

    //Bottom Nav Items
    val navItem = listOf(
        NavItem("Home", R.drawable.regular_outline_home, Routes.HomeScreen),
        NavItem("Cart", R.drawable.regular_outline_bag, Routes.CartScreen),
        NavItem("Favourites", R.drawable.regular_outline_heart, Routes.FavouritesScreen),
        NavItem("Profile", R.drawable.outline_account_circle_24, Routes.ProfileScreen)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)
    ) {
        navItem.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                modifier = Modifier.size(30.dp),


                //handling bottom Bar navigation
                onClick = {
                    navController.navigate(item.routes){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },

                selected = item.title == routes,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightBrown.copy(0.03f)
                )
            )
        }

    }
}

data class NavItem(
    val title: String,
    val icon: Int,
    val routes: Routes
)