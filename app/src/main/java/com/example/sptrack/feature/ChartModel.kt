package com.example.sptrack.feature

import com.himanshoe.charty.common.ChartData

data class ChartModel(
    override val chartString: String,
    override val xValue: Any,
    override val yValue: Float,
):ChartData