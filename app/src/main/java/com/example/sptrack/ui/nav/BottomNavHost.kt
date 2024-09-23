package com.example.sptrack.ui.nav

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.sptrack.EXPENSE
import com.example.sptrack.INCOME
import com.example.sptrack.R
import com.example.sptrack.TransactionViewModel
import com.example.sptrack.design.SPTheme
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.components.SPIcon
import com.example.sptrack.design.space.Spacing
import com.example.sptrack.getCurrentRoute
import com.example.sptrack.ui.theme.SPTrackTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavHostScreen(onThemeChange: () -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }
    var showBar by remember { mutableStateOf(false) }
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            val currentRoute = getCurrentRoute(navController)
            if (currentRoute == Screen.Transaction.route || currentRoute == Screen.Chart.route) {
                showBar= false;
            }else{
                showBar =true;
                BottomAppBar(
                    modifier = Modifier
                        .height(100.dp)
                        .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                ) {
                    BottomNav(navController = navController)
                }
            }

        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            if(showBar) {
                MainFAB(isExpanded, navController) { isExpanded = !isExpanded }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        ) {

            MainScreenNavigation(navController,onThemeChange)

        }

    }
}

@Composable
fun MainFAB(isExpanded: Boolean, navController: NavController, onClick: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp), // Reduce padding at the bottom
        contentAlignment = Alignment.BottomCenter // Align the FAB with BottomAppBar
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (isExpanded) {
                Row(modifier = Modifier.padding(bottom = Spacing.Spacing_8)) {
                    AddIncomeFAB(navController,onClick = {
                        coroutineScope.launch {
                            onClick()
                            navController.navigate("${Screen.Transaction.onlyRoute}/${INCOME}") }
                        }
                      )
                    Spacer(modifier = Modifier.width(32.dp)) // Space between FABs
                    AddExpenseFAB(navController,onClick = {
                        coroutineScope.launch {
                            onClick()
                            navController.navigate("${Screen.Transaction.onlyRoute!!}/${EXPENSE}")
                        }
                      }
                    )
                }
            }
            FloatingActionButton(onClick = onClick , shape = CircleShape, containerColor = LocalColors.current.mainColors.violet.violet_100) {
                SPIcon(
                    tint = Color.White,
                    painter = painterResource( R.drawable.magicons_glyph_userinterface_close), contentDescription = "Option",
                    modifier = if (isExpanded) Modifier.rotate(0f) else Modifier.rotate(45f)
                )
            }
        }
    }
}

@Composable
fun AddIncomeFAB(navController: NavController , onClick: () -> Unit) {

    FloatingActionButton(onClick = onClick, shape = CircleShape, containerColor = LocalColors.current.mainColors.green.green_100) {
        SPIcon(
            tint =Color.White,
            painter = painterResource( R.drawable.magicons_glyph_finance_income), contentDescription = "Add income",
        )
    }
}

@Composable
fun AddExpenseFAB(navController: NavController,onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick , shape = CircleShape, containerColor =  LocalColors.current.mainColors.red.red_100) {
        SPIcon(
            tint = Color.White,
            painter = painterResource( R.drawable.magicons_glyph_finance_expense), contentDescription = "Add expense",
        )
    }
}