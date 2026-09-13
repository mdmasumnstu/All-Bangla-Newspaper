package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.NewsCategory
import com.example.ui.theme.BorderLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.SubtleGray
import com.example.ui.theme.TextSlate600
import com.example.ui.theme.TextSlate800

@Composable
fun CategoriesRowComponent(
    categories: List<NewsCategory>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Exact categories matching Screen 2: "সর্বশেষ", "বাংলাদেশ", "রাজনীতি", "আন্তর্জাতিক", "ব্যবসা", "খেলাধুলা", etc.
    val categoryNames = listOf("সর্বশেষ", "বাংলাদেশ", "রাজনীতি", "আন্তর্জাতিক", "ব্যবসা", "খেলাধুলা", "বিনোদন", "প্রযুক্তি")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("categories_horizontal_row")
        ) {
            items(categoryNames) { catName ->
                val isSelected = catName == selectedCategory || (catName == "সর্বশেষ" && selectedCategory == "সকল")
                CategoryPillChip(
                    title = catName,
                    isSelected = isSelected,
                    onClick = {
                        if (catName == "সর্বশেষ") {
                            onCategorySelected("সকল")
                        } else {
                            onCategorySelected(catName)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryPillChip(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) RedPrimary else SubtleGray)
            .border(
                width = 1.dp,
                color = if (isSelected) RedPrimary else BorderLight,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 14.dp, vertical = 7.dp)
            .testTag("category_pill_$title"),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            fontSize = 12.5.sp,
            color = if (isSelected) PureWhite else TextSlate800
        )
    }
}
