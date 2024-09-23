package com.example.sptrack.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sptrack.LocalTransactionViewModel
import com.example.sptrack.design.SPTheme
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.components.SPChip

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun FilterTransactionBottomSheet(
    modifier: Modifier = Modifier,
//    onApplyFilter: () -> Unit,
    onDismiss: () -> Unit={}
) {

    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        FilterContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterContent(

) {
    val viewModel = LocalTransactionViewModel.current;
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Header with Reset Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TitleMedium(
                text = "Filter Transaction",
                textColor = LocalColors.current.mainColors.dark.dark_100
            )
        }


        Spacer(modifier = Modifier.height(8.dp))

        // Filter By Section
        TitleSmall(text = "Filter By", textColor = LocalColors.current.mainColors.dark.dark_100)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            FilterButton("Income", selected = false) {
                viewModel.applyFilterOnTransaction(viewModel::selectIncomeHistory)

            }
            FilterButton("Expense", selected = true) {                 viewModel.applyFilterOnTransaction(viewModel::selectExpenseHistory)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sort By Section
        TitleSmall(text = "Sort By",  textColor = LocalColors.current.mainColors.dark.dark_100)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            FilterButton("Title", selected = false) {
                viewModel.applyFilterOnTransaction(viewModel::sortByTitle)
            }

            FilterButton("Category", selected = false) {
                viewModel.applyFilterOnTransaction(viewModel::sortByCategory)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun FilterButton(text: String, selected: Boolean, onClick: () -> Unit) {
    SPChip(text = text, onClick = onClick,
        contentColor = SPTheme.colors.mainColors.violet.violet_100,
        backgroundColor = if(selected) LocalColors.current.mainColors.green.green_20 else LocalColors.current.mainColors.violet.violet_20,
    )

}
