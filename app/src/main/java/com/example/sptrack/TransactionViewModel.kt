package com.example.sptrack

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.sptrack.database.Category
import com.example.sptrack.database.Transaction
import com.example.sptrack.database.accountList
import com.example.sptrack.database.categoryList
import com.example.sptrack.feature.ChartModel
import com.himanshoe.charty.common.ChartData
import com.himanshoe.charty.common.ChartDataCollection
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.math.min

class TransactionViewModel(private val repository: TransactionRepository) : ViewModel() {

    private var _transactionsGroup = mutableStateMapOf<String, List<Transaction>>()
    val transactionsGroup: Map<String, List<Transaction>> get() = _transactionsGroup



     var transactionId:Long? =null;

     var transactionType:String? =null;

     val categoryId = mutableStateOf(0)

     val description = mutableStateOf("")

     val name = mutableStateOf("")

     val accountId = mutableIntStateOf(0)

     val amount = mutableStateOf("0.00")


    fun addCategoryId(name: String) {
        categoryId.value = categoryList.firstOrNull { it.name == name }?.id!!
    }

    fun addAccountId(name: String) {
        accountId.intValue = accountList.firstOrNull { it.accountName == name }?.id!!
    }

    fun addAmount(value: String) {
        amount.value = value
    }

    fun addDescription(value: String) {
        description.value = value
    }

    fun addName(value: String) {
        name.value = value
    }

    fun recordTransaction(type: String) {
        if(transactionId !=null){
            addTransaction(
                Transaction(
                    id = transactionId!!,
                    name = name.value,
                    type = type,
                    accountId = accountId.value,
                    categoryId = categoryId.value,
                    description = description.value,
                    amount = amount.value.toDouble()
                )
            )
        }else{
            addTransaction(
                Transaction(

                    name = name.value,
                    type = type,
                    accountId = accountId.value,
                    categoryId = categoryId.value,
                    description = description.value,
                    amount = amount.value.toDouble()
                )
            )
        }

    }


    fun addTransaction(transaction: Transaction) {
        viewModelScope.launch {
            repository.insertTransaction(transaction)
          resetTransaction();
        }
    }

    private fun resetTransaction(){
        transactionId =null
        transactionType =null;
    }

    fun groupTransactionsByDate() {
        viewModelScope.launch {
            // Fetch transactions from the repository
            val transactions = repository.getTransactions()
            // Group transactions by formatted date
            val grouped = transactions.groupBy {
                SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(it.timestamp)
            }.toSortedMap()

            // Update the state map
            _transactionsGroup.clear() // Clear existing values
            _transactionsGroup.putAll(grouped) // Add new grouped values
        }
    }

    fun applyFilterOnTransaction(predicate:(List<Transaction>)->Map< String,List<Transaction>>){
            val grouped=  predicate(_transactionsGroup.flatMap { it.value })
        _transactionsGroup.clear() // Clear existing values
        _transactionsGroup.putAll(grouped) // Add new grouped values
    }



    suspend fun getLatestTransaction(): List<Transaction> {
        val transactions = repository.getTransactions().sortedBy { it.timestamp }
        return if (transactions.isEmpty()) {
            emptyList()
        } else {
            transactions.subList(0, min(transactions.size, 3))
        }
    }


    fun getIconByCategoryId(categoryId:Int):Int{
        return categoryList.firstOrNull { it.id == categoryId }?.resourceId ?: R.drawable.restaurant;
    }
    fun getNameByCategoryId(categoryId:Int):String{
        return categoryList.firstOrNull { it.id == categoryId }?.name ?: "";
    }
    fun getNameByAccountId(accountId:Int):String{
        return accountList.firstOrNull { it.id == accountId }?.accountName ?: "";
    }

    fun loadTransactionInViewModel(transaction: Transaction){
        transactionId = transaction.id;
        categoryId.value = transaction.categoryId;
        accountId.intValue=transaction.accountId;
        name.value=transaction.name;
        description.value =transaction.description;
        amount.value = transaction.amount.toString();
        transactionType = transaction.type

    }

    suspend fun getTotalAccountBalance():Double{
       return   getTotalIncome() - getTotalExpense()
    }

   suspend fun getTotalExpense():Double{
       return repository.getTotalExpenses()
    }

    suspend fun getTotalIncome():Double{
       return repository.getTotalIncome()
    }

     fun deleteTransaction(){
        viewModelScope.launch {
            repository.deleteTransaction(transactionId )
            resetTransaction()
        }

    }

    fun sortByTitle(transactions: List<Transaction>): Map<String, List<Transaction>> {
        return transactions.sortedBy { it.name }
            .groupBy { it.name.firstOrNull()?.uppercase() ?: "Unknown" }
    }

    fun sortByCategory(transactions: List<Transaction>): Map<String, List<Transaction>> {
        return transactions.sortedBy { it.name }
            .groupBy { getNameByCategoryId(it.categoryId) }
    }

    fun selectExpenseHistory(transactions: List<Transaction>): Map<String, List<Transaction>>{
        return transactions.filter { it.type== EXPENSE }
            .groupBy {
            SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(it.timestamp)
        }.toSortedMap()
    }
    fun selectIncomeHistory(transactions: List<Transaction>): Map<String, List<Transaction>>{
        return transactions.filter { it.type== INCOME }
            .groupBy {
                SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(it.timestamp)
            }.toSortedMap()
    }


    suspend fun getDayWiseExpenseOnChart():List<ChartModel>{
        val charData = repository.getTransactions().groupBy {
            SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(it.timestamp)
        }.toSortedMap().map { ChartModel(it.key,it.key,it.value.map { it.amount }.reduce { acc, number -> acc + number }.toFloat()) }
       return (charData)
    }

    suspend fun getCategoryWiseExpenseOnChart():List<ChartModel>{
        val charData = repository.getTransactions().groupBy {
            getNameByCategoryId(it.categoryId)
        }.toSortedMap().map {  ChartModel(it.key,it.key,it.value.map {transaction -> transaction.amount }.reduce { acc, number -> acc + number }.toFloat()) }
        return (charData)
    }
}

// ViewModel Factory
class TransactionViewModelFactory(private val repository: TransactionRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TransactionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

val LocalTransactionViewModel =
    compositionLocalOf<TransactionViewModel> { error("No ViewModel provided") }
