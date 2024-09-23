package com.example.sptrack.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sptrack.EXPENSE
import com.example.sptrack.database.getRandomCategoryColor
import com.example.sptrack.design.SPTheme
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.components.IconSize
import com.example.sptrack.design.components.SPCard
import com.example.sptrack.design.space.Spacing
import com.example.sptrack.formatDate


@Composable
fun TransactionItem(
    title: String,
    subtitle: String,
    amount: String,
    time: String,
    transactionType: String,

    @DrawableRes iconId:Int,
    onClick:()->Unit
) {

    val iconColor = getRandomCategoryColor(LocalColors.current)

    SPCard(
        modifier = Modifier.padding(vertical = Spacing.Spacing_8).clickable {
            onClick()
        },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            IconCard(
                iconId,
                "categoryId",
                iconColor,
                iconColor.copy(alpha = 0.3f),
                IconSize.MEDIUM,
                modifier = Modifier
            )

            AlignTextColumns(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = Spacing.Spacing_16),
                margin = 4.dp,
                text1 = {
                    TitleLarge(
                        text = title,
                        textColor = SPTheme.colors.mainColors.dark.dark_20,
                    )
                },
                text2 = {
                    BodyXSmall(
                        text = subtitle,
                        textColor = SPTheme.colors.mainColors.light.light_20,

                    )
                }
            )


            AlignTextColumns(
                horizontalAlignment = Alignment.End,
                modifier = Modifier,
                margin = 4.dp, // Custom margin between the texts
                text1 = {
                    TitleLarge(
                        text = amount,
                        textColor = if(transactionType == EXPENSE) LocalColors.current.mainColors.red.red_100 else LocalColors.current.mainColors.green.green_100,
                    )
                },
                text2 = {
                    BodyXSmall(
                        text = formatDate(time),
                        textColor = SPTheme.colors.mainColors.light.light_20,
                        )
                }
            )

        }
    }
}