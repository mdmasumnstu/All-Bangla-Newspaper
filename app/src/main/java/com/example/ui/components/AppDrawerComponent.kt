package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Flag
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.LiveTv
import androidx.compose.material.icons.outlined.Radio
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.SportsCricket
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.LightDivider
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedDark
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.SubtleGray
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun AppDrawerComponent(
    onCategoryClick: (String) -> Unit,
    onNavigateTab: (String) -> Unit,
    onCloseDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(PureWhite)
            .testTag("app_navigation_drawer")
    ) {
        // Red Header from reference screenshot
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(RedPrimary)
                .statusBarsPadding()
                .padding(horizontal = 20.dp, vertical = 22.dp)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(PureWhite.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = PureWhite,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "All Bangla Newspaper",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            ),
                            color = PureWhite
                        )
                        Text(
                            text = "প্রিয় সংবাদ ও সংবাদপত্র",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp
                            ),
                            color = PureWhite.copy(alpha = 0.85f)
                        )
                    }
                }
            }
        }

        // Scrollable Drawer Options
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(vertical = 8.dp)
        ) {
            DrawerMenuItem(
                icon = Icons.Outlined.Flag,
                title = "জাতীয় সংবাদ (National)",
                onClick = {
                    onCategoryClick("জাতীয়")
                    onCloseDrawer()
                }
            )
            DrawerMenuItem(
                icon = Icons.Outlined.Language,
                title = "আন্তর্জাতিক (International)",
                onClick = {
                    onCategoryClick("আন্তর্জাতিক")
                    onCloseDrawer()
                }
            )
            DrawerMenuItem(
                icon = Icons.Outlined.WorkOutline,
                title = "চাকরি ও ক্যারিয়ার (Jobs)",
                onClick = {
                    onCategoryClick("চাকরি")
                    onCloseDrawer()
                }
            )
            DrawerMenuItem(
                icon = Icons.Outlined.SportsCricket,
                title = "খেলাধুলা (Sports)",
                onClick = {
                    onCategoryClick("খেলাধুলা")
                    onCloseDrawer()
                }
            )
            DrawerMenuItem(
                icon = Icons.Outlined.Radio,
                title = "বাংলাদেশ বেতার ও রেডিও",
                onClick = {
                    onCloseDrawer()
                }
            )
            DrawerMenuItem(
                icon = Icons.Outlined.LiveTv,
                title = "টিভি চ্যানেল ও বুলেটিন",
                onClick = {
                    onCloseDrawer()
                }
            )

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = LightDivider
            )

            DrawerMenuItem(
                icon = Icons.Outlined.Share,
                title = "অ্যাপটি শেয়ার করুন",
                onClick = { onCloseDrawer() }
            )
            DrawerMenuItem(
                icon = Icons.Outlined.StarBorder,
                title = "প্লে স্টোরে রেটিং দিন",
                onClick = { onCloseDrawer() }
            )
            DrawerMenuItem(
                icon = Icons.Outlined.Settings,
                title = "সেটিংস ও ফন্ট সাইজ",
                onClick = {
                    onNavigateTab("SETTINGS")
                    onCloseDrawer()
                }
            )
            DrawerMenuItem(
                icon = Icons.Outlined.ExitToApp,
                title = "প্রস্থান (Exit)",
                onClick = { onCloseDrawer() }
            )
        }
    }
}

@Composable
private fun DrawerMenuItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = RedPrimary,
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            ),
            color = TextPrimary
        )
    }
}
