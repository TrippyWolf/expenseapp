package com.example.sptrack.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sptrack.R
import com.example.sptrack.design.components.IconSize
import com.example.sptrack.design.components.SPCard
import com.example.sptrack.design.components.SPIcon
import com.example.sptrack.design.space.Spacing

@Composable
fun FinancialCard(
    @DrawableRes icon: Int,
    backgroundColor: Color,
    contentColor: Color,
    cardName: String,
    amount: String,
    modifier: Modifier = Modifier,
) {
    SPCard(
        backgroundColor = backgroundColor,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            IconCard(
                iconSize = IconSize.SMALL,
                resourceId = icon,
                backGroundColor = Color.White,
                iconTint = backgroundColor,
                contentDescription = cardName,
                modifier = Modifier.padding(8.dp).size(48.dp).fillMaxWidth()
            )

            AlignTextColumns(
                modifier = Modifier.padding(8.dp),
                margin = 8.dp, // Custom margin between the texts
                text1 = {
                    BodyXSmall(
                        text = cardName,
                        textColor = contentColor
                    )
                },
                text2 = {
                    TitleMedium(
                        text = amount,
                        textColor = contentColor
                    )
                }
            )

        }
    }
}