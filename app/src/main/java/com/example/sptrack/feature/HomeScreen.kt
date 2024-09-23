package com.example.sptrack.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sptrack.LocalTransactionViewModel
import com.example.sptrack.R
import com.example.sptrack.database.Transaction
import com.example.sptrack.design.SPTheme
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.components.PillButton
import com.example.sptrack.design.components.PillButtonContainer
import com.example.sptrack.design.components.SPChip
import com.example.sptrack.design.space.Spacing
import com.example.sptrack.ui.component.AlignTextColumns
import com.example.sptrack.ui.component.BodyLarge
import com.example.sptrack.ui.component.BodyXSmall
import com.example.sptrack.ui.component.FinancialCard
import com.example.sptrack.ui.component.TitleMedium
import com.example.sptrack.ui.component.TitleX
import com.example.sptrack.ui.component.TransactionItem
import com.example.sptrack.ui.nav.Screen

@Composable
fun HomeScreen(navController: NavController) {

    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier.padding(horizontal = Spacing.Spacing_16)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize() // Fill the available size
                .verticalScroll(scrollState).
                padding(top=32.dp),// Enable vertical scrolling
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            AccountBalance()

            IncomeExpenseCard()

            RecentTransaction(navController)

        }
    }
}

@Composable
fun AccountBalance() {
    val viewModel = LocalTransactionViewModel.current
    var balance by remember { mutableStateOf<Double>(0.00) }
    var income by remember { mutableStateOf<Double>(0.00) }
    var expense by remember { mutableStateOf<Double>(0.00) }

    LaunchedEffect(Unit) {
        balance = viewModel.getTotalAccountBalance();
    }

    AlignTextColumns(
        modifier = Modifier.padding(bottom = Spacing.Spacing_16),
        horizontalAlignment = Alignment.CenterHorizontally,
        margin = 8.dp,
        text1 = {
            BodyXSmall(
                text = "Account Balance",
                textColor = LocalColors.current.mainColors.light.light_20,
            )
        },
        text2 = {
            TitleX(
                text = "$$balance",
                textColor = LocalColors.current.mainColors.dark.dark_100,

            )
        }
    )
}

@Composable
fun IncomeExpenseCard() {
    var expense by remember { mutableStateOf<String>("0") }
    var income by remember { mutableStateOf<String>("0") }

    val viewModel = LocalTransactionViewModel.current;
    LaunchedEffect(Unit){
              expense =  viewModel.getTotalExpense().toString()
              income =  viewModel.getTotalIncome().toString()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
    ) {
        FinancialCard(
            R.drawable.magicons_glyph_finance_income,
            LocalColors.current.mainColors.green.green_100,
            LocalColors.current.mainColors.light.light_80,
            "Income",
            "$$income",
            Modifier
                .weight(1f)
                .padding(end = Spacing.Spacing_8)
        )
        FinancialCard(
            R.drawable.magicons_glyph_finance_expense,
            LocalColors.current.mainColors.red.red_100,
            LocalColors.current.mainColors.light.light_80,
            "Expense",
            "$$expense",
            Modifier
                .weight(1f)
                .padding(start = Spacing.Spacing_8)
        )
    }
}


@Composable
fun RecentTransaction(navController: NavController) {
    var latestTransactions by remember { mutableStateOf<List<Transaction>>(emptyList()) }

    val viewModel = LocalTransactionViewModel.current;
    // LaunchedEffect to call the suspend function
    LaunchedEffect(Unit) {
        val transactions = viewModel.getLatestTransaction()
        latestTransactions = transactions
    }

    Column(
        verticalArrangement = Arrangement.Top, // Arranges the children in a compact way, from top to bottom
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TitleMedium(
                text = "Recent Transaction",
                textColor = SPTheme.colors.mainColors.dark.dark_20
                )
            SPChip(text = "See All", onClick = {}
            ,
                contentColor = SPTheme.colors.mainColors.violet.violet_100,
                backgroundColor = SPTheme.colors.mainColors.violet.violet_20,
            )
        }

        if(latestTransactions.isEmpty()){

            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 16.dp, horizontal = 8.dp)
            ){
                BodyLarge(textColor = LocalColors.current.mainColors.dark.dark_100, text = "No Recent Transaction Found")
            }
        }

        if(latestTransactions.size>=1) {

            TransactionItem(
                latestTransactions.get(0).name,
                latestTransactions.get(0).description,
                latestTransactions.get(0).amount.toString(),
                latestTransactions.get(0).timestamp.toString(),
                latestTransactions.get(0).type,

                viewModel.getIconByCategoryId(latestTransactions[0].categoryId),
                onClick = {
                    viewModel.loadTransactionInViewModel(latestTransactions[0])
                    navController.navigate("${Screen.Transaction.onlyRoute!!}/${latestTransactions.get(0).type}")
                }
            )
        }
        if(latestTransactions.size>=2) {

            TransactionItem(
                latestTransactions.get(1).name,
                latestTransactions.get(1).description,
                latestTransactions.get(1).amount.toString(),
                latestTransactions.get(1).timestamp.toString(),
                latestTransactions.get(1).type,

                viewModel.getIconByCategoryId(latestTransactions[1].categoryId),
                onClick = {
                    viewModel.loadTransactionInViewModel(latestTransactions.get(1))
                    navController.navigate("${Screen.Transaction.onlyRoute}/${latestTransactions.get(1).type}")
                }
            )
        }
        if(latestTransactions.size>=3) {

            TransactionItem(
                latestTransactions.get(2).name,
                latestTransactions.get(2).description,
                latestTransactions.get(2).amount.toString(),
                latestTransactions.get(2).timestamp.toString(),
                latestTransactions.get(2).type,
                viewModel.getIconByCategoryId(latestTransactions[2].categoryId),
                onClick = {
                    viewModel.loadTransactionInViewModel(latestTransactions.get(2))
                    navController.navigate("${Screen.Transaction.onlyRoute}/${latestTransactions.get(2).type}")
                }
            )
        }

    }
}