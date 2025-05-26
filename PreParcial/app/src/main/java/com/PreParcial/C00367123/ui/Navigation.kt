package com.PreParcial.C00367123.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.PreParcial.C00367123.data.model.Pet
import com.PreParcial.C00367123.ui.screens.DetailScreen
import com.PreParcial.C00367123.ui.screens.HomeScreen
import com.google.gson.Gson

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                onPetClick = { pet ->
                    val petJson = Gson().toJson(pet)
                    navController.navigate("detail/$petJson")
                }
            )
        }

        composable(
            "detail/{pet}",
            arguments = listOf(navArgument("pet") { type = NavType.StringType })
        ) { backStackEntry ->
            val petJson = backStackEntry.arguments?.getString("pet")
            val pet = Gson().fromJson(petJson, Pet::class.java)
            DetailScreen(pet = pet)
        }
    }
}
