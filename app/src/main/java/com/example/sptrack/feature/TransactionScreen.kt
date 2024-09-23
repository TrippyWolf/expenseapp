package com.example.sptrack.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sptrack.EXPENSE
import com.example.sptrack.INCOME
import com.example.sptrack.LocalTransactionViewModel
import com.example.sptrack.R
import com.example.sptrack.TransactionViewModel
import com.example.sptrack.database.getAccountName
import com.example.sptrack.database.getCategoryName
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.components.SPButton
import com.example.sptrack.design.components.SPDropdownMenu
import com.example.sptrack.design.components.SPIcon
import com.example.sptrack.design.components.SPOutlinedTextField
import com.example.sptrack.design.components.SPTextField
import com.example.sptrack.design.components.text.SPText
import com.example.sptrack.design.shape.SPShapes
import com.example.sptrack.design.space.Spacing
import com.example.sptrack.design.typography.textStyles
import com.example.sptrack.ui.component.BodyMedium
import com.example.sptrack.ui.component.TitleMedium
import com.example.sptrack.ui.nav.items


@Composable
fun TransactionScreen(navController: NavController, type1: String) {
    val viewModel = LocalTransactionViewModel.current

    val type  = if(viewModel.transactionType ==null)type1 else viewModel.transactionType!!
    val screenColor  = if(type== INCOME) LocalColors.current.mainColors.green.green_80  else LocalColors.current.mainColors.red.red_80

    Surface (
        color = screenColor,
        modifier = Modifier.background(screenColor)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize().padding(top=32.dp), // Fill the available size
            verticalArrangement = Arrangement.SpaceBetween,

            ) {

            TransactionAmountInput(navController)

            TransactionDetailInput(type,navController)

        }
    }
}

@Composable
fun TransactionAmountInput(navController: NavController) {
    val viewModel = LocalTransactionViewModel.current
    var textValue by remember { mutableStateOf(viewModel.amount.value) }

    Column(verticalArrangement = Arrangement.SpaceAround){
        Row(
            modifier =  Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            BodyMedium("How much")

            SPIcon(
                painter = painterResource(R.drawable.magicons_glyph_userinterface_trash)
                , onClick = {
                    viewModel.deleteTransaction()
                    navController.popBackStack()
                }
            )
        }


        SPTextField(value = textValue, label = "", onValueChange = {
            textValue = it
            viewModel.addAmount(textValue)
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
    }

}


@Composable
fun TransactionDetailInput(type: String,navController: NavController) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(color = LocalColors.current.mainColors.light.light_100),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            CategorySelection(type)

            Title()

            Description()

            AccountSelection()

            RecordTransaction(type,navController)
        }

    }
}

@Composable
fun CategorySelection(type: String) {
    val itemList = getCategoryName(type)
    val viewModel = LocalTransactionViewModel.current
    SPDropdownMenu(items = itemList, onItemChanged = { newValue -> viewModel.addCategoryId(newValue) }, label = "Category"
    , modifier = Modifier.padding(top = 16.dp),
        initialItem =viewModel.getNameByCategoryId( viewModel.categoryId.value)
    )
}
@Composable
fun Title() {
    val viewModel = LocalTransactionViewModel.current

    var textFieldValue by remember { mutableStateOf(TextFieldValue(viewModel.name.value)) }
    SPOutlinedTextField(
        value = textFieldValue,
        onValueChange = { textFieldValue = it
                        viewModel.addName(it.text)},
        label = "Title",
        modifier =  Modifier.padding(top = 16.dp)
    )
}

@Composable
fun Description() {
    val viewModel = LocalTransactionViewModel.current;
    var textFieldValue by remember { mutableStateOf(TextFieldValue(viewModel.description.value)) }
    SPOutlinedTextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValue = it
            viewModel.addDescription(it.text)},
        label = "Description",
        modifier =  Modifier.padding(top = 16.dp)
    )
}


@Composable
fun AccountSelection() {
    val viewModel = LocalTransactionViewModel.current;

    val itemList = getAccountName()
    SPDropdownMenu(items = itemList, onItemChanged = { newValue ->

viewModel.addAccountId(newValue)

    }, label = "Account", modifier =  Modifier.padding(top = 16.dp, bottom = 32.dp)
    , initialItem = viewModel.getNameByAccountId(viewModel.accountId.value)
    )
}

@Composable
fun RecordTransaction(type:String,navController: NavController) {
    val viewModel = LocalTransactionViewModel.current

    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        if(viewModel.transactionId!=null){
            SPButton(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = LocalColors.current.mainColors.violet.violet_100,
                onClick = {viewModel.recordTransaction(type)
                    navController.popBackStack()
                }
            ) {
                TitleMedium(
                    text = "Update",
                    textColor = LocalColors.current.mainColors.light.light_100
                )
            }
        }else{
            SPButton(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = LocalColors.current.mainColors.violet.violet_100,
                onClick = {viewModel.recordTransaction(type)
                navController.popBackStack()
                }
            ) {
                TitleMedium(
                    text = "Record",
                    textColor = LocalColors.current.mainColors.light.light_100
                )
            }
        }
    }

}