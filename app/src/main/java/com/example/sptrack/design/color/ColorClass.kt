package com.example.sptrack.design.color

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.runtime.setValue

@Stable
class SPBorderColors(
    active: ComposeColor,
    pressed: ComposeColor,
    inactive: ComposeColor,
    mute: ComposeColor,
    focus: ComposeColor,
    error: ComposeColor,
) : BorderColors {
    override var active: ComposeColor by mutableStateOf(active, structuralEqualityPolicy())
        internal set
    override var inactive: ComposeColor by mutableStateOf(inactive, structuralEqualityPolicy())
        internal set
    override var error: ComposeColor by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    override var mute: ComposeColor by mutableStateOf(mute, structuralEqualityPolicy())
        internal set
    override var pressed: ComposeColor by mutableStateOf(pressed, structuralEqualityPolicy())
        internal set
    override var focus: ComposeColor by mutableStateOf(focus, structuralEqualityPolicy())
        internal set

    fun copy(
        active: ComposeColor = this.active,
        pressed: ComposeColor = this.pressed,
        inactive: ComposeColor = this.inactive,
        mute: ComposeColor,
        focus: ComposeColor,
        error: ComposeColor,
    ): BorderColors = SPBorderColors(
        active,
        pressed,
        inactive,
        mute,
        focus,
        error
    )
}


@Stable
class SPContentColors(
    normal: ComposeColor,
    minor: ComposeColor,
    subtle: ComposeColor,
    disabled: ComposeColor,
) : ContentColors {
    override var normal: ComposeColor by mutableStateOf(normal, structuralEqualityPolicy())
        internal set
    override var minor: ComposeColor by mutableStateOf(minor, structuralEqualityPolicy())
        internal set
    override var subtle: ComposeColor by mutableStateOf(subtle, structuralEqualityPolicy())
        internal set
    override var disabled: ComposeColor by mutableStateOf(disabled, structuralEqualityPolicy())
        internal set

    fun copy(
        normal: ComposeColor = this.normal,
        minor: ComposeColor = this.minor,
        subtle: ComposeColor = this.subtle,
        disabled: ComposeColor = this.disabled,
    ): ContentColors = SPContentColors(
        normal,
        minor,
        subtle,
        disabled,
    )
}


@Stable
class SPPrimaryColors(
    background: ComposeColor,
    active: ComposeColor,
    error: ComposeColor,
    mute: ComposeColor,
    pressed: ComposeColor,
    alt: ComposeColor
) : FillColors {
    override var background: ComposeColor by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    override var active: ComposeColor by mutableStateOf(active, structuralEqualityPolicy())
        internal set
    override var error: ComposeColor by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    override var mute: ComposeColor by mutableStateOf(mute, structuralEqualityPolicy())
        internal set
    override var pressed: ComposeColor by mutableStateOf(pressed, structuralEqualityPolicy())
        internal set
    override var alt: ComposeColor by mutableStateOf(alt, structuralEqualityPolicy())
        internal set

    fun copy(
        background: ComposeColor = this.background,
        active: ComposeColor = this.active,
        error: ComposeColor = this.error,
        mute: ComposeColor = this.mute,
        pressed: ComposeColor = this.pressed,
        alt: ComposeColor = this.alt
    ): SPPrimaryColors = SPPrimaryColors(
        active,
        background,
        error,
        mute,
        pressed,
        alt
    )
}

@Stable
class SPSecondaryColors(
    background: ComposeColor,
    active: ComposeColor,
    error: ComposeColor,
    mute: ComposeColor,
    pressed: ComposeColor,
    alt: ComposeColor
) : FillColors {
    override var background: ComposeColor by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    override var active: ComposeColor by mutableStateOf(active, structuralEqualityPolicy())
        internal set
    override var error: ComposeColor by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    override var mute: ComposeColor by mutableStateOf(mute, structuralEqualityPolicy())
        internal set
    override var pressed: ComposeColor by mutableStateOf(pressed, structuralEqualityPolicy())
        internal set
    override var alt: ComposeColor by mutableStateOf(alt, structuralEqualityPolicy())
        internal set

    fun copy(
        background: ComposeColor = this.background,
        active: ComposeColor = this.active,
        error: ComposeColor = this.error,
        mute: ComposeColor = this.mute,
        pressed: ComposeColor = this.pressed,
        alt: ComposeColor = this.alt
    ): SPSecondaryColors = SPSecondaryColors(
        active,
        background,
        error,
        mute,
        pressed,
        alt
    )
}

