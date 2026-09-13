package com.example.model

import androidx.annotation.DrawableRes

data class NewsItem(
    val id: String,
    val title: String,
    val source: String,
    val timeAgo: String,
    val category: String,
    @DrawableRes val imageRes: Int,
    val isBreaking: Boolean = false,
    val isBookmarked: Boolean = false,
    val rank: String? = null,
    val summary: String = "",
    val readTime: String = "৩ মিনিট পড়া",
    val author: String = "ডেস্ক রিপোর্ট",
    val publishDate: String = "৫ সেপ্টেম্বর ২০২৬, ১২:৩০ PM",
    val viewsCount: String? = null,
    val isLive: Boolean = false,
    val liveBadgeText: String? = null
)

data class Newspaper(
    val id: String,
    val nameBangla: String,
    val nameEnglish: String,
    val tagLine: String = "",
    val primaryColorHex: Long = 0xFFE53935,
    val logoText: String = "",
    val category: String = "বাংলা পত্রিকা",
    val isFavorite: Boolean = false,
    val websiteUrl: String = "",
    val articlesCount: String = "",
    val establishedYear: String = "",
    val newspaperType: String = "দৈনিক",
    val description: String = "",
    val logoUrl: String? = null,
    @DrawableRes val logoResId: Int? = null,
    val epaperUrl: String? = null,
    val language: String = "বাংলা",
    val country: String = "বাংলাদেশ",
    val isPopular: Boolean = false
) {
    /**
     * Extracts a clean, human-readable domain name without protocol or www prefix.
     * Example: "https://www.prothomalo.com/bangladesh" -> "prothomalo.com"
     */
    val cleanDomain: String
        get() = websiteUrl
            .removePrefix("https://")
            .removePrefix("http://")
            .removePrefix("www.")
            .substringBefore("/")
            .substringBefore("?")

    /**
     * Concise badge or monogram string for logos and circular avatar badges.
     */
    val displayLogo: String
        get() = if (logoText.isNotBlank()) logoText.take(4) else nameBangla.take(2)

    /**
     * Performs a multi-field search check against query string.
     */
    fun matchesQuery(query: String): Boolean {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return true
        return nameBangla.lowercase().contains(q) ||
                nameEnglish.lowercase().contains(q) ||
                tagLine.lowercase().contains(q) ||
                category.lowercase().contains(q) ||
                newspaperType.lowercase().contains(q) ||
                cleanDomain.lowercase().contains(q)
    }
}

/**
 * Robust Category model representing both news topic categories and newspaper classifications.
 */
data class Category(
    val id: String,
    val nameBangla: String,
    val iconName: String = "newspaper",
    val iconColorHex: Long = 0xFF1E88E5,
    val nameEnglish: String = "",
    val description: String = "",
    val newspaperCount: Int = 0,
    val isPopular: Boolean = false
) {
    fun matches(query: String): Boolean {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return true
        return nameBangla.lowercase().contains(q) ||
                nameEnglish.lowercase().contains(q) ||
                id.lowercase().contains(q)
    }
}

/**
 * Typealias for backwards compatibility across existing components.
 */
typealias NewsCategory = Category

enum class NotificationType {
    BREAKING, INTERNATIONAL, SPORTS, BUSINESS, EDUCATION
}

data class AppNotification(
    val id: String,
    val category: String,
    val title: String,
    val time: String,
    val type: NotificationType
)

