package com.example.sptrack.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: Transaction)

    @Query("SELECT * FROM `Transaction`")
    suspend fun getTransactions(): List<Transaction>

    @Query("SELECT * FROM  `Transaction` WHERE accountId = :accountId")
    suspend fun getTransactionsByAccount(accountId: Long): List<Transaction>

    @Query("SELECT SUM(amount) FROM  `Transaction` WHERE type = 'expense'")
    suspend fun getTotalExpenses(): Double?

    @Query("SELECT SUM(amount) FROM  `Transaction` WHERE type = 'income'")
    suspend fun getTotalIncome(): Double?

    @Query("DELETE FROM`Transaction` WHERE id = :transactionId")
    suspend fun deleteTransactionById(transactionId: Long)
}
