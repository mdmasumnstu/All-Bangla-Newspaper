package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Newspaper
import com.example.ui.theme.BorderGray
import com.example.ui.theme.BorderLight
import com.example.ui.theme.CardBackground
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.SubtleGray
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextSlate600
import com.example.ui.theme.TextSlate800

@Composable
fun NewspapersRowComponent(
    newspapers: List<Newspaper>,
    favoriteIds: Set<String>,
    onNewspaperClick: (Newspaper) -> Unit,
    onFavoriteToggle: (String) -> Unit,
    onSeeAllClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Section Header: প্রধান সংবাদপত্র       সব দেখুন →
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "প্রধান সংবাদপত্র",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                color = TextSlate800
            )

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

        // Horizontal scrolling newspaper cards
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("main_newspapers_lazy_row")
        ) {
            items(newspapers, key = { it.id }) { newspaper ->
                val isFavorite = favoriteIds.contains(newspaper.id)
                NewspaperCardItem(
                    newspaper = newspaper,
                    isFavorite = isFavorite,
                    onClick = { onNewspaperClick(newspaper) },
                    onFavoriteToggle = { onFavoriteToggle(newspaper.id) }
                )
            }
        }
    }
}

@Composable
fun NewspaperCardItem(
    newspaper: Newspaper,
    isFavorite: Boolean,
    onClick: () -> Unit,
    onFavoriteToggle: () -> Unit
) {
    val brandColor = Color(newspaper.primaryColorHex)

    Column(
        modifier = Modifier
            .width(76.dp)
            .clickable { onClick() }
            .testTag("newspaper_card_${newspaper.id}"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Newspaper Logo Box (56dp x 56dp rounded-2xl bg-white border border-gray-100 shadow-sm)
        Box(
            modifier = Modifier
                .size(56.dp)
                .shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(16.dp),
                    spotColor = Color(0x10000000)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(PureWhite)
                .border(
                    width = 1.dp,
                    color = BorderLight,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            // Stylized brand container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(34.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(brandColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = newspaper.logoText,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Black,
                        fontSize = 13.sp
                    ),
                    color = PureWhite
                )
            }

            // Small subtle favorite indicator in top corner
            if (isFavorite) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(RedPrimary)
                        .align(Alignment.TopEnd)
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Newspaper Name Below (text-[10px] font-medium text-slate-600)
        Text(
            text = newspaper.nameBangla,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 14.sp
            ),
            color = TextSlate600,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}
