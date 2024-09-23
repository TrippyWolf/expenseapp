package com.example.sptrack.design.color

import com.example.sptrack.design.invert
import androidx.compose.ui.graphics.Color as ComposeColor


fun defaultLightColors(
    mainColors: MainColors = defaultMainLightColors(),
    primaryColors: SPPrimaryColors = defaultPrimaryLightColors(),
    secondaryColors: SPSecondaryColors = defaultSecondaryLightColors(),
    tertiaryColors: SPTertiaryColors = defaultTertiaryLightColors(),
    borderColors: BorderColors = defaultBorderLightColors(),
    iconColors: IconColors = defaultIconsLightColors(),
    contentColors: ContentColors = defaultContentLightColors()
): SPColors = SPColors(
    mainColors=mainColors,
    primaryColors = primaryColors,
    secondaryColors = secondaryColors,
    tertiaryColors = tertiaryColors,
    borderColors = borderColors,
    iconColors = iconColors,
    contentColors = contentColors,
    isDark = false
)

fun defaultDarkColors(
    mainColors: MainColors = defaultMainDarkColors(),
    primaryColors: SPPrimaryColors = defaultPrimaryDarkColors(),
    secondaryColors: SPSecondaryColors = defaultSecondaryDarkColors(),
    tertiaryColors: SPTertiaryColors = defaultTertiaryDarkColors(),
    borderColors: BorderColors = defaultBorderDarkColors(),
    iconColors: IconColors = defaultIconsDarkColors(),
    contentColors: ContentColors = defaultContentDarkColors()
): SPColors = SPColors(
    mainColors=mainColors,
    primaryColors = primaryColors,
    secondaryColors = secondaryColors,
    tertiaryColors = tertiaryColors,
    borderColors = borderColors,
    iconColors = iconColors,
    contentColors = contentColors,
    isDark = true,
)

internal object DefaultColorTokens {
    val White: ComposeColor = ComposeColor.White
    val CloudNormal: ComposeColor = ComposeColor(0xFFE8EDF1)
    val CloudDarkNormal: ComposeColor = ComposeColor(0xFF293845)

    /**
     * Primary Dark colors
     */
    val activePrimaryDark: ComposeColor = ComposeColor(0XFF2196F3)
    val backgroundPrimaryDark: ComposeColor = ComposeColor(0xFF1C1D1D)
    val errorPrimaryDark: ComposeColor = ComposeColor(0XFFEA001F)
    val mutePrimaryDark: ComposeColor = ComposeColor(0xFF606161)
    val pressedPrimaryDark: ComposeColor = ComposeColor(0X332196F3)

    /**
     * Secondary Dark colors
     */
    val activeSecondaryDark: ComposeColor = ComposeColor(0XFF79c0f7)
    val backgroundSecondaryDark: ComposeColor = ComposeColor(0xFF333434)
    val errorSecondaryDark: ComposeColor = ComposeColor(0XFFEE324B)
    val muteSecondaryDark: ComposeColor = ComposeColor(0xFF242525)
    val pressedSecondaryDark: ComposeColor = ComposeColor(0X3379c0f7)

    /**
     * Tertiary Dark colors
     */
    val activeTertiaryDark: ComposeColor = ComposeColor(0XA62196F3)
    val backgroundTertiaryDark: ComposeColor = ComposeColor(0X2FFFFFFF)
    val errorTertiaryDark: ComposeColor = ComposeColor(0XA6EA001F)
    val muteTertiaryDark: ComposeColor = ComposeColor(0XA6E8E8E8)
    val pressedTertiaryDark: ComposeColor = ComposeColor(0X3379c0f7)

    /**
     * Border Dark colors
     */
    val activeBorderDark: ComposeColor = ComposeColor(0XFF104B79)
    val pressedBorderDark: ComposeColor = ComposeColor(0XFF061E30)
    val inactiveBorderDark: ComposeColor = ComposeColor(0XFFBCBCBC)
    val muteBorderDark: ComposeColor = ComposeColor(0xFF606161)
    val focusBorderDark: ComposeColor = ComposeColor(0XFF104B79)
    val errorBorderDark: ComposeColor = ComposeColor(0XFFEE324B)

