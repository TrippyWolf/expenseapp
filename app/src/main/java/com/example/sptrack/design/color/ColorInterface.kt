package com.example.sptrack.design.color

import androidx.compose.ui.graphics.Color as ComposeColor

interface BorderColors {
    val active: ComposeColor
    val pressed: ComposeColor
    val inactive: ComposeColor
    val mute: ComposeColor
    val focus: ComposeColor
    val error: ComposeColor
}


interface FillColors {
    val background: ComposeColor
    val active: ComposeColor
    val error: ComposeColor
    val mute: ComposeColor
    val pressed: ComposeColor
    val alt: ComposeColor
}

interface ContentColors {
    val normal: ComposeColor
    val minor: ComposeColor
    val subtle: ComposeColor
    val disabled: ComposeColor
}

interface IconColors {
    val default: ComposeColor
    val disabled: ComposeColor
    val active: ComposeColor
}


interface MainColors {
    val dark: DarkColors
    val light: LightColors
    val violet: VioletColors
    val red: RedColors
    val green: GreenColors
    val yellow: YellowColors
    val blue: BlueColors
}

interface DarkColors {
    val dark_20: ComposeColor
    val dark_50: ComposeColor
    val dark_75: ComposeColor
    val dark_100: ComposeColor
}

interface LightColors {
    val light_20: ComposeColor
    val light_40: ComposeColor
    val light_60: ComposeColor
    val light_80: ComposeColor
    val light_100: ComposeColor
}

interface VioletColors {
    val violet_20: ComposeColor
    val violet_40: ComposeColor
    val violet_60: ComposeColor
    val violet_80: ComposeColor
    val violet_100: ComposeColor
}

interface RedColors {
    val red_20: ComposeColor
    val red_40: ComposeColor
    val red_60: ComposeColor
    val red_80: ComposeColor
    val red_100: ComposeColor
}

interface GreenColors {
    val green_20: ComposeColor
    val green_40: ComposeColor
    val green_60: ComposeColor
    val green_80: ComposeColor
    val green_100: ComposeColor
}

interface YellowColors {
    val yellow_20: ComposeColor
    val yellow_40: ComposeColor
    val yellow_60: ComposeColor
    val yellow_80: ComposeColor
    val yellow_100: ComposeColor
}

interface BlueColors {
    val blue_20: ComposeColor
    val blue_40: ComposeColor
    val blue_60: ComposeColor
    val blue_80: ComposeColor
    val blue_100: ComposeColor
}