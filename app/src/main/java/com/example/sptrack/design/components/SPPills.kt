package com.example.sptrack.design.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseInBack
import androidx.compose.animation.core.EaseOutBack
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.sptrack.design.SPTheme


@Composable
fun PillButtonContainer(
    button: @Composable PillButtonContainerScope.() -> Unit,
    buttonVisible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter,
    ) {
        content()
        AnimatedVisibility(
            visible = buttonVisible,
            enter = fadeIn(
                tween(
                    durationMillis = AnimationDurationMillis,
                    easing = EaseOutBack,
                ),
            ) + slideInVertically(
                animationSpec = tween(
                    durationMillis = AnimationDurationMillis,
                    easing = EaseOutBack,
                ),
                initialOffsetY = { fullHeight -> -fullHeight },
            ),
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = AnimationDurationMillis,
                    easing = EaseInBack,
                ),
            ) + slideOutVertically(
                animationSpec = tween(
                    durationMillis = AnimationDurationMillis,
                    easing = EaseInBack,
                ),
                targetOffsetY = { fullHeight -> -fullHeight },
            ),
        ) {
            PillButtonContainerScopeInstance.button()
        }
    }
}

/**
 * An elevated pill-shaped button that displays given [content] and (optionally) an icon.
 *
 * Must be hosted within a [PillButtonContainer] composable.
 *
 * ```
 * PillButton(
 *     onClick = { visible = false },
 *     icon = {
 *         Icon(
 *             painter = Icons.ArrowUp,
 *             contentDescription = null,
 *         ),
 *     },
 * )
 */
@Suppress("UnusedReceiverParameter")
@Composable
fun PillButtonContainerScope.PillButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    SPSurface(
        onClick = onClick,
        interactionSource = interactionSource,
        color = SPTheme.colors.contentColors.normal,
        shape = CircleShape,
        modifier = modifier
            .semantics { role = Role.Button }
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 6.dp,
            ),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {

            icon()
            content()

        }
    }
}

private const val AnimationDurationMillis = 300

@LayoutScopeMarker
@Immutable
interface PillButtonContainerScope

private object PillButtonContainerScopeInstance : PillButtonContainerScope