    /**
     * Icon Dark colors
     */
    val iconDefaultDark: ComposeColor = ComposeColor(0xFFFFFFFF)
    val iconDisabledDark: ComposeColor = ComposeColor(0xFFD3D3D3)
    val iconActiveDark: ComposeColor = ComposeColor(0x8C2196F3)

    /**
     * Primary Light colors
     */
    val activePrimaryLight: ComposeColor = ComposeColor(0XFF2196F3)
    val backgroundPrimaryLight: ComposeColor = ComposeColor(0xFFFFFFFF)
    val errorPrimaryLight: ComposeColor = ComposeColor(0XFFEA001F)
    val mutePrimaryLight: ComposeColor = ComposeColor(0XFFE8E8E8)
    val pressedPrimaryLight: ComposeColor = ComposeColor(0X332196F3)

    /**
     * Secondary Light colors
     */
    val activeSecondaryLight: ComposeColor = ComposeColor(0XFF79c0f7)
    val backgroundSecondaryLight: ComposeColor = ComposeColor(0xFFE5E5E5)
    val errorSecondaryLight: ComposeColor = ComposeColor(0XFFEE324B)
    val muteSecondaryLight: ComposeColor = ComposeColor(0XFFFAFAFA)
    val pressedSecondaryLight: ComposeColor = ComposeColor(0X3379c0f7)

    /**
     * Tertiary Light colors
     */
    val activeTertiaryLight: ComposeColor = ComposeColor(0XA62196F3)
    val backgroundTertiaryLight: ComposeColor = ComposeColor(0X2F79c0f7)
    val errorTertiaryLight: ComposeColor = ComposeColor(0XA6EA001F)
    val muteTertiaryLight: ComposeColor = ComposeColor(0XA6E8E8E8)
    val pressedTertiaryLight: ComposeColor = ComposeColor(0X3379c0f7)

    /**
     * Border Light colors
     */
    val activeBorderLight: ComposeColor = ComposeColor(0XFF104B79)
    val pressedBorderLight: ComposeColor = ComposeColor(0XFF061E30)
    val inactiveBorderLight: ComposeColor = ComposeColor(0XFFBCBCBC)
    val muteBorderLight: ComposeColor = ComposeColor(0XFFE8F4FD)
    val focusBorderLight: ComposeColor = ComposeColor(0XFF104B79)
    val errorBorderLight: ComposeColor = ComposeColor(0XFFEE324B)

    /**
     * Icon Light colors
     */
    val iconDefaultLight: ComposeColor = ComposeColor(0xFF494A4A)
    val iconDisabledLight: ComposeColor = ComposeColor(0xFF606161)
    val iconActiveLight: ComposeColor = ComposeColor(0x8C2196F3)

    /**
     * Generic Content colors
     */
    val contentNormal: ComposeColor = ComposeColor(0XFF252A31)
    val contentMinor: ComposeColor = ComposeColor(0xFF4F5E71)
    val contentSubtle: ComposeColor = ComposeColor(0xFF697D95)
    val contentDisabled: ComposeColor = ComposeColor(0xFFA6B6C8)




    /*    dark   */
    val darkDark_20 = ComposeColor(0xFF000000) // Black
    val darkDark_50 = ComposeColor(0xFF1A1A1A)
    val darkDark_75 = ComposeColor(0xFF333333)
    val darkDark_100 = ComposeColor(0xFF4D4D4D)

    val lightDark_20 = ComposeColor(0xFF4D4D4D)
    val lightDark_40 = ComposeColor(0xFF666666)
    val lightDark_60 = ComposeColor(0xFF808080)
    val lightDark_80 = ComposeColor(0xFF999999)
    val lightDark_100 = ComposeColor(0xFFB2B2B2)

