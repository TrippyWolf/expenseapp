package com.example.sptrack.feature

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.sptrack.LocalTransactionViewModel
import com.example.sptrack.design.space.Spacing
import com.example.sptrack.ui.component.BarChart
import com.himanshoe.charty.common.ChartDataCollection
import com.himanshoe.charty.common.config.AxisConfig

@Composable
fun ChartScreen(navController: NavController){
    var dayWiseExpense by remember { mutableStateOf<List<ChartModel>>(emptyList()) }
    var categoryWiseExpense by remember { mutableStateOf<List<ChartModel>>(emptyList()) }
    val scrollState = rememberScrollState()

    val viewModel = LocalTransactionViewModel.current

    LaunchedEffect(Unit) {
        dayWiseExpense = viewModel.getDayWiseExpenseOnChart();
        categoryWiseExpense = viewModel.getCategoryWiseExpenseOnChart();
    }

    Surface(
        modifier = Modifier.padding(horizontal = Spacing.Spacing_16)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
             , // Fill the available size
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            if(dayWiseExpense.isNotEmpty()){
                BarChart(
                    dataCollection = ChartDataCollection(dayWiseExpense),
                )
            }

            if(categoryWiseExpense.isNotEmpty()) {
                BarChart(
                    dataCollection = ChartDataCollection(categoryWiseExpense),
                )
            }

            BackHandler {
                navController.popBackStack()
                // Optionally, show a dialog or perform any action here
                // Simply not calling popBackStack prevents back navigation
            }
        }
    }
}