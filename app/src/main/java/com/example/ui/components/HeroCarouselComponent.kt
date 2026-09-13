package com.example.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.NewsItem
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary

@Composable
fun HeroCarouselComponent(
    slides: List<NewsItem>,
    activeSlideIndex: Int,
    onArticleClick: (NewsItem) -> Unit,
    onPrevSlide: () -> Unit,
    onNextSlide: () -> Unit,
    onDotClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    if (slides.isEmpty()) return
    val currentItem = slides[activeSlideIndex.coerceIn(0, slides.size - 1)]

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .testTag("hero_carousel_section")
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(16.dp))
                .clickable { onArticleClick(currentItem) },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // Background image
                Image(
                    painter = painterResource(id = currentItem.imageRes),
                    contentDescription = currentItem.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Dark gradient overlay for text readability
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color(0x70000000),
                                    Color(0xE6000000)
                                ),
                                startY = 30f
                            )
                        )
                )

                // Left Chevron < Button
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 6.dp)
                ) {
                    IconButton(
                        onClick = onPrevSlide,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0x66000000))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "পূর্ববর্তী স্লাইড",
                            tint = PureWhite,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                // Right Chevron > Button
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 6.dp)
                ) {
                    IconButton(
                        onClick = onNextSlide,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0x66000000))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "পরবর্তী স্লাইড",
                            tint = PureWhite,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                // Headline, Subtitle, and Time Ago at Bottom Left
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .padding(start = 14.dp, end = 14.dp, bottom = 12.dp)
                ) {
                    Text(
                        text = currentItem.title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            lineHeight = 20.sp
                        ),
                        color = PureWhite,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    if (currentItem.summary.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = currentItem.summary,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 11.5.sp,
                                lineHeight = 15.sp
                            ),
                            color = Color(0xFFE2E8F0),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "🕒 ${currentItem.timeAgo}",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = Color(0xFFCBD5E1)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 3 Indicator Dots (Active is Red Oval/Pill, Inactive are Grey Dots)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            slides.indices.forEach { index ->
                val isActive = index == activeSlideIndex
                Box(
                    modifier = Modifier
                        .padding(horizontal = 3.5.dp)
                        .height(6.dp)
                        .width(if (isActive) 18.dp else 6.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(if (isActive) RedPrimary else Color(0xFFCBD5E1))
                        .clickable { onDotClick(index) }
                )
            }
        }
    }
}
