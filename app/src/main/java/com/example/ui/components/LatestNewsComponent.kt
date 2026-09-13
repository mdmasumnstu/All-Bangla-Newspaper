package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.BookmarkBorder
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.NewsItem
import com.example.ui.theme.BorderGray
import com.example.ui.theme.BorderLight
import com.example.ui.theme.CardBackground
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.SubtleGray
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextSlate800

@Composable
fun LatestNewsComponent(
    newsList: List<NewsItem>,
    bookmarkedIds: Set<String>,
    onArticleClick: (NewsItem) -> Unit,
    onBookmarkToggle: (String) -> Unit,
    onSeeAllClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Section Header: সর্বশেষ সংবাদ  [🔴 লাইভ আপডেট]     সব দেখুন →
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "সর্বশেষ সংবাদ",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    color = TextSlate800
                )
                Spacer(modifier = Modifier.width(8.dp))
                // Live indicator badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFFFEF2F2))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(5.dp)
                                .clip(CircleShape)
                                .background(RedPrimary)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "লাইভ আপডেট",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = RedPrimary
                        )
                    }
                }
            }

            // সব দেখুন →
            Text(
                text = "সব দেখুন →",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                ),
                color = RedPrimary,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .clickable { onSeeAllClick() }
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            )
        }

        // List of news items with clean borders
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            newsList.forEachIndexed { index, newsItem ->
                val isBookmarked = bookmarkedIds.contains(newsItem.id)
                LatestNewsCard(
                    newsItem = newsItem,
                    isBookmarked = isBookmarked,
                    onClick = { onArticleClick(newsItem) },
                    onBookmarkToggle = { onBookmarkToggle(newsItem.id) },
                    testTag = "latest_news_item_$index"
                )
            }
        }
    }
}

@Composable
fun LatestNewsCard(
    newsItem: NewsItem,
    isBookmarked: Boolean,
    onClick: () -> Unit,
    onBookmarkToggle: () -> Unit,
    testTag: String = "latest_news_card"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag(testTag)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Thumbnail on the left (w-24 h-20 rounded-xl)
            Box(
                modifier = Modifier
                    .size(width = 96.dp, height = 76.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(SubtleGray)
            ) {
                Image(
                    painter = painterResource(id = newsItem.imageRes),
                    contentDescription = newsItem.title,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Details on the right
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Bengali Headline (text-sm font-semibold text-slate-800 leading-tight)
                Text(
                    text = newsItem.title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        lineHeight = 19.sp
                    ),
                    color = TextSlate800,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Metadata: Category • Source • Time & Bookmark affordance
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        if (newsItem.isLive) {
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(CircleShape)
                                    .background(RedPrimary)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                        Text(
                            text = "${newsItem.source} • ${newsItem.timeAgo}",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 11.sp,
                                fontWeight = if (newsItem.isLive) FontWeight.SemiBold else FontWeight.Normal
                            ),
                            color = if (newsItem.isLive) RedPrimary else TextMuted
                        )
                        if (newsItem.viewsCount != null) {
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "• ${newsItem.viewsCount}",
                                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.5.sp),
                                color = TextMuted
                            )
                        }
                    }

                    // Bookmark icon
                    IconButton(
                        onClick = onBookmarkToggle,
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = if (isBookmarked) "বুকমার্ক সরানো" else "বুকমার্ক সংরক্ষণ",
                            tint = if (isBookmarked) RedPrimary else TextMuted,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }

        // Border bottom (border-b border-gray-50/border-gray-100)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(BorderLight)
        )
    }
}