    val violetDark_20 = ComposeColor(0xFF800080)
    val violetDark_40 = ComposeColor(0xFFB238B2)
    val violetDark_60 = ComposeColor(0xFFD46CD4)
    val violetDark_80 = ComposeColor(0xFFF69FF6)
    val violetDark_100 = ComposeColor(0xFFE060E0)

    val redDark_20 = ComposeColor(0xFFB20000)
    val redDark_40 = ComposeColor(0xFFD44040)
    val redDark_60 = ComposeColor(0xFFF66060)
    val redDark_80 = ComposeColor(0xFFF68080)
    val redDark_100 = ComposeColor(0xFFF6B2B2)

    val greenDark_20 = ComposeColor(0xFF008000)
    val greenDark_40 = ComposeColor(0xFF40B240)
    val greenDark_60 = ComposeColor(0xFF60D460)
    val greenDark_80 = ComposeColor(0xFF80F680)
    val greenDark_100 = ComposeColor(0xFFB2F6B2)

    val yellowDark_20 = ComposeColor(0xFFF6F600)
    val yellowDark_40 = ComposeColor(0xFFF6F640)
    val yellowDark_60 = ComposeColor(0xFFF6F660)
    val yellowDark_80 = ComposeColor(0xFFF6F680)
    val yellowDark_100 = ComposeColor(0xFFF6F6B2)

    val blueDark_20 = ComposeColor(0xFF0000B2)
    val blueDark_40 = ComposeColor(0xFF4040D4)
    val blueDark_60 = ComposeColor(0xFF6060F6)
    val blueDark_80 = ComposeColor(0xFF8080F6)
    val blueDark_100 = ComposeColor(0xFFB2B2F6)

}


/**
 * Dark side
 */


internal fun defaultPrimaryDarkColors(
    active: ComposeColor = DefaultColorTokens.activePrimaryDark,
    background: ComposeColor = DefaultColorTokens.backgroundPrimaryDark,
    error: ComposeColor = DefaultColorTokens.errorPrimaryDark,
    mute: ComposeColor = DefaultColorTokens.mutePrimaryDark,
    pressed: ComposeColor = DefaultColorTokens.pressedPrimaryDark,
    alt: ComposeColor = DefaultColorTokens.CloudDarkNormal,
): SPPrimaryColors = SPPrimaryColors(
    active = active,
    background = background,
    error = error,
    mute = mute,
    pressed = pressed,
    alt = alt
)

internal fun defaultSecondaryDarkColors(
    active: ComposeColor = DefaultColorTokens.activeSecondaryDark,
    background: ComposeColor = DefaultColorTokens.backgroundSecondaryDark,
    error: ComposeColor = DefaultColorTokens.errorSecondaryDark,
    mute: ComposeColor = DefaultColorTokens.muteSecondaryDark,
    pressed: ComposeColor = DefaultColorTokens.pressedSecondaryDark,
    alt: ComposeColor = DefaultColorTokens.White,
): SPSecondaryColors = SPSecondaryColors(
    active = active,
    background = background,
    error = error,
    mute = mute,
    pressed = pressed,
    alt = alt
)

internal fun defaultTertiaryDarkColors(
    active: ComposeColor = DefaultColorTokens.activeTertiaryDark,
    background: ComposeColor = DefaultColorTokens.backgroundTertiaryDark,
    error: ComposeColor = DefaultColorTokens.errorTertiaryDark,
    mute: ComposeColor = DefaultColorTokens.muteTertiaryDark,
    pressed: ComposeColor = DefaultColorTokens.pressedTertiaryDark,
    alt: ComposeColor = DefaultColorTokens.White,
): SPTertiaryColors = SPTertiaryColors(
    active = active,
    background = background,
    error = error,
    mute = mute,
    pressed = pressed,
    alt = alt
)

