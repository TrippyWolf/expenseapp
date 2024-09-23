package com.example.sptrack.feature


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sptrack.EXPENSE
import com.example.sptrack.LocalTransactionViewModel
import com.example.sptrack.R
import com.example.sptrack.database.Transaction
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.components.IconSize
import com.example.sptrack.design.components.SPIcon
import com.example.sptrack.design.components.text.SPText
import com.example.sptrack.design.space.Spacing
import com.example.sptrack.ui.component.BodyLarge
import com.example.sptrack.ui.component.BodyMedium
import com.example.sptrack.ui.component.FilterTransactionBottomSheet
import com.example.sptrack.ui.component.TransactionItem
import com.example.sptrack.ui.nav.Screen

@Composable
fun HistoryScreen(navController: NavController) {
    // Call the function to group transactions when this Composable is first composed
    val viewModel = LocalTransactionViewModel.current
    var showSheet by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.groupTransactionsByDate()
    }

    // Observe the grouped transactions
    val transactionsGroup = viewModel.transactionsGroup

    Surface(
        modifier = Modifier.padding(horizontal = Spacing.Spacing_16).padding(bottom = 32.dp)
    ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                ,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {


                Row(
                  modifier = Modifier.fillMaxWidth().align(Alignment.End)
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    SPIcon(painter = painterResource(R.drawable.magicons_glyph_userinterface_sort),
                        onClick = {
                            showSheet=!showSheet
                        }

                    )

                    SPIcon(painter = painterResource(R.drawable.magicons_glyph_finance_line_chart_2),
                        onClick = {
                            navController.navigate(Screen.Chart.route!!)
                        }

                    )
                }



                if (transactionsGroup.isEmpty()) {
                    BodyLarge(text="No History!", textColor = LocalColors.current.mainColors.dark.dark_100)
                }else{
                    TransactionList(transactionsGroup)
                }

                if(showSheet){
                    FilterTransactionBottomSheet( onDismiss = {showSheet =false})
                }
            }

    }
}

@Composable
fun TransactionList(transactionsGroup: Map<String, List<Transaction>>) {
    val viewModel = LocalTransactionViewModel.current;
    LazyColumn {
        transactionsGroup.forEach { (date, transactions) ->
            item {
                BodyMedium(
                    text = date,
                    textColor = LocalColors.current.mainColors.dark.dark_100
                )
            }
            transactions.forEach { transaction ->
                item {
                    val title = transaction.name
                    val desc = transaction.description ?: ""
                    val amount = transaction.amount.toString()
                    val time = transaction.timestamp.toString()

                    TransactionItem(
                        title = title,

                        subtitle = desc,
                        amount = amount,
                        transactionType = transaction.type,
                        time = time,
                        iconId = viewModel.getIconByCategoryId(transaction.categoryId),
                        onClick = {
                            viewModel.loadTransactionInViewModel(transaction)
                        }
                    )
                }
            }
        }
    }
}


