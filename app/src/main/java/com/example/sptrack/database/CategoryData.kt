package com.example.sptrack.database

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.sptrack.EXPENSE
import com.example.sptrack.R
import com.example.sptrack.design.SPTheme
import com.example.sptrack.design.color.SPColors
import kotlin.random.Random


data class Category(val id: Int, @DrawableRes val resourceId: Int, val name: String)


val categoryList = listOf(
    Category(1, R.drawable.magicons_glyph_finance_recurring_bill, "Subscription"),
    Category(2, R.drawable.magicons_glyph_travel_restaurant, "Food"),
    Category(3, R.drawable.magicons_glyph_ecommerce_shopping_shopping_bag, "Shopping"),
    Category(101, R.drawable.magicons_glyph_finance_salary, "Salary"),
    Category(102, R.drawable.magicons_glyph_finance_salary, "Bonus"),

)

fun getCategoryList(type:String):List<Category>{
    return if(type == EXPENSE){
        categoryList.filter { it.id<=100 }
    }else{
        categoryList.filter { it.id>=100 }
    }
}

fun getCategoryName(type:String):List<String>{
    return getCategoryList(type).map { it.name }
}

fun getRandomCategoryColor(spColor: SPColors): Color {
    // Define your three colors
    val colors = listOf(
        spColor.mainColors.violet.violet_100,
        spColor.mainColors.green.green_100,  //
        spColor.mainColors.red.red_100,  //
        spColor.mainColors.yellow.yellow_100,
    )

    // Get a random index from the colors list
    val randomIndex = Random.nextInt(colors.size)

    // Return the color at the random index
    return colors[randomIndex]
}