internal fun defaultBorderDarkColors(
    active: ComposeColor = DefaultColorTokens.activeBorderDark,
    pressed: ComposeColor = DefaultColorTokens.pressedBorderDark,
    inactive: ComposeColor = DefaultColorTokens.inactiveBorderDark,
    mute: ComposeColor = DefaultColorTokens.muteBorderDark,
    focus: ComposeColor = DefaultColorTokens.focusBorderDark,
    error: ComposeColor = DefaultColorTokens.errorBorderDark,
): BorderColors = SPBorderColors(
    active = active,
    pressed = pressed,
    inactive = inactive,
    mute = mute,
    focus = focus,
    error = error
)

internal fun defaultIconsDarkColors(
    default: ComposeColor = DefaultColorTokens.iconDefaultDark,
    disabled: ComposeColor = DefaultColorTokens.iconDisabledDark,
    active: ComposeColor = DefaultColorTokens.iconActiveDark,
): IconColors = SPIconColors(
    default = default,
    disabled = disabled,
    active = active
)

internal fun defaultContentDarkColors(
    normal: ComposeColor = DefaultColorTokens.contentNormal.invert(),
    minor: ComposeColor = DefaultColorTokens.contentMinor.invert(),
    subtle: ComposeColor = DefaultColorTokens.contentSubtle.invert(),
    disabled: ComposeColor = DefaultColorTokens.contentDisabled.invert(),
): ContentColors = SPContentColors(
    normal = normal,
    minor = minor,
    subtle = subtle,
    disabled = disabled
)


/**
 * Light side
 */


internal fun defaultPrimaryLightColors(
    active: ComposeColor = DefaultColorTokens.activePrimaryLight,
    background: ComposeColor = DefaultColorTokens.backgroundPrimaryLight,
    error: ComposeColor = DefaultColorTokens.errorPrimaryLight,
    mute: ComposeColor = DefaultColorTokens.mutePrimaryLight,
    pressed: ComposeColor = DefaultColorTokens.pressedPrimaryLight,
    alt: ComposeColor = DefaultColorTokens.CloudNormal,
): SPPrimaryColors = SPPrimaryColors(
    active = active,
    background = background,
    error = error,
    mute = mute,
    pressed = pressed,
    alt = alt
)

internal fun defaultSecondaryLightColors(
    active: ComposeColor = DefaultColorTokens.activeSecondaryLight,
    background: ComposeColor = DefaultColorTokens.backgroundSecondaryLight,
    error: ComposeColor = DefaultColorTokens.errorSecondaryLight,
    mute: ComposeColor = DefaultColorTokens.muteSecondaryLight,
    pressed: ComposeColor = DefaultColorTokens.pressedSecondaryLight,
    alt: ComposeColor = DefaultColorTokens.White.invert(),
): SPSecondaryColors = SPSecondaryColors(
    active = active,
    background = background,
    error = error,
    mute = mute,
    pressed = pressed,
    alt = alt
)

internal fun defaultTertiaryLightColors(
    active: ComposeColor = DefaultColorTokens.activeTertiaryLight,
    background: ComposeColor = DefaultColorTokens.backgroundTertiaryLight,
    error: ComposeColor = DefaultColorTokens.errorTertiaryLight,
    mute: ComposeColor = DefaultColorTokens.muteTertiaryLight,
    pressed: ComposeColor = DefaultColorTokens.pressedTertiaryLight,
    alt: ComposeColor = DefaultColorTokens.White.invert(),
): SPTertiaryColors = SPTertiaryColors(
    active = active,
    background = background,
    error = error,
    mute = mute,
    pressed = pressed,
    alt = alt
)

