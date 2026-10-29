package com.example.coffeeapp.Presentation.Navigation

import kotlinx.serialization.Serializable

sealed class  Routes {

    @Serializable
    object WelcomeScreen: Routes()

    @Serializable
    object HomeScreen: Routes()


    @Serializable
    data class DetailScreen(val productId: Int): Routes()

    @Serializable
    object CartScreen: Routes()


    @Serializable
    object ProfileScreen: Routes()

    @Serializable
    object FavouritesScreen: Routes()



}