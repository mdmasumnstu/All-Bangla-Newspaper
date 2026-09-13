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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NewsRepository
import com.example.model.NewsItem
import com.example.model.Newspaper
import com.example.ui.theme.BorderGray
import com.example.ui.theme.BorderLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.SubtleGray
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextSlate600
import com.example.ui.theme.TextSlate800

@Composable
fun SearchScreen(
    searchQuery: String,
    selectedFilter: String,
    onSearchQueryChange: (String) -> Unit,
    onFilterChange: (String) -> Unit,
    onBack: () -> Unit,
    onArticleClick: (NewsItem) -> Unit,
    onNewspaperClick: (Newspaper) -> Unit,
    modifier: Modifier = Modifier
) {
    val filterTabs = listOf("সব", "পত্রিকা", "সংবাদ", "ভিডিও")

    val allArticles = remember {
        listOf(NewsRepository.electionFeaturedNews) + NewsRepository.latestNewsList + NewsRepository.popularNewsList
    }

    // Filter results based on search query and selected filter
    val filteredArticles = remember(searchQuery, selectedFilter) {
        val query = searchQuery.trim().lowercase()
        if (selectedFilter == "পত্রিকা") {
            emptyList()
        } else {
            if (query.isEmpty()) {
                allArticles
            } else {
                allArticles.filter {
                    it.title.lowercase().contains(query) ||
                            it.source.lowercase().contains(query) ||
                            it.category.lowercase().contains(query)
                }
            }
        }
    }

    val filteredNewspapers = remember(searchQuery, selectedFilter) {
        val query = searchQuery.trim().lowercase()
        if (selectedFilter == "সংবাদ" || selectedFilter == "ভিডিও") {
            emptyList()
        } else {
            if (query.isEmpty()) {
                if (selectedFilter == "পত্রিকা") NewsRepository.newspapersList else emptyList()
            } else {
                NewsRepository.newspapersList.filter {
                    it.nameBangla.lowercase().contains(query) ||
                            it.nameEnglish.lowercase().contains(query)
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PureWhite)
            .statusBarsPadding()
            .testTag("search_screen")
    ) {
        // Top Header: Back Arrow + "খুঁজুন"
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
                text = "খুঁজুন",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                color = TextSlate800
            )
        }

        // Search Input Field with Clear (✕) Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .testTag("search_screen_input"),
                placeholder = {
                    Text(
                        text = "বাংলাদেশ নির্বাচন...",
                        fontSize = 14.sp,
                        color = TextMuted
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = null,
                        tint = RedPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { onSearchQueryChange("") }) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "মুছে ফেলুন",
                                tint = TextMuted,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = RedPrimary,
                    unfocusedBorderColor = BorderGray,
                    focusedContainerColor = PureWhite,
                    unfocusedContainerColor = SubtleGray
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {})
            )
        }

        // Filter Tabs: সব, পত্রিকা, সংবাদ, ভিডিও
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(filterTabs) { tab ->
                val isSelected = tab == selectedFilter
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isSelected) RedPrimary else SubtleGray)
                        .clickable { onFilterChange(tab) }
                        .padding(horizontal = 16.dp, vertical = 7.dp)
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

        // Search Results List
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // Newspapers matching search
            if (filteredNewspapers.isNotEmpty()) {
                items(filteredNewspapers, key = { "np_${it.id}" }) { newspaper ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onNewspaperClick(newspaper) },
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = PureWhite),
                        border = androidx.compose.foundation.BorderStroke(1.dp, BorderLight)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(newspaper.primaryColorHex)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = newspaper.logoText.take(2),
                                    color = PureWhite,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = newspaper.nameBangla,
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = TextSlate800
                                )
                                Text(
                                    text = "${newspaper.nameEnglish} • পত্রিকা",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = TextSlate600
                                )
                            }
                        }
                    }
                }
            }

            // News Articles matching search
            items(filteredArticles, key = { "art_${it.id}" }) { article ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onArticleClick(article) }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Newspaper / Source Logo badge
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(RedPrimary.copy(alpha = 0.08f))
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = article.source,
                                color = RedPrimary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = article.title,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 13.5.sp,
                                    lineHeight = 18.sp
                                ),
                                color = TextSlate800,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = "🕒 ${article.timeAgo}",
                                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.5.sp),
                                color = TextSlate600
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(BorderLight)
                    )
                }
            }

            if (filteredArticles.isEmpty() && filteredNewspapers.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "কোনো ফলাফল পাওয়া যায়নি",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                color = TextSlate800
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "ভিন্ন কীওয়ার্ড দিয়ে পুনরায় অনুসন্ধান করুন।",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextSlate600
                            )
                        }
                    }
                }
            }
        }
    }
}
