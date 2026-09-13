package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = RedLight,
    onPrimary = PureWhite,
    primaryContainer = RedDark,
    onPrimaryContainer = PureWhite,
    secondary = RedLight,
    onSecondary = PureWhite,
    background = DarkBackground,
    surface = DarkSurface,
    surfaceVariant = DarkCard,
    outline = DarkBorder,
    onBackground = DarkTextPrimary,
    onSurface = DarkTextPrimary,
    onSurfaceVariant = DarkTextSecondary
  )

private val LightColorScheme =
  lightColorScheme(
    primary = RedPrimary,
    onPrimary = PureWhite,
    primaryContainer = RedContainer,
    onPrimaryContainer = OnRedContainer,
    secondary = RedPrimary,
    onSecondary = PureWhite,
    background = PureWhite,
    surface = PureWhite,
    surfaceVariant = SubtleGray,
    outline = BorderGray,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onSurfaceVariant = TextSecondary
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
