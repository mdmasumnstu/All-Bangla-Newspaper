package com.example.ui

import androidx.lifecycle.ViewModel
import com.example.data.NewsRepository
import com.example.model.NewsItem
import com.example.model.Newspaper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class BottomNavTab(val titleBangla: String) {
    HOME("হোম"),
    CATEGORIES("বিভাগ"),
    FAVORITES("পছন্দের"),
    SAVED("সংরক্ষণ"),
    SETTINGS("সেটিংস")
}

enum class SubScreen {
    ALL_NEWSPAPERS,
    SEARCH,
    NOTIFICATIONS,
    SPLASH,
    WEB_EXPLORER
}

data class NewsUiState(
    val selectedTab: BottomNavTab = BottomNavTab.HOME,
    val activeSubScreen: SubScreen? = null,
    val selectedCategory: String = "সকল",
    val bookmarkedIds: Set<String> = setOf("feat_election", "ln_dengue", "ln_worldbank", "ln_shakib"),
    val favoriteNewspaperIds: Set<String> = setOf(
        "np_prothom_alo",
        "np_bd_pratidin",
        "np_samakal",
        "np_jugantor",
        "np_kalbela",
        "np_manabzamin"
    ),
    val searchQuery: String = "",
    val searchFilter: String = "সব",
    val newspaperTab: String = "শীর্ষ পত্রিকা",
    val selectedArticle: NewsItem? = null,
    val selectedNewspaper: Newspaper? = null,
    val exploringNewspaper: Newspaper? = null,
    val notificationEnabled: Boolean = true,
    val isDarkMode: Boolean = false,
    val readerFontSizeSp: Int = 16,
    val activeSlideIndex: Int = 0,
    val feedbackMessage: String? = null
)

class NewsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    fun selectTab(tab: BottomNavTab) {
        _uiState.update { it.copy(selectedTab = tab, activeSubScreen = null) }
    }

    fun openSubScreen(subScreen: SubScreen?) {
        _uiState.update { it.copy(activeSubScreen = subScreen) }
    }

    fun closeSubScreen() {
        _uiState.update { it.copy(activeSubScreen = null) }
    }

    fun selectCategory(categoryName: String) {
        _uiState.update {
            it.copy(selectedCategory = categoryName)
        }
    }

    fun setSearchFilter(filter: String) {
        _uiState.update { it.copy(searchFilter = filter) }
    }

    fun setNewspaperTab(tab: String) {
        _uiState.update { it.copy(newspaperTab = tab) }
    }

    fun setActiveSlideIndex(index: Int) {
        val count = NewsRepository.featuredSlides.size
        val safeIndex = if (index < 0) count - 1 else if (index >= count) 0 else index
        _uiState.update { it.copy(activeSlideIndex = safeIndex) }
    }

    fun nextSlide() {
        _uiState.update {
            val next = (it.activeSlideIndex + 1) % NewsRepository.featuredSlides.size
            it.copy(activeSlideIndex = next)
        }
    }

    fun prevSlide() {
        _uiState.update {
            val count = NewsRepository.featuredSlides.size
            val prev = if (it.activeSlideIndex - 1 < 0) count - 1 else it.activeSlideIndex - 1
            it.copy(activeSlideIndex = prev)
        }
    }

    fun toggleBookmark(newsId: String) {
        _uiState.update { state ->
            val isCurrentlyBookmarked = state.bookmarkedIds.contains(newsId)
            val updated = if (isCurrentlyBookmarked) {
                state.bookmarkedIds - newsId
            } else {
                state.bookmarkedIds + newsId
            }
            val msg = if (isCurrentlyBookmarked) "সংরক্ষণ থেকে সরানো হয়েছে" else "সংবাদটি সংরক্ষণ করা হয়েছে"
            state.copy(bookmarkedIds = updated, feedbackMessage = msg)
        }
    }

    fun toggleFavoriteNewspaper(newspaperId: String) {
        _uiState.update { state ->
            val isFavorite = state.favoriteNewspaperIds.contains(newspaperId)
            val updated = if (isFavorite) {
                state.favoriteNewspaperIds - newspaperId
            } else {
                state.favoriteNewspaperIds + newspaperId
            }
            val msg = if (isFavorite) "পছন্দের তালিকা থেকে সরানো হয়েছে" else "পছন্দের তালিকায় যুক্ত হয়েছে"
            state.copy(favoriteNewspaperIds = updated, feedbackMessage = msg)
        }
    }

    fun setSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun openArticle(item: NewsItem?) {
        _uiState.update { it.copy(selectedArticle = item) }
    }

    fun openNewspaper(newspaper: Newspaper?) {
        _uiState.update { it.copy(selectedNewspaper = newspaper) }
    }

    fun exploreNewspaper(newspaper: Newspaper) {
        _uiState.update {
            it.copy(
                exploringNewspaper = newspaper,
                activeSubScreen = SubScreen.WEB_EXPLORER,
                selectedNewspaper = null
            )
        }
    }

    fun closeWebExplorer() {
        _uiState.update {
            it.copy(
                exploringNewspaper = null,
                activeSubScreen = null
            )
        }
    }

    fun clearFeedback() {
        _uiState.update { it.copy(feedbackMessage = null) }
    }

    fun setFontSize(size: Int) {
        _uiState.update { it.copy(readerFontSizeSp = size.coerceIn(12, 24)) }
    }

    fun toggleNotifications() {
        _uiState.update { it.copy(notificationEnabled = !it.notificationEnabled) }
    }

    fun toggleDarkMode() {
        _uiState.update { it.copy(isDarkMode = !it.isDarkMode) }
    }
}