@Stable
class SPTertiaryColors(
    background: ComposeColor,
    active: ComposeColor,
    error: ComposeColor,
    mute: ComposeColor,
    pressed: ComposeColor,
    alt: ComposeColor
) : FillColors {
    override var background: ComposeColor by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    override var active: ComposeColor by mutableStateOf(active, structuralEqualityPolicy())
        internal set
    override var error: ComposeColor by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    override var mute: ComposeColor by mutableStateOf(mute, structuralEqualityPolicy())
        internal set
    override var pressed: ComposeColor by mutableStateOf(pressed, structuralEqualityPolicy())
        internal set
    override var alt: ComposeColor by mutableStateOf(alt, structuralEqualityPolicy())
        internal set

    fun copy(
        background: ComposeColor = this.background,
        active: ComposeColor = this.active,
        error: ComposeColor = this.error,
        mute: ComposeColor = this.mute,
        pressed: ComposeColor = this.pressed,
        alt: ComposeColor = this.alt
    ): SPTertiaryColors = SPTertiaryColors(
        active,
        background,
        error,
        mute,
        pressed,
        alt
    )
}

@Stable
class SPIconColors(
    default: ComposeColor,
    disabled: ComposeColor,
    active: ComposeColor,
) : IconColors {
    override var default: ComposeColor by mutableStateOf(default, structuralEqualityPolicy())
        internal set
    override var disabled: ComposeColor by mutableStateOf(disabled, structuralEqualityPolicy())
        internal set
    override var active: ComposeColor by mutableStateOf(active, structuralEqualityPolicy())
        internal set

    fun copy(
        default: ComposeColor = this.default,
        disabled: ComposeColor = this.disabled,
        active: ComposeColor = this.active,
    ): IconColors = SPIconColors(
        default,
        disabled,
        active,
    )
}


@Stable
class SPMainColors(
    override var dark: SPDarkColors,
    override var light: SPLightColors,
    override var violet: SPVioletColors,
    override var red: SPRedColors,
    override var green: SPGreenColors,
    override var yellow: SPYellowColors,
    override var blue: SPBlueColors,
) : MainColors

@Stable
class SPDarkColors(
    dark_20: ComposeColor,
    dark_50: ComposeColor,
    dark_75: ComposeColor,
    dark_100: ComposeColor,
) : DarkColors {
    override var dark_20: ComposeColor by mutableStateOf(dark_20, structuralEqualityPolicy())
        internal set
    override var dark_50: ComposeColor by mutableStateOf(dark_50, structuralEqualityPolicy())
        internal set
    override var dark_75: ComposeColor by mutableStateOf(dark_75, structuralEqualityPolicy())
        internal set
    override var dark_100: ComposeColor by mutableStateOf(dark_100, structuralEqualityPolicy())
        internal set
}

// LightColors Implementation
@Stable
class SPLightColors(
    light_20: ComposeColor,
    light_40: ComposeColor,
    light_60: ComposeColor,
    light_80: ComposeColor,
    light_100: ComposeColor,
) : LightColors {
    override var light_20: ComposeColor by mutableStateOf(light_20, structuralEqualityPolicy())
        internal set
    override var light_40: ComposeColor by mutableStateOf(light_40, structuralEqualityPolicy())
        internal set
    override var light_60: ComposeColor by mutableStateOf(light_60, structuralEqualityPolicy())
        internal set
    override var light_80: ComposeColor by mutableStateOf(light_80, structuralEqualityPolicy())
        internal set
    override var light_100: ComposeColor by mutableStateOf(light_100, structuralEqualityPolicy())
        internal set
}