internal fun defaultBorderLightColors(
    active: ComposeColor = DefaultColorTokens.activeBorderLight,
    pressed: ComposeColor = DefaultColorTokens.pressedBorderLight,
    inactive: ComposeColor = DefaultColorTokens.inactiveBorderLight,
    mute: ComposeColor = DefaultColorTokens.muteBorderLight,
    focus: ComposeColor = DefaultColorTokens.focusBorderLight,
    error: ComposeColor = DefaultColorTokens.errorBorderLight,
): BorderColors = SPBorderColors(
    active = active,
    pressed = pressed,
    inactive = inactive,
    mute = mute,
    focus = focus,
    error = error
)

internal fun defaultIconsLightColors(
    default: ComposeColor = DefaultColorTokens.iconDefaultLight,
    disabled: ComposeColor = DefaultColorTokens.iconDisabledLight,
    active: ComposeColor = DefaultColorTokens.iconActiveLight,
): IconColors = SPIconColors(
    default = default,
    disabled = disabled,
    active = active
)

internal fun defaultContentLightColors(
    normal: ComposeColor = DefaultColorTokens.contentNormal,
    minor: ComposeColor = DefaultColorTokens.contentMinor,
    subtle: ComposeColor = DefaultColorTokens.contentSubtle,
    disabled: ComposeColor = DefaultColorTokens.contentDisabled,
): ContentColors = SPContentColors(
    normal = normal,
    minor = minor,
    subtle = subtle,
    disabled = disabled
)


object DefaultMainLightColorTokens {
    val darkColors = object : DarkColors {
        override val dark_20 = ComposeColor(0xFF202020)
        override val dark_50 = ComposeColor(0xFF505050)
        override val dark_75 = ComposeColor(0xFF757575)
        override val dark_100 = ComposeColor(0xFF000000)
    }

    val lightColors = object : LightColors {
        override val light_20 = ComposeColor(0xFF202020)
        override val light_40 = ComposeColor(0xFF404040)
        override val light_60 = ComposeColor(0xFF606060)
        override val light_80 = ComposeColor(0xFF808080)
        override val light_100 = ComposeColor(0xFFFFFFFF)
    }

    val violetColors = object : VioletColors {
        override val violet_20 = ComposeColor(0xFF800080)
        override val violet_40 = ComposeColor(0xFFB238B2)
        override val violet_60 = ComposeColor(0xFFD46CD4)
        override val violet_80 = ComposeColor(0xFFF69FF6)
        override val violet_100 = ComposeColor(0xFFE060E0)
    }

    val redColors = object : RedColors {
        override val red_20 = ComposeColor(0xFFB20000)
        override val red_40 = ComposeColor(0xFFD44040)
        override val red_60 = ComposeColor(0xFFF66060)
        override val red_80 = ComposeColor(0xFFF68080)
        override val red_100 = ComposeColor(0xFFF6B2B2)
    }

    val greenColors = object : GreenColors {
        override val green_20 = ComposeColor(0xFF008000)
        override val green_40 = ComposeColor(0xFF40B240)
        override val green_60 = ComposeColor(0xFF60D460)
        override val green_80 = ComposeColor(0xFF80F680)
        override val green_100 = ComposeColor(0xFFB2F6B2)
    }

    val yellowColors = object : YellowColors {
        override val yellow_20 = ComposeColor(0xFFF6F600)
        override val yellow_40 = ComposeColor(0xFFF6F640)
        override val yellow_60 = ComposeColor(0xFFF6F660)
        override val yellow_80 = ComposeColor(0xFFF6F680)
        override val yellow_100 = ComposeColor(0xFFF6F6B2)
    }

    val blueColors = object : BlueColors {
        override val blue_20 = ComposeColor(0xFF0000B2)
        override val blue_40 = ComposeColor(0xFF4040D4)
        override val blue_60 = ComposeColor(0xFF6060F6)
        override val blue_80 = ComposeColor(0xFF8080F6)
        override val blue_100 = ComposeColor(0xFFB2B2F6)
    }
}

