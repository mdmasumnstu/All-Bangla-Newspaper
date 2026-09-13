package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.FormatSize
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.NewsUiState
import com.example.ui.components.SmritiSoudhoGraphic
import com.example.ui.theme.BorderLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.SubtleGray
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextSlate600
import com.example.ui.theme.TextSlate800

@Composable
fun SettingsScreen(
    uiState: NewsUiState,
    onFontSizeChange: (Int) -> Unit,
    onToggleNotifications: () -> Unit,
    onToggleDarkMode: () -> Unit,
    onNavigateToFavorites: () -> Unit = {},
    onNavigateToSaved: () -> Unit = {},
    onShowSplash: () -> Unit = {},
    onBack: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    var showFontSizeDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PureWhite)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .testTag("settings_screen")
    ) {
        // Header: Back Arrow + "সেটিংস"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (onBack != null) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "ফিরে যান",
                        tint = TextSlate800,
                        modifier = Modifier.size(22.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
            } else {
                Spacer(modifier = Modifier.width(6.dp))
            }

            Text(
                text = "সেটিংস",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                color = TextSlate800
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Settings Items Container Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = PureWhite),
            border = androidx.compose.foundation.BorderStroke(1.dp, BorderLight)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                // 1. প্রোফাইল
                SettingsMenuItem(
                    icon = Icons.Outlined.Person,
                    title = "প্রোফাইল",
                    onClick = {}
                )
                DividerLine()

                // 2. নোটিফিকেশন [Switch]
                SettingsSwitchItem(
                    icon = Icons.Outlined.Notifications,
                    title = "নোটিফিকেশন",
                    isChecked = uiState.notificationEnabled,
                    onCheckedChange = { onToggleNotifications() }
                )
                DividerLine()

                // 3. ডার্ক মোড [Switch]
                SettingsSwitchItem(
                    icon = Icons.Outlined.DarkMode,
                    title = "ডার্ক মোড",
                    isChecked = uiState.isDarkMode,
                    onCheckedChange = { onToggleDarkMode() }
                )
                DividerLine()

                // 4. ফন্ট সাইজ
                SettingsMenuItem(
                    icon = Icons.Outlined.FormatSize,
                    title = "ফন্ট সাইজ",
                    trailingText = "${uiState.readerFontSizeSp} sp",
                    onClick = { showFontSizeDialog = !showFontSizeDialog }
                )

                // Expandable Font Size Slider
                if (showFontSizeDialog) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(SubtleGray.copy(alpha = 0.5f))
                            .padding(horizontal = 20.dp, vertical = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "সংবাদ পড়ার ফন্ট সাইজ",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = TextSlate800
                            )
                            Text(
                                text = "${uiState.readerFontSizeSp} sp",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = RedPrimary
                            )
                        }
                        Slider(
                            value = uiState.readerFontSizeSp.toFloat(),
                            onValueChange = { onFontSizeChange(it.toInt()) },
                            valueRange = 13f..24f,
                            steps = 11,
                            colors = SliderDefaults.colors(
                                thumbColor = RedPrimary,
                                activeTrackColor = RedPrimary,
                                inactiveTrackColor = Color(0xFFCBD5E1)
                            )
                        )
                        Text(
                            text = "বাংলা সংবাদের নমুনা প্রিভিউ টেক্সট",
                            fontSize = uiState.readerFontSizeSp.sp,
                            lineHeight = (uiState.readerFontSizeSp + 6).sp,
                            color = TextSlate600
                        )
                    }
                }
                DividerLine()

                // 5. ভাষা
                SettingsMenuItem(
                    icon = Icons.Outlined.Language,
                    title = "ভাষা",
                    trailingText = "বাংলা",
                    onClick = {}
                )
                DividerLine()

                // 6. পছন্দের পত্রিকা
                SettingsMenuItem(
                    icon = Icons.Outlined.FavoriteBorder,
                    title = "পছন্দের পত্রিকা",
                    onClick = onNavigateToFavorites
                )
                DividerLine()

                // 7. সংরক্ষিত সংবাদ
                SettingsMenuItem(
                    icon = Icons.Outlined.BookmarkBorder,
                    title = "সংরক্ষিত সংবাদ",
                    onClick = onNavigateToSaved
                )
                DividerLine()

                // 8. অ্যাপ সম্পর্কে (Opens Splash preview)
                SettingsMenuItem(
                    icon = Icons.Outlined.Info,
                    title = "অ্যাপ সম্পর্কে",
                    onClick = onShowSplash
                )
                DividerLine()

                // 9. গোপনীয়তা নীতি
                SettingsMenuItem(
                    icon = Icons.Outlined.Lock,
                    title = "গোপনীয়তা নীতি",
                    onClick = {}
                )
                DividerLine()

                // 10. ব্যবহারের শর্তাবলী
                SettingsMenuItem(
                    icon = Icons.Outlined.Description,
                    title = "ব্যবহারের শর্তাবলী",
                    onClick = {}
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Bottom Illustration: National Martyrs' Memorial silhouette + Tagline
        SmritiSoudhoGraphic(
            tagline = "সত্য সংবাদ, সচেতন সমাজ",
            subTagline = "একটি ভালো বাংলাদেশ",
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}

@Composable
fun SettingsMenuItem(
    icon: ImageVector,
    title: String,
    trailingText: String? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = TextSlate600,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            ),
            color = TextSlate800,
            modifier = Modifier.weight(1f)
        )

        if (trailingText != null) {
            Text(
                text = trailingText,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp
                ),
                color = RedPrimary
            )
            Spacer(modifier = Modifier.width(4.dp))
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = TextMuted,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
fun SettingsSwitchItem(
    icon: ImageVector,
    title: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = TextSlate600,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            ),
            color = TextSlate800,
            modifier = Modifier.weight(1f)
        )

        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = PureWhite,
                checkedTrackColor = RedPrimary,
                uncheckedThumbColor = PureWhite,
                uncheckedTrackColor = Color(0xFFCBD5E1)
            )
        )
    }
}

@Composable
fun DividerLine() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(BorderLight)
    )
}
