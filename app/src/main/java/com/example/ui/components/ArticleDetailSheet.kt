package com.example.ui.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.NewsItem
import com.example.ui.theme.BorderLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.SubtleGray
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextSlate600
import com.example.ui.theme.TextSlate800

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailSheet(
    article: NewsItem,
    isBookmarked: Boolean,
    fontSizeSp: Int,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    onBookmarkToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isExpanded by remember { mutableStateOf(false) }
    var isFavorite by remember { mutableStateOf(false) }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = PureWhite,
        modifier = modifier.testTag("article_detail_sheet")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
                .padding(bottom = 24.dp)
        ) {
            // Header: Back Arrow, Newspaper / Source Name, Share Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(SubtleGray)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "ফিরে যান",
                        tint = TextSlate800,
                        modifier = Modifier.size(18.dp)
                    )
                }

                Text(
                    text = article.source,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    ),
                    color = TextSlate800
                )

                IconButton(
                    onClick = {
                        val sendIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "${article.title}\n\nপড়ুন All Bangla Newspaper অ্যাপে।")
                            type = "text/plain"
                        }
                        context.startActivity(Intent.createChooser(sendIntent, "শেয়ার করুন"))
                    },
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(SubtleGray)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = "শেয়ার করুন",
                        tint = TextSlate800,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Headline
            Text(
                text = article.title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 28.sp
                ),
                color = TextSlate800
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Byline & Date/Time
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${article.author} • ${article.publishDate}",
                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.5.sp),
                    color = TextSlate600
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Hero Image
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                shape = RoundedCornerShape(14.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Image(
                    painter = painterResource(id = article.imageRes),
                    contentDescription = article.title,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Article Body Text
            Text(
                text = article.summary,
                fontSize = fontSizeSp.sp,
                lineHeight = (fontSizeSp + 8).sp,
                color = TextSlate800
            )

            if (isExpanded) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "নির্বাচন কমিশনার আরও বলেন, ভোটারদের ভোটাধিকার সুরক্ষায় আইনশৃঙ্খলা রক্ষাকারী বাহিনীর পর্যাপ্ত সদস্য দায়িত্ব পালন করবেন। এছাড়া দেশি ও বিদেশি পর্যবেক্ষকদের জন্যও বিশেষ ব্যবস্থা রাখা হয়েছে। নির্বাচনকালীন কোনো ধরনের বিশৃঙ্খলা বরদাশত করা হবে না বলে কঠোর হুঁশিয়ারি দেওয়া হয়।\n\nজনসাধারণের তথ্য প্রাপ্তি সহজ করতে প্রতিটি কেন্দ্রে আধুনিক তথ্যকেন্দ্র স্থাপন করা হচ্ছে। সার্বিক আইনশৃঙ্খলা স্বাভাবিক রাখতে নিয়মিত মনিটরিং সেল কাজ করবে।",
                    fontSize = fontSizeSp.sp,
                    lineHeight = (fontSizeSp + 8).sp,
                    color = TextSlate800
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // "আরও পড়ুন ∨" Expand / Collapse Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded = !isExpanded }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = if (isExpanded) "সংক্ষেপ করুন" else "আরও পড়ুন",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = RedPrimary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = null,
                        tint = RedPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Bottom Sticky Action Bar: পছন্দের, সংরক্ষণ, শেয়ার
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(SubtleGray)
                    .padding(vertical = 10.dp, horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Favorite
                Row(
                    modifier = Modifier
                        .clickable { isFavorite = !isFavorite }
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFavorite) RedPrimary else TextSlate600,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "পছন্দের",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isFavorite) RedPrimary else TextSlate800
                    )
                }

                // Bookmark / Save
                Row(
                    modifier = Modifier
                        .clickable { onBookmarkToggle() }
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = null,
                        tint = if (isBookmarked) RedPrimary else TextSlate600,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "সংরক্ষণ",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isBookmarked) RedPrimary else TextSlate800
                    )
                }

                // Share
                Row(
                    modifier = Modifier
                        .clickable {
                            val sendIntent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, "${article.title}\n\nপড়ুন All Bangla Newspaper অ্যাপে।")
                                type = "text/plain"
                            }
                            context.startActivity(Intent.createChooser(sendIntent, "শেয়ার করুন"))
                        }
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = null,
                        tint = TextSlate600,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "শেয়ার",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextSlate800
                    )
                }
            }
        }
    }
}
