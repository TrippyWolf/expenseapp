package com.example.sptrack.ui.nav

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.components.SPIcon
import com.example.sptrack.ui.component.BodySmall
import com.example.sptrack.ui.component.BodyXSmall


@Composable
fun BottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    NavigationBar(
        modifier = Modifier
            .padding(12.dp, 0.dp, 12.dp, 0.dp)
            .height(60.dp),
        tonalElevation = 0.dp
    ) {
        items.forEach {
            NavigationBarItem(
                icon = {
                    it.icon?.let {
                        SPIcon(
                            painter = rememberVectorPainter(it),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp),
                            tint = LocalColors.current.mainColors.light.light_20
                        )
                    }
                },
                label = {
                    it.title?.let {
                        BodyXSmall(
                            text = it,
                            textColor = Color.Gray
                        )
                    }
                },
                selected = navController.currentDestination?.route == it.route,
                colors = NavigationBarItemDefaults.colors()
                    .copy(selectedIconColor = LocalColors.current.mainColors.violet.violet_100, selectedTextColor =  LocalColors.current.mainColors.violet.violet_100),
                onClick = {
                    it.route?.let { it1 ->
                        navController.navigate(it1) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
//                            launchSingleTop = true
//                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}