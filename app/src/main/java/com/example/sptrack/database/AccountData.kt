package com.example.sptrack.database

import androidx.annotation.DrawableRes
import com.example.sptrack.R


data class Account(
    val id: Int,
    val accountName: String,
    val totalBalance: Double,
)

val accountList = listOf(
    Account(1, "Cash", 0.00),
    Account(2, "Card", 0.00),
)


fun getAccountName():List<String>{
   return accountList.map { it.accountName }
}