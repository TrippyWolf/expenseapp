package com.example.sptrack.design.shape


import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

interface BasicShapes {
    val small: CornerBasedShape
    val normal: CornerBasedShape
    val large: CornerBasedShape
}

interface SPShapes : BasicShapes {
    val bottomSheet: Shape
    val buttonShape: Shape
    val dialogShape: Shape
}

class DefaultShapes(
    override val bottomSheet: Shape,
    override val buttonShape: Shape,
    override val dialogShape: Shape,
    override val small: CornerBasedShape,
    override val normal: CornerBasedShape,
    override val large: CornerBasedShape,
) : SPShapes {
    companion object {
        val default: SPShapes = DefaultShapes(
            bottomSheet = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            buttonShape = RoundedCornerShape(8.dp),
            dialogShape = RoundedCornerShape(8.dp),
            small = RoundedCornerShape(4.dp),
            normal = RoundedCornerShape(6.dp),
            large = RoundedCornerShape(12.dp),
        )
    }
}

internal val LocalShapes = compositionLocalOf<SPShapes> {
    error(
        "No shapes provided! Make sure to wrap all usages of Andromeda components in a " +
                "AndromedaTheme."
    )
}