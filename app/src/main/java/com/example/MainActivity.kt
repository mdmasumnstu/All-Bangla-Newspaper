package com.example

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.BottomNavTab
import com.example.ui.NewsViewModel
import com.example.ui.SubScreen
import com.example.ui.components.ArticleDetailSheet
import com.example.ui.components.BottomNavComponent
import com.example.ui.components.NewspaperDetailSheet
import com.example.ui.components.TopBarComponent
import com.example.ui.screens.CategoriesScreen
import com.example.ui.screens.FavoritesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.NewspaperWebExplorerScreen
import com.example.ui.screens.NewspapersScreen
import com.example.ui.screens.NotificationsScreen
import com.example.ui.screens.SavedNewsScreen
import com.example.ui.screens.SearchScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.screens.SplashScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.PureWhite

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                AllBanglaNewsApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllBanglaNewsApp(
    viewModel: NewsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current

    val articleSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val newspaperSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    // Handle feedback snackbar
    LaunchedEffect(uiState.feedbackMessage) {
        uiState.feedbackMessage?.let { message ->
            snackbarHostState.showSnackbar(message)
            viewModel.clearFeedback()
        }
    }

    // System Back Handler
    BackHandler(enabled = uiState.activeSubScreen != null || uiState.selectedTab != BottomNavTab.HOME) {
        if (uiState.activeSubScreen != null) {
            viewModel.closeSubScreen()
        } else if (uiState.selectedTab != BottomNavTab.HOME) {
            viewModel.selectTab(BottomNavTab.HOME)
        }
    }

    // Full-screen SubScreens (Search, Notifications, All Newspapers, Splash, Web Explorer)
    when (uiState.activeSubScreen) {
        SubScreen.WEB_EXPLORER -> {
            uiState.exploringNewspaper?.let { newspaper ->
                NewspaperWebExplorerScreen(
                    newspaper = newspaper,
                    isFavorite = uiState.favoriteNewspaperIds.contains(newspaper.id),
                    onBack = { viewModel.closeWebExplorer() },
                    onFavoriteToggle = { viewModel.toggleFavoriteNewspaper(newspaper.id) },
                    onShowDetails = { viewModel.openNewspaper(newspaper) }
                )
            }
            return
        }
        SubScreen.SPLASH -> {
            SplashScreen(
                onContinue = { viewModel.closeSubScreen() }
            )
            return
        }
        SubScreen.SEARCH -> {
            SearchScreen(
                searchQuery = uiState.searchQuery,
                selectedFilter = uiState.searchFilter,
                onSearchQueryChange = { viewModel.setSearchQuery(it) },
                onFilterChange = { viewModel.setSearchFilter(it) },
                onBack = { viewModel.closeSubScreen() },
                onArticleClick = { viewModel.openArticle(it) },
                onNewspaperClick = { viewModel.exploreNewspaper(it) }
            )
            return
        }
        SubScreen.NOTIFICATIONS -> {
            NotificationsScreen(
                onBack = { viewModel.closeSubScreen() },
                onNotificationClick = { viewModel.openArticle(it) }
            )
            return
        }
        SubScreen.ALL_NEWSPAPERS -> {
            NewspapersScreen(
                favoriteIds = uiState.favoriteNewspaperIds,
                onNewspaperClick = { viewModel.exploreNewspaper(it) },
                onFavoriteToggle = { viewModel.toggleFavoriteNewspaper(it) },
                selectedCategoryTab = uiState.newspaperTab,
                onCategoryTabChange = { viewModel.setNewspaperTab(it) },
                onSearchClick = { viewModel.openSubScreen(SubScreen.SEARCH) },
                onBack = { viewModel.closeSubScreen() }
            )
            return
        }
        null -> {
            // Main scaffold with bottom navigation
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(PureWhite),
        topBar = {
            if (uiState.selectedTab == BottomNavTab.HOME) {
                TopBarComponent(
                    onSearchClick = {
                        viewModel.openSubScreen(SubScreen.SEARCH)
                    },
                    onNotificationsClick = {
                        viewModel.openSubScreen(SubScreen.NOTIFICATIONS)
                    },
                    hasUnreadNotifications = true
                )
            }
        },
        bottomBar = {
            BottomNavComponent(
                currentTab = uiState.selectedTab,
                savedCount = uiState.bookmarkedIds.size,
                onTabSelected = { tab ->
                    viewModel.selectTab(tab)
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (uiState.selectedTab) {
                BottomNavTab.HOME -> {
                    HomeScreen(
                        uiState = uiState,
                        onArticleClick = { viewModel.openArticle(it) },
                        onNewspaperClick = { viewModel.exploreNewspaper(it) },
                        onBookmarkToggle = { viewModel.toggleBookmark(it) },
                        onFavoriteNewspaperToggle = { viewModel.toggleFavoriteNewspaper(it) },
                        onCategorySelected = { viewModel.selectCategory(it) },
                        onNavigateTab = { viewModel.selectTab(it) },
                        onSeeAllNewspapers = { viewModel.openSubScreen(SubScreen.ALL_NEWSPAPERS) },
                        onPrevSlide = { viewModel.prevSlide() },
                        onNextSlide = { viewModel.nextSlide() },
                        onSlideDotClick = { viewModel.setActiveSlideIndex(it) }
                    )
                }
                BottomNavTab.CATEGORIES -> {
                    CategoriesScreen(
                        selectedCategory = uiState.selectedCategory,
                        bookmarkedIds = uiState.bookmarkedIds,
                        onCategorySelected = {
                            viewModel.selectCategory(it)
                            viewModel.selectTab(BottomNavTab.HOME)
                        },
                        onArticleClick = { viewModel.openArticle(it) },
                        onBookmarkToggle = { viewModel.toggleBookmark(it) },
                        onSearchClick = { viewModel.openSubScreen(SubScreen.SEARCH) }
                    )
                }
                BottomNavTab.FAVORITES -> {
                    FavoritesScreen(
                        favoriteIds = uiState.favoriteNewspaperIds,
                        onNewspaperClick = { viewModel.exploreNewspaper(it) },
                        onFavoriteToggle = { viewModel.toggleFavoriteNewspaper(it) }
                    )
                }
                BottomNavTab.SAVED -> {
                    SavedNewsScreen(
                        bookmarkedIds = uiState.bookmarkedIds,
                        onArticleClick = { viewModel.openArticle(it) },
                        onBookmarkToggle = { viewModel.toggleBookmark(it) }
                    )
                }
                BottomNavTab.SETTINGS -> {
                    SettingsScreen(
                        uiState = uiState,
                        onFontSizeChange = { viewModel.setFontSize(it) },
                        onToggleNotifications = { viewModel.toggleNotifications() },
                        onToggleDarkMode = { viewModel.toggleDarkMode() },
                        onNavigateToFavorites = { viewModel.selectTab(BottomNavTab.FAVORITES) },
                        onNavigateToSaved = { viewModel.selectTab(BottomNavTab.SAVED) },
                        onShowSplash = { viewModel.openSubScreen(SubScreen.SPLASH) }
                    )
                }
            }
        }
    }

    // Article Details Bottom Sheet Modal (Screen 7)
    uiState.selectedArticle?.let { article ->
        ArticleDetailSheet(
            article = article,
            isBookmarked = uiState.bookmarkedIds.contains(article.id),
            fontSizeSp = uiState.readerFontSizeSp,
            sheetState = articleSheetState,
            onDismiss = { viewModel.openArticle(null) },
            onBookmarkToggle = { viewModel.toggleBookmark(article.id) }
        )
    }

    // Newspaper Profile Details Sheet Modal (Screen 6)
    uiState.selectedNewspaper?.let { newspaper ->
        NewspaperDetailSheet(
            newspaper = newspaper,
            isFavorite = uiState.favoriteNewspaperIds.contains(newspaper.id),
            sheetState = newspaperSheetState,
            onDismiss = { viewModel.openNewspaper(null) },
            onFavoriteToggle = { viewModel.toggleFavoriteNewspaper(newspaper.id) },
            onArticleClick = { viewModel.openArticle(it) },
            onVisitWebsite = {
                viewModel.exploreNewspaper(newspaper)
            }
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    androidx.compose.material3.Text(text = "Hello $name!", modifier = modifier)
}
