package com.example.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.NewsItem
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.TextSlate800
import kotlinx.coroutines.delay

@Composable
fun BreakingNewsTickerComponent(
    newsItem: NewsItem? = null,
    breakingList: List<NewsItem> = emptyList(),
    onClick: (NewsItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = remember(newsItem, breakingList) {
        if (breakingList.isNotEmpty()) breakingList else if (newsItem != null) listOf(newsItem) else emptyList()
    }
    if (items.isEmpty()) return

    var currentIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(items.size) {
        if (items.size > 1) {
            while (true) {
                delay(5000)
                currentIndex = (currentIndex + 1) % items.size
            }
        }
    }

    val currentItem = items.getOrElse(currentIndex) { items.first() }

    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1.25f,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFFEF2F2))
            .clickable { onClick(currentItem) }
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // [🔴 BREAKING NEWS] badge
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(RedPrimary)
                    .padding(horizontal = 7.dp, vertical = 3.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .scale(pulseScale)
                            .clip(CircleShape)
                            .background(PureWhite)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "ব্রেকিং নিউজ",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.4.sp,
                        color = PureWhite
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Time badge (e.g. এইমাত্র, ৫ মিনিট আগে)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(RedPrimary.copy(alpha = 0.1f))
                    .padding(horizontal = 5.dp, vertical = 2.dp)
            ) {
                Text(
                    text = currentItem.timeAgo,
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = RedPrimary
                )
            }

            Spacer(modifier = Modifier.width(6.dp))

            // Animated headline
            AnimatedContent(
                targetState = currentItem,
                transitionSpec = {
                    (slideInVertically { height -> height } + fadeIn()) togetherWith
                            (slideOutVertically { height -> -height } + fadeOut())
                },
                modifier = Modifier.weight(1f),
                label = "breakingTickerAnimation"
            ) { targetItem ->
                Text(
                    text = "${targetItem.source} : ${targetItem.title}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextSlate800,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.basicMarquee()
                )
            }
        }
    }
}
