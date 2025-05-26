package com.PreParcial.C00367123.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.PreParcial.C00367123.data.model.petList
import com.PreParcial.C00367123.ui.screens.DetailScreen
import com.PreParcial.C00367123.ui.screens.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                onPetClick = { pet ->
                    navController.navigate("detail/${pet.id}")
                }
            )
        }

        composable(
            "detail/{petId}",
            arguments = listOf(navArgument("petId") { type = NavType.IntType })
        ) { backStackEntry ->
            val petId = backStackEntry.arguments?.getInt("petId")
            val pet = petList.find { it.id == petId }

            if (pet != null) {
                DetailScreen(pet = pet, navController = navController)
            } else {
                navController.popBackStack()
            }
        }
    }
}
