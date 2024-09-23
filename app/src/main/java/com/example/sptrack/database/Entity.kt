package com.example.sptrack.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.Date

@Entity(
    tableName = "Transaction",
)
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val type: String, // "expense" or "income"
    val amount: Double,
    val categoryId: Int,
    val accountId: Int,
    val description: String = "",
    val timestamp: Date = Date(),
)
