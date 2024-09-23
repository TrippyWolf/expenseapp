package com.example.sptrack

import com.example.sptrack.database.AppDatabase
import com.example.sptrack.database.Transaction

class TransactionRepository(private val db: AppDatabase) {
    suspend fun insertTransaction(transaction: Transaction) {
        db.transactionDao().insert(transaction)
    }

    suspend fun getTransactionsByAccount(accountId: Long): List<Transaction> {
        return db.transactionDao().getTransactionsByAccount(accountId)
    }

    suspend fun deleteTransaction(transactionId:Long?){
        if(transactionId !=null) {
            db.transactionDao().deleteTransactionById(transactionId)
        }
    }

    suspend fun getTransactions(): List<Transaction> {
        return db.transactionDao().getTransactions()
    }

    suspend fun getTotalExpenses(): Double {
        return db.transactionDao().getTotalExpenses()?:0.00
    }

    suspend fun getTotalIncome(): Double {
        return db.transactionDao().getTotalIncome() ?:0.00
    }
}
