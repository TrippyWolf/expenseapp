package com.example.sptrack.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.sptrack.TransactionViewModel
import com.example.sptrack.feature.ChartScreen
import com.example.sptrack.feature.HistoryScreen
import com.example.sptrack.feature.HomeScreen
import com.example.sptrack.feature.ProfileScreen
import com.example.sptrack.feature.TransactionScreen


@Composable
fun MainScreenNavigation(navController: NavHostController,onThemeChange: () -> Unit) {

    NavHost(navController, startDestination = Screen.Home.route!!) {

        //Home
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.Transaction.route!!,
            arguments = listOf(navArgument("type") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            // Retrieve the argument 'itemId'
            val type = navBackStackEntry.arguments?.getString("type")
            TransactionScreen(navController, type!!)
        }

        //Profile
        composable(Screen.Profile.route!!) {
              ProfileScreen(onThemeChange)
        }

        //History
        composable(Screen.History.route!!) {
            HistoryScreen(navController)
        }
        //History
        composable(Screen.Chart.route!!) {
            ChartScreen(navController)
        }
    }


}
