package com.example.sptrack.design.typography

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Title Large typography style
 */
class TitleXLargeTypographyStyle : BaseTypography {

    override val fontFamily: FontFamily = SPFonts


    override val fontSize: TextUnit = 28.sp

    override val fontWeight: FontWeight = FontWeight.Bold

    override val lineHeight: TextUnit = 32.sp
}

class TitleLargeTypographyStyle : BaseTypography {

    override val fontFamily: FontFamily = SPFonts


    override val fontSize: TextUnit = 22.sp

    override val fontWeight: FontWeight = FontWeight.Bold

    override val lineHeight: TextUnit = 28.sp
}

class TitleMediumTypographyStyle : BaseTypography {

    override val fontFamily: FontFamily = SPFonts


    override val fontSize: TextUnit = 18.sp

    override val fontWeight: FontWeight = FontWeight.Bold

    override val lineHeight: TextUnit = 24.sp
}

class TitleSmallTypographyStyle : BaseTypography {

    override val fontFamily: FontFamily = SPFonts


    override val fontSize: TextUnit = 12.sp

    override val fontWeight: FontWeight = FontWeight.Bold

    override val lineHeight: TextUnit = 16.sp
}

class BodyXLargeTypographyStyle : BaseTypography {

    override val fontFamily: FontFamily = SPFonts


    override val fontSize: TextUnit = 20.sp

    override val fontWeight: FontWeight = FontWeight.Normal

    override val lineHeight: TextUnit = 26.sp
}

class BodyLargeTypographyStyle : BaseTypography {

    override val fontFamily: FontFamily = SPFonts


    override val fontSize: TextUnit = 18.sp

    override val fontWeight: FontWeight = FontWeight.Normal

    override val lineHeight: TextUnit = 24.sp
}

class BodyMediumTypographyStyle : BaseTypography {

    override val fontFamily: FontFamily = SPFonts


    override val fontSize: TextUnit = 16.sp

    override val fontWeight: FontWeight = FontWeight.Normal

    override val lineHeight: TextUnit = 20.sp
}

class BodySmallTypographyStyle : BaseTypography {

    override val fontFamily: FontFamily = SPFonts


    override val fontSize: TextUnit = 14.sp

    override val fontWeight: FontWeight = FontWeight.Normal

    override val lineHeight: TextUnit = 16.sp
}

class BodyXSmallTypographyStyle : BaseTypography {

    override val fontFamily: FontFamily = SPFonts


    override val fontSize: TextUnit = 12.sp

    override val fontWeight: FontWeight = FontWeight.Normal

    override val lineHeight: TextUnit = 14.sp
}