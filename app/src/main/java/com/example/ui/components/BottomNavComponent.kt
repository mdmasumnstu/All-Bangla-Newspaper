package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.BottomNavTab
import com.example.ui.theme.BorderLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedContainer
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.TextSlate600

@Composable
fun BottomNavComponent(
    currentTab: BottomNavTab,
    savedCount: Int,
    onTabSelected: (BottomNavTab) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 3.dp, spotColor = Color(0x10000000)),
        color = PureWhite
    ) {
        // Subtle top border matching 'border-t border-gray-100'
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(BorderLight)
            )

            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .testTag("bottom_navigation_bar"),
                containerColor = PureWhite,
                tonalElevation = 0.dp
            ) {
                // 1. 🏠 হোম (Home)
                NavItem(
                    tab = BottomNavTab.HOME,
                    selected = currentTab == BottomNavTab.HOME,
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    label = "হোম",
                    onClick = { onTabSelected(BottomNavTab.HOME) }
                )

                // 2. ⊞ বিভাগ (Categories)
                NavItem(
                    tab = BottomNavTab.CATEGORIES,
                    selected = currentTab == BottomNavTab.CATEGORIES,
                    selectedIcon = Icons.Filled.GridView,
                    unselectedIcon = Icons.Outlined.GridView,
                    label = "বিভাগ",
                    onClick = { onTabSelected(BottomNavTab.CATEGORIES) }
                )

                // 3. ❤️ পছন্দের (Favorites)
                NavItem(
                    tab = BottomNavTab.FAVORITES,
                    selected = currentTab == BottomNavTab.FAVORITES,
                    selectedIcon = Icons.Filled.Favorite,
                    unselectedIcon = Icons.Outlined.FavoriteBorder,
                    label = "পছন্দের",
                    onClick = { onTabSelected(BottomNavTab.FAVORITES) }
                )

                // 4. 🔖 সংরক্ষণ (Saved News)
                NavItem(
                    tab = BottomNavTab.SAVED,
                    selected = currentTab == BottomNavTab.SAVED,
                    selectedIcon = Icons.Filled.Bookmark,
                    unselectedIcon = Icons.Outlined.BookmarkBorder,
                    label = "সংরক্ষণ",
                    badgeCount = savedCount,
                    onClick = { onTabSelected(BottomNavTab.SAVED) }
                )

                // 5. ⚙️ সেটিংস (Settings)
                NavItem(
                    tab = BottomNavTab.SETTINGS,
                    selected = currentTab == BottomNavTab.SETTINGS,
                    selectedIcon = Icons.Filled.Settings,
                    unselectedIcon = Icons.Outlined.Settings,
                    label = "সেটিংস",
                    onClick = { onTabSelected(BottomNavTab.SETTINGS) }
                )
            }
        }
    }
}

@Composable
private fun RowScope.NavItem(
    tab: BottomNavTab,
    selected: Boolean,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    label: String,
    badgeCount: Int = 0,
    onClick: () -> Unit
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            if (badgeCount > 0) {
                BadgedBox(
                    badge = {
                        Badge(
                            containerColor = RedPrimary,
                            contentColor = PureWhite
                        ) {
                            Text(
                                text = if (badgeCount > 99) "99+" else badgeCount.toString(),
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                ) {
                    Icon(
                        imageVector = if (selected) selectedIcon else unselectedIcon,
                        contentDescription = label,
                        modifier = Modifier.size(20.dp)
                    )
                }
            } else {
                Icon(
                    imageVector = if (selected) selectedIcon else unselectedIcon,
                    contentDescription = label,
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 11.sp,
                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium
                ),
                maxLines = 1
            )
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = RedPrimary,
            unselectedIconColor = TextSlate600,
            selectedTextColor = RedPrimary,
            unselectedTextColor = TextSlate600,
            indicatorColor = RedContainer
        ),
        modifier = Modifier.testTag("nav_tab_${tab.name.lowercase()}")
    )
}
