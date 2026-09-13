package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.SportsCricket
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NewsRepository
import com.example.model.AppNotification
import com.example.model.NewsItem
import com.example.model.NotificationType
import com.example.ui.theme.BorderLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.TextSlate600
import com.example.ui.theme.TextSlate800

@Composable
fun NotificationsScreen(
    onBack: () -> Unit,
    onNotificationClick: (NewsItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PureWhite)
            .statusBarsPadding()
            .testTag("notifications_screen")
    ) {
        // Header: Back Arrow + "নোটিফিকেশন"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
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

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "নোটিফিকেশন",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                color = TextSlate800
            )
        }

        // Notification list matching Image 10
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(NewsRepository.notificationsList, key = { it.id }) { notif ->
                NotificationItemCard(
                    notification = notif,
                    onClick = {
                        // Find related article or default to featured
                        val article = when (notif.type) {
                            NotificationType.BREAKING -> NewsRepository.electionFeaturedNews
                            NotificationType.SPORTS -> NewsRepository.featuredSlides[2]
                            NotificationType.BUSINESS -> NewsRepository.latestNewsList[1]
                            else -> NewsRepository.electionFeaturedNews
                        }
                        onNotificationClick(article)
                    }
                )
            }
        }
    }
}

@Composable
fun NotificationItemCard(
    notification: AppNotification,
    onClick: () -> Unit
) {
    val (iconBgColor, iconColor, categoryColor) = when (notification.type) {
        NotificationType.BREAKING -> Triple(RedPrimary, PureWhite, RedPrimary)
        NotificationType.INTERNATIONAL -> Triple(Color(0xFFE2E8F0), Color(0xFF475569), Color(0xFF334155))
        NotificationType.SPORTS -> Triple(Color(0xFF16A34A), PureWhite, Color(0xFF16A34A))
        NotificationType.BUSINESS -> Triple(Color(0xFFEA580C), PureWhite, Color(0xFFEA580C))
        NotificationType.EDUCATION -> Triple(Color(0xFF0284C7), PureWhite, Color(0xFF0284C7))
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = PureWhite),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderLight)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Circular Category Icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(iconBgColor),
                contentAlignment = Alignment.Center
            ) {
                when (notification.type) {
                    NotificationType.BREAKING -> Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(22.dp)
                    )
                    NotificationType.INTERNATIONAL -> Icon(
                        imageVector = Icons.Filled.Public,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(20.dp)
                    )
                    NotificationType.SPORTS -> Icon(
                        imageVector = Icons.Filled.SportsCricket,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(20.dp)
                    )
                    NotificationType.BUSINESS -> Icon(
                        imageVector = Icons.Filled.ShowChart,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(20.dp)
                    )
                    NotificationType.EDUCATION -> Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = notification.category,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp
                    ),
                    color = categoryColor
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = notification.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.5.sp,
                        lineHeight = 18.sp
                    ),
                    color = TextSlate800
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = notification.time,
                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.5.sp),
                    color = TextSlate600
                )
            }
        }
    }
}
