package com.example.sptrack

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun getCurrentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

const val INCOME = "income"
const val EXPENSE = "expense"


fun formatDate(timeStamp: Date):String{
    return SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(timeStamp)
}

fun formatDate(timeStamp: String):String{
    return SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date(timeStamp))
}

