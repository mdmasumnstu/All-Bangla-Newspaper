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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NewspaperCatalog
import com.example.data.NewsRepository
import com.example.model.Newspaper
import com.example.ui.theme.BorderLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.SubtleGray
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextSlate600
import com.example.ui.theme.TextSlate800

@Composable
fun NewspapersScreen(
    favoriteIds: Set<String>,
    onNewspaperClick: (Newspaper) -> Unit,
    onFavoriteToggle: (String) -> Unit,
    selectedCategoryTab: String = "শীর্ষ পত্রিকা",
    onCategoryTabChange: (String) -> Unit = {},
    onSearchClick: () -> Unit = {},
    onBack: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    val categoryTabs = NewspaperCatalog.categoriesList

    val displayedNewspapers = remember(selectedCategoryTab, searchQuery) {
        val query = searchQuery.trim().lowercase()
        val baseList = NewspaperCatalog.getNewspapersByCategory(selectedCategoryTab)

        if (query.isEmpty()) {
            baseList
        } else {
            NewspaperCatalog.allNewspapers.filter { newspaper ->
                newspaper.nameBangla.lowercase().contains(query) ||
                        newspaper.nameEnglish.lowercase().contains(query) ||
                        newspaper.category.lowercase().contains(query)
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PureWhite)
            .statusBarsPadding()
            .testTag("newspapers_screen")
    ) {
        // Top Header: Back Arrow + "সকল পত্রিকা" + Search Icon
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

                Column {
                    Text(
                        text = "সকল সংবাদপত্র ও পোর্টাল",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        ),
                        color = TextSlate800
                    )
                    Text(
                        text = "মোট ১২০+ শীর্ষ পত্রিকা ও অনলাইন মিডিয়া",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.5.sp),
                        color = TextSlate600
                    )
                }
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

        // Category Filter Tabs (10 Categories + সকল)
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(categoryTabs) { tab ->
                val isSelected = tab == selectedCategoryTab
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isSelected) RedPrimary else SubtleGray)
                        .clickable { onCategoryTabChange(tab) }
                        .padding(horizontal = 14.dp, vertical = 7.dp)
                ) {
                    Text(
                        text = tab,
                        fontSize = 12.5.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) PureWhite else TextSlate600
                    )
                }
            }
        }

        // Search Input Bar: 🔍 পত্রিকার নাম লিখুন...
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                placeholder = {
                    Text(
                        text = "পত্রিকার নাম বা পোর্টাল খুঁজুন...",
                        fontSize = 13.sp,
                        color = TextMuted
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = null,
                        tint = TextMuted,
                        modifier = Modifier.size(18.dp)
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "মুছে ফেলুন",
                                tint = TextMuted,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = RedPrimary,
                    unfocusedBorderColor = BorderLight,
                    focusedContainerColor = PureWhite,
                    unfocusedContainerColor = PureWhite
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {})
            )
        }

        // Count Indicator
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${displayedNewspapers.size}টি পত্রিকা প্রদর্শিত হচ্ছে",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Medium,
                color = TextSlate600
            )

            Text(
                text = "ক্লিক করে সরাসরি পড়ুন 🌐",
                fontSize = 11.sp,
                color = RedPrimary,
                fontWeight = FontWeight.SemiBold
            )
        }

        // 2-Column Grid of Newspapers with direct explore capability
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(displayedNewspapers, key = { it.id }) { newspaper ->
                val isFavorite = favoriteIds.contains(newspaper.id)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNewspaperClick(newspaper) }
                        .testTag("newspaper_card_${newspaper.id}"),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = PureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, BorderLight)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Top bar inside card: category badge + favorite icon
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(SubtleGray)
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = newspaper.category,
                                    fontSize = 9.sp,
                                    color = TextSlate600,
                                    maxLines = 1
                                )
                            }

                            IconButton(
                                onClick = { onFavoriteToggle(newspaper.id) },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                    contentDescription = "পছন্দ",
                                    tint = if (isFavorite) RedPrimary else TextMuted,
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        // Newspaper Logo Badge (clickable to explore)
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(newspaper.primaryColorHex).copy(alpha = 0.12f))
                                .clickable { onNewspaperClick(newspaper) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = newspaper.logoText.take(4),
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                ),
                                color = Color(newspaper.primaryColorHex),
                                maxLines = 1,
                                textAlign = TextAlign.Center
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Name Bangla (clickable)
                        Text(
                            text = newspaper.nameBangla,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.5.sp
                            ),
                            color = TextSlate800,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.clickable { onNewspaperClick(newspaper) }
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        // Name English
                        Text(
                            text = newspaper.nameEnglish,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 10.5.sp
                            ),
                            color = TextSlate600,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Explore Chip
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(newspaper.primaryColorHex).copy(alpha = 0.08f))
                                .clickable { onNewspaperClick(newspaper) }
                                .padding(vertical = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Language,
                                    contentDescription = null,
                                    tint = Color(newspaper.primaryColorHex),
                                    modifier = Modifier.size(11.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "এক্সপ্লোর করুন",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(newspaper.primaryColorHex)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
