package com.example.sptrack.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sptrack.design.color.LocalColors
import com.himanshoe.charty.common.ChartDataCollection
import com.himanshoe.charty.common.config.AxisConfig
import com.himanshoe.charty.common.config.ChartDefaults


@Composable
fun BarChart(
    dataCollection: ChartDataCollection,

){
    com.himanshoe.charty.bar.BarChart(
        modifier = Modifier.fillMaxWidth().height(250.dp),
        dataCollection= dataCollection,
        axisConfig = ChartDefaults.axisConfigDefaults().copy(showAxes = true),
        barColor = LocalColors.current.mainColors.violet.violet_80,
    )

}


