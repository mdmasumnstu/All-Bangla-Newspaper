package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NewsRepository
import com.example.model.NewsItem
import com.example.model.Newspaper
import com.example.ui.BottomNavTab
import com.example.ui.NewsUiState
import com.example.ui.components.BreakingNewsTickerComponent
import com.example.ui.components.CategoriesRowComponent
import com.example.ui.components.HeroCarouselComponent
import com.example.ui.components.LatestNewsComponent
import com.example.ui.components.NewspapersRowComponent
import com.example.ui.components.PopularNewsComponent
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary

@Composable
fun HomeScreen(
    uiState: NewsUiState,
    onArticleClick: (NewsItem) -> Unit,
    onNewspaperClick: (Newspaper) -> Unit,
    onBookmarkToggle: (String) -> Unit,
    onFavoriteNewspaperToggle: (String) -> Unit,
    onCategorySelected: (String) -> Unit,
    onNavigateTab: (BottomNavTab) -> Unit,
    onSeeAllNewspapers: () -> Unit,
    onPrevSlide: () -> Unit,
    onNextSlide: () -> Unit,
    onSlideDotClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    val filteredLatestNews = remember(uiState.selectedCategory) {
        if (uiState.selectedCategory == "সকল" || uiState.selectedCategory == "সর্বশেষ") {
            NewsRepository.latestNewsList
        } else {
            NewsRepository.latestNewsList.filter { item ->
                item.category.contains(uiState.selectedCategory) ||
                        uiState.selectedCategory.contains(item.category)
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PureWhite)
            .verticalScroll(scrollState)
            .testTag("home_screen_scrollable")
    ) {
        // Active Filter notice if category is selected
        if (uiState.selectedCategory != "সকল" && uiState.selectedCategory != "সর্বশেষ") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "নির্বাচিত বিভাগ: “${uiState.selectedCategory}”",
                    fontSize = 12.sp,
                    color = RedPrimary
                )
            }
        }

        // 1. Breaking News Ticker (🔴 BREAKING NEWS + Marquee text)
        BreakingNewsTickerComponent(
            newsItem = NewsRepository.electionFeaturedNews,
            onClick = { onArticleClick(NewsRepository.electionFeaturedNews) }
        )

        // 2. Horizontal Sub-Categories row: সর্বশেষ, বাংলাদেশ, রাজনীতি, আন্তর্জাতিক, ব্যবসা, etc.
        CategoriesRowComponent(
            categories = NewsRepository.categories,
            selectedCategory = uiState.selectedCategory,
            onCategorySelected = onCategorySelected
        )

        // 3. Hero Carousel Banner Slider (Parliament / Election image + Title + chevrons < > + dots)
        HeroCarouselComponent(
            slides = NewsRepository.featuredSlides,
            activeSlideIndex = uiState.activeSlideIndex,
            onArticleClick = onArticleClick,
            onPrevSlide = onPrevSlide,
            onNextSlide = onNextSlide,
            onDotClick = onSlideDotClick
        )

        Spacer(modifier = Modifier.height(4.dp))

        // 4. Latest News (সর্বশেষ সংবাদ - সব দেখুন >)
        LatestNewsComponent(
            newsList = if (filteredLatestNews.isNotEmpty()) filteredLatestNews else NewsRepository.latestNewsList,
            bookmarkedIds = uiState.bookmarkedIds,
            onArticleClick = onArticleClick,
            onBookmarkToggle = onBookmarkToggle,
            onSeeAllClick = { onNavigateTab(BottomNavTab.CATEGORIES) }
        )

        Spacer(modifier = Modifier.height(6.dp))

        // 5. Bangladesh Newspapers Row (প্রধান সংবাদপত্র - সব দেখুন >)
        NewspapersRowComponent(
            newspapers = NewsRepository.newspapersList,
            favoriteIds = uiState.favoriteNewspaperIds,
            onNewspaperClick = onNewspaperClick,
            onFavoriteToggle = onFavoriteNewspaperToggle,
            onSeeAllClick = onSeeAllNewspapers
        )

        Spacer(modifier = Modifier.height(6.dp))

        // 6. Popular News (জনপ্রিয় সংবাদ 01, 02, 03, 04)
        PopularNewsComponent(
            popularList = NewsRepository.popularNewsList,
            bookmarkedIds = uiState.bookmarkedIds,
            onArticleClick = onArticleClick,
            onBookmarkToggle = onBookmarkToggle,
            onSeeAllClick = { onNavigateTab(BottomNavTab.CATEGORIES) }
        )

        Spacer(modifier = Modifier.height(28.dp))
    }
}