// Function to create default main colors
internal fun defaultMainLightColors(
    dark: DarkColors = DefaultMainLightColorTokens.darkColors,
    light: LightColors = DefaultMainLightColorTokens.lightColors,
    violet: VioletColors = DefaultMainLightColorTokens.violetColors,
    red: RedColors = DefaultMainLightColorTokens.redColors,
    green: GreenColors = DefaultMainLightColorTokens.greenColors,
    yellow: YellowColors = DefaultMainLightColorTokens.yellowColors,
    blue: BlueColors = DefaultMainLightColorTokens.blueColors,
): MainColors = object : MainColors {
    override val dark = dark
    override val light = light
    override val violet = violet
    override val red = red
    override val green = green
    override val yellow = yellow
    override val blue = blue
}


object DefaultDarkColorTokens {
    val darkColors = object : DarkColors {
        override val dark_20 = ComposeColor(0xFF000000) // Black
        override val dark_50 = ComposeColor(0xFF1A1A1A)
        override val dark_75 = ComposeColor(0xFF333333)
        override val dark_100 = ComposeColor(0xFF4D4D4D)
    }

    val lightColors = object : LightColors {
        override val light_20 = ComposeColor(0xFF4D4D4D)
        override val light_40 = ComposeColor(0xFF666666)
        override val light_60 = ComposeColor(0xFF808080)
        override val light_80 = ComposeColor(0xFF999999)
        override val light_100 = ComposeColor(0xFFB2B2B2)
    }

    val violetColors = object : VioletColors {
        override val violet_20 = ComposeColor(0xFF800080)
        override val violet_40 = ComposeColor(0xFFB238B2)
        override val violet_60 = ComposeColor(0xFFD46CD4)
        override val violet_80 = ComposeColor(0xFFF69FF6)
        override val violet_100 = ComposeColor(0xFFE060E0)
    }

    val redColors = object : RedColors {
        override val red_20 = ComposeColor(0xFFB20000)
        override val red_40 = ComposeColor(0xFFD44040)
        override val red_60 = ComposeColor(0xFFF66060)
        override val red_80 = ComposeColor(0xFFF68080)
        override val red_100 = ComposeColor(0xFFF6B2B2)
    }

    val greenColors = object : GreenColors {
        override val green_20 = ComposeColor(0xFF008000)
        override val green_40 = ComposeColor(0xFF40B240)
        override val green_60 = ComposeColor(0xFF60D460)
        override val green_80 = ComposeColor(0xFF80F680)
        override val green_100 = ComposeColor(0xFFB2F6B2)
    }

    val yellowColors = object : YellowColors {
        override val yellow_20 = ComposeColor(0xFFF6F600)
        override val yellow_40 = ComposeColor(0xFFF6F640)
        override val yellow_60 = ComposeColor(0xFFF6F660)
        override val yellow_80 = ComposeColor(0xFFF6F680)
        override val yellow_100 = ComposeColor(0xFFF6F6B2)
    }

    val blueColors = object : BlueColors {
        override val blue_20 = ComposeColor(0xFF0000B2)
        override val blue_40 = ComposeColor(0xFF4040D4)
        override val blue_60 = ComposeColor(0xFF6060F6)
        override val blue_80 = ComposeColor(0xFF8080F6)
        override val blue_100 = ComposeColor(0xFFB2B2F6)
    }
}

// Function to create default main colors
internal fun defaultMainDarkColors(
    dark: DarkColors = DefaultDarkColorTokens.darkColors,
    light: LightColors = DefaultDarkColorTokens.lightColors,
    violet: VioletColors = DefaultDarkColorTokens.violetColors,
    red: RedColors = DefaultDarkColorTokens.redColors,
    green: GreenColors = DefaultDarkColorTokens.greenColors,
    yellow: YellowColors = DefaultDarkColorTokens.yellowColors,
    blue: BlueColors = DefaultDarkColorTokens.blueColors,
): MainColors = object : MainColors {
    override val dark = dark
    override val light = light
    override val violet = violet
    override val red = red
    override val green = green
    override val yellow = yellow
    override val blue = blue
}
