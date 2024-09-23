package com.example.sptrack.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

val items = listOf(
    Screen.Home,
    Screen.Profile,
    Screen.History,
)

sealed class Screen(val route: String?, val title: String?, val icon: ImageVector?,val onlyRoute:String="") {
    object Home : Screen("home", "Home", Icons.Default.Home,"home")
    object Profile : Screen("profile", "Profile", Icons.Default.Person,"profile")
    object History : Screen("history", "History", Icons.Default.DateRange,"history")
    object Transaction : Screen("transaction/{type}", "Transaction", null,"transaction")
    object Chart : Screen("chart", "Chart", null,"chart")

}