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
import androidx.compose.foundation.layout.fillMaxSize
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
fun PopularNewsComponent(
    popularList: List<NewsItem>,
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
        // Section Header: জনপ্রিয় সংবাদ  [🔥 ট্রেন্ডিং]     সব দেখুন →
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "জনপ্রিয় সংবাদ",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    color = TextSlate800
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFFFFF7ED))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "🔥 ট্রেন্ডিং",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFEA580C)
                    )
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

        // Numbered List: 01, 02, 03, 04
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            popularList.forEachIndexed { index, newsItem ->
                val isBookmarked = bookmarkedIds.contains(newsItem.id)
                val rankNumber = newsItem.rank ?: String.format("%02d", index + 1)
                PopularNewsCard(
                    rank = rankNumber,
                    newsItem = newsItem,
                    isBookmarked = isBookmarked,
                    onClick = { onArticleClick(newsItem) },
                    onBookmarkToggle = { onBookmarkToggle(newsItem.id) },
                    testTag = "popular_news_item_$index"
                )
            }
        }
    }
}

@Composable
fun PopularNewsCard(
    rank: String,
    newsItem: NewsItem,
    isBookmarked: Boolean,
    onClick: () -> Unit,
    onBookmarkToggle: () -> Unit,
    testTag: String = "popular_news_card"
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
            // Ranking Number badge (e.g. 01, 02, 03, 04)
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(RedPrimary.copy(alpha = 0.08f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = rank,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    ),
                    color = RedPrimary
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Details (Headline + Newspaper + Time)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = newsItem.title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.5.sp,
                        lineHeight = 18.5.sp
                    ),
                    color = TextSlate800,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = newsItem.source,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp
                        ),
                        color = RedPrimary
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "• ${newsItem.timeAgo}",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 10.5.sp
                        ),
                        color = TextMuted
                    )
                    if (newsItem.viewsCount != null) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "• ${newsItem.viewsCount}",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = Color(0xFFEA580C)
                        )
                    }
                }
            }

            // Small Thumbnail on the right
            Box(
                modifier = Modifier
                    .size(width = 68.dp, height = 56.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(SubtleGray)
            ) {
                Image(
                    painter = painterResource(id = newsItem.imageRes),
                    contentDescription = newsItem.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            // Bookmark Icon
            IconButton(
                onClick = onBookmarkToggle,
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                    contentDescription = if (isBookmarked) "বুকমার্ক সরানো" else "বুকমার্ক করুন",
                    tint = if (isBookmarked) RedPrimary else TextMuted,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        // Border bottom divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(BorderLight)
        )
    }
}
