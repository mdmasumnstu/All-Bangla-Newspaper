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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Agriculture
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.LocalFlorist
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Mosque
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.outlined.Search
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NewsRepository
import com.example.model.NewsCategory
import com.example.model.NewsItem
import com.example.ui.theme.BorderLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.TextSlate800

@Composable
fun CategoriesScreen(
    selectedCategory: String,
    bookmarkedIds: Set<String>,
    onCategorySelected: (String) -> Unit,
    onArticleClick: (NewsItem) -> Unit,
    onBookmarkToggle: (String) -> Unit,
    onSearchClick: () -> Unit = {},
    onBack: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PureWhite)
            .statusBarsPadding()
            .testTag("categories_screen")
    ) {
        // Top Header: Back Arrow + "সংবাদ বিভাগ" + Search Icon
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
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
                    text = "সংবাদ বিভাগ",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    ),
                    color = TextSlate800
                )
            }

            IconButton(
                onClick = onSearchClick,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "অনুসন্ধান",
                    tint = TextSlate800,
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        // 2-Column Grid of 14 Categories matching Image 3
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(NewsRepository.categories, key = { it.id }) { category ->
                CategoryGridItemCard(
                    category = category,
                    isSelected = category.nameBangla == selectedCategory,
                    onClick = {
                        onCategorySelected(category.nameBangla)
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryGridItemCard(
    category: NewsCategory,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val (icon, iconColor) = getCategoryIconAndColor(category.nameBangla)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp)
            .clickable { onClick() }
            .testTag("category_card_${category.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFFFEF2F2) else PureWhite
        ),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (isSelected) Color(0xFFEF4444) else BorderLight
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Rounded Icon container
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(iconColor.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = category.nameBangla,
                    tint = iconColor,
                    modifier = Modifier.size(22.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = category.nameBangla,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.5.sp
                ),
                color = TextSlate800
            )
        }
    }
}

fun getCategoryIconAndColor(name: String): Pair<ImageVector, Color> {
    return when (name) {
        "বাংলাদেশ" -> Pair(Icons.Filled.Flag, Color(0xFF16A34A))
        "আন্তর্জাতিক" -> Pair(Icons.Filled.Public, Color(0xFF0284C7))
        "রাজনীতি" -> Pair(Icons.Filled.AccountBalance, Color(0xFF475569))
        "ব্যবসা" -> Pair(Icons.Filled.ShowChart, Color(0xFF16A34A))
        "খেলাধুলা" -> Pair(Icons.Filled.SportsSoccer, Color(0xFFDC2626))
        "শিক্ষা" -> Pair(Icons.Filled.School, Color(0xFF2563EB))
        "বিনোদন" -> Pair(Icons.Filled.Movie, Color(0xFFE11D48))
        "প্রযুক্তি" -> Pair(Icons.Filled.Memory, Color(0xFF0284C7))
        "স্বাস্থ্য" -> Pair(Icons.Filled.Favorite, Color(0xFFEF4444))
        "লাইফস্টাইল" -> Pair(Icons.Filled.LocalFlorist, Color(0xFF059669))
        "চাকরি" -> Pair(Icons.Filled.BusinessCenter, Color(0xFF7C3AED))
        "ধর্ম" -> Pair(Icons.Filled.Mosque, Color(0xFFD97706))
        "ভ্রমণ" -> Pair(Icons.Filled.Flight, Color(0xFF0284C7))
        "কৃষি" -> Pair(Icons.Filled.Agriculture, Color(0xFF16A34A))
        else -> Pair(Icons.Filled.Public, Color(0xFF475569))
    }
}