// VioletColors Implementation
@Stable
class SPVioletColors(
    violet_20: ComposeColor,
    violet_40: ComposeColor,
    violet_60: ComposeColor,
    violet_80: ComposeColor,
    violet_100: ComposeColor,
) : VioletColors {
    override var violet_20: ComposeColor by mutableStateOf(violet_20, structuralEqualityPolicy())
        internal set
    override var violet_40: ComposeColor by mutableStateOf(violet_40, structuralEqualityPolicy())
        internal set
    override var violet_60: ComposeColor by mutableStateOf(violet_60, structuralEqualityPolicy())
        internal set
    override var violet_80: ComposeColor by mutableStateOf(violet_80, structuralEqualityPolicy())
        internal set
    override var violet_100: ComposeColor by mutableStateOf(violet_100, structuralEqualityPolicy())
        internal set
}

// RedColors Implementation
@Stable
class SPRedColors(
    red_20: ComposeColor,
    red_40: ComposeColor,
    red_60: ComposeColor,
    red_80: ComposeColor,
    red_100: ComposeColor,
) : RedColors {
    override var red_20: ComposeColor by mutableStateOf(red_20, structuralEqualityPolicy())
        internal set
    override var red_40: ComposeColor by mutableStateOf(red_40, structuralEqualityPolicy())
        internal set
    override var red_60: ComposeColor by mutableStateOf(red_60, structuralEqualityPolicy())
        internal set
    override var red_80: ComposeColor by mutableStateOf(red_80, structuralEqualityPolicy())
        internal set
    override var red_100: ComposeColor by mutableStateOf(red_100, structuralEqualityPolicy())
        internal set
}

// GreenColors Implementation
@Stable
class SPGreenColors(
    green_20: ComposeColor,
    green_40: ComposeColor,
    green_60: ComposeColor,
    green_80: ComposeColor,
    green_100: ComposeColor,
) : GreenColors {
    override var green_20: ComposeColor by mutableStateOf(green_20, structuralEqualityPolicy())
        internal set
    override var green_40: ComposeColor by mutableStateOf(green_40, structuralEqualityPolicy())
        internal set
    override var green_60: ComposeColor by mutableStateOf(green_60, structuralEqualityPolicy())
        internal set
    override var green_80: ComposeColor by mutableStateOf(green_80, structuralEqualityPolicy())
        internal set
    override var green_100: ComposeColor by mutableStateOf(green_100, structuralEqualityPolicy())
        internal set
}

// YellowColors Implementation
@Stable
class SPYellowColors(
    yellow_20: ComposeColor,
    yellow_40: ComposeColor,
    yellow_60: ComposeColor,
    yellow_80: ComposeColor,
    yellow_100: ComposeColor,
) : YellowColors {
    override var yellow_20: ComposeColor by mutableStateOf(yellow_20, structuralEqualityPolicy())
        internal set
    override var yellow_40: ComposeColor by mutableStateOf(yellow_40, structuralEqualityPolicy())
        internal set
    override var yellow_60: ComposeColor by mutableStateOf(yellow_60, structuralEqualityPolicy())
        internal set
    override var yellow_80: ComposeColor by mutableStateOf(yellow_80, structuralEqualityPolicy())
        internal set
    override var yellow_100: ComposeColor by mutableStateOf(yellow_100, structuralEqualityPolicy())
        internal set
}

// BlueColors Implementation
@Stable
class SPBlueColors(
    blue_20: ComposeColor,
    blue_40: ComposeColor,
    blue_60: ComposeColor,
    blue_80: ComposeColor,
    blue_100: ComposeColor,
) : BlueColors {
    override var blue_20: ComposeColor by mutableStateOf(blue_20, structuralEqualityPolicy())
        internal set
    override var blue_40: ComposeColor by mutableStateOf(blue_40, structuralEqualityPolicy())
        internal set
    override var blue_60: ComposeColor by mutableStateOf(blue_60, structuralEqualityPolicy())
        internal set
    override var blue_80: ComposeColor by mutableStateOf(blue_80, structuralEqualityPolicy())
        internal set
    override var blue_100: ComposeColor by mutableStateOf(blue_100, structuralEqualityPolicy())
        internal set
}

