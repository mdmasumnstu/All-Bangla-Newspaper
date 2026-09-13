package com.example.data

import com.example.R
import com.example.model.AppNotification
import com.example.model.NewsCategory
import com.example.model.NewsItem
import com.example.model.Newspaper
import com.example.model.NotificationType

object NewsRepository {

    // Featured Article (Slide 1) matching Screenshot 2 & 7
    val electionFeaturedNews = NewsItem(
        id = "feat_election",
        title = "দ্বাদশ জাতীয় সংসদ নির্বাচন নিয়ে নতুন তফসিল ঘোষণা",
        source = "প্রথম আলো",
        timeAgo = "২ ঘণ্টা আগে",
        category = "রাজনীতি",
        imageRes = R.drawable.img_breaking_news,
        isBreaking = true,
        author = "প্রথম আলো ডেস্ক",
        publishDate = "৫ সেপ্টেম্বর ২০২৬, ১২:৩০ PM",
        summary = "নির্বাচন কমিশন (ইসি) দ্বাদশ জাতীয় সংসদ নির্বাচনের নতুন তফসিল ঘোষণা করেছে। আজ মঙ্গলবার (৫ সেপ্টেম্বর) দুপুরে রাজধানীর আগারগাঁওয়ে নির্বাচন কমিশন ভবনে এক ব্রিফিংয়ে এই তফসিল ঘোষণা করা হয়। প্রধান নির্বাচন কমিশনার জানান, সকল রাজনৈতিক দল ও ভোটারদের সক্রিয় অংশগ্রহণে একটি অবাধ, সুষ্ঠু ও নিরপেক্ষ নির্বাচন আয়োজন করতে কমিশন বদ্ধপরিকর। প্রতিটি কেন্দ্রে সিসিটিভি ক্যামেরা ও প্রয়োজনীয় আইনশৃঙ্খলা বাহিনী মোতায়েন থাকবে।"
    )

    // Carousel slides for Home Screen
    val featuredSlides = listOf(
        electionFeaturedNews,
        NewsItem(
            id = "feat_climate",
            title = "পদ্মা সেতু ও এক্সপ্রেসওয়ের বহুমুখী সুফল: দক্ষিণ জনপদে শিল্পবিপ্লবের হাতছানি",
            source = "বাংলাদেশ প্রতিদিন",
            timeAgo = "৩ ঘণ্টা আগে",
            category = "জাতীয়",
            imageRes = R.drawable.img_news_economy,
            isBreaking = true,
            author = "বিশেষ প্রতিনিধি",
            publishDate = "৫ সেপ্টেম্বর ২০২৬, ১১:০০ AM",
            summary = "যোগাযোগ ব্যবস্থার যুগান্তকারী অগ্রগতির ফলে দক্ষিণ-পশ্চিমাঞ্চলের ২১টি জেলায় কৃষি ও শিল্পখাতে নতুন উদ্যোক্তাদের জোয়ার তৈরি হয়েছে।"
        ),
        NewsItem(
            id = "feat_sports",
            title = "আন্তর্জাতিক ক্রিকেট সিরিজে শক্তিশালী প্রতিপক্ষের বিরুদ্ধে দুর্দান্ত জয় পেল বাংলাদেশ",
            source = "যুগান্তর",
            timeAgo = "৪ ঘণ্টা আগে",
            category = "খেলাধুলা",
            imageRes = R.drawable.img_news_sports,
            isBreaking = true,
            author = "ক্রীড়া প্রতিবেদক",
            publishDate = "৫ সেপ্টেম্বর ২০২৬, ১০:১৫ AM",
            summary = "রুদ্ধশ্বাস ম্যাচে শেষ ওভারে অসাধারণ বোলিং ও ফিল্ডিং নৈপুণ্যে অবিস্মরণীয় জয় তুলে নিল টাইগাররা। ম্যাচসেরা খেলোয়াড়কে বিশেষ সম্মাননা জানানো হয়েছে।"
        )
    )

    // Breaking News Items for Ticker & Live Breaking Alerts
    val breakingNewsList = listOf(
        electionFeaturedNews,
        NewsItem(
            id = "brk_metrorail",
            title = "মেট্রোরেলে যাত্রীদের উপচে পড়া ভিড়: পিক আওয়ারে অতিরিক্ত ৫টি ট্রেন যুক্ত হচ্ছে",
            source = "কালের কণ্ঠ",
            timeAgo = "এইমাত্র",
            category = "জাতীয়",
            imageRes = R.drawable.img_news_metro,
            isBreaking = true,
            isLive = true,
            liveBadgeText = "ব্রেকিং",
            author = "নিজস্ব প্রতিবেদক",
            publishDate = "আজ দুপুর ১:৪৫",
            summary = "যাত্রীচাপ সামলাতে মেট্রোরেল কর্তৃপক্ষ পিক আওয়ারে বিরতি কমিয়ে ৩ মিনিটে নামিয়ে আনার সিদ্ধান্ত গ্রহণ করেছে। আজ থেকেই এই বর্ধিত ট্রিপ কার্যকর হবে।"
        ),
        NewsItem(
            id = "brk_sports_win",
            title = "সিরিজ জয় নিশ্চিত করল টাইগাররা: শেষ ওভারে মোস্তাফিজের বিধ্বংসী বোলিং",
            source = "বিডিনিউজ২৪",
            timeAgo = "৫ মিনিট আগে",
            category = "খেলাধুলা",
            imageRes = R.drawable.img_news_sports,
            isBreaking = true,
            isLive = true,
            liveBadgeText = "লাইভ স্কোর",
            author = "ক্রীড়া ডেস্ক",
            publishDate = "আজ দুপুর ১:৪০",
            summary = "রোমাঞ্চকর লড়াইয়ে ৩ উইকেটে ম্যাচ জিতে তিন ম্যাচের সিরিজে ২-০ ব্যবধানে এগিয়ে গেল বাংলাদেশ ক্রিকেট দল।"
        ),
        NewsItem(
            id = "brk_weather",
            title = "বঙ্গোপসাগরে গভীর নিম্নচাপ: ৩ নম্বর স্থানীয় সতর্ক সংকেত জারি",
            source = "সমকাল",
            timeAgo = "১২ মিনিট আগে",
            category = "আবহাওয়া",
            imageRes = R.drawable.img_breaking_news,
            isBreaking = true,
            isLive = true,
            liveBadgeText = "জরুরি সতর্কতা",
            author = "আবহাওয়া ডেস্ক",
            publishDate = "আজ দুপুর ১:৩২",
            summary = "উত্তর বঙ্গোপসাগর ও সংলগ্ন এলাকায় অবস্থানরত গভীর নিম্নচাপের প্রভাবে দেশের চার সমুদ্র বন্দরে ৩ নম্বর সতর্ক সংকেত দেখাতে বলেছে আবহাওয়া অধিদপ্তর।"
        )
    )

    // Latest News List (সর্বশেষ সংবাদ - রিয়েল-টাইম লাইভ আপডেট)
    val latestNewsList = listOf(
        NewsItem(
            id = "ln_remittance",
            title = "রেকর্ড রেমিট্যান্স: এক মাসেই এলো ২৪০ কোটি মার্কিন ডলার",
            source = "ডেইলি স্টার",
            timeAgo = "২ মিনিট আগে",
            category = "ব্যবসা",
            imageRes = R.drawable.img_news_economy,
            isLive = true,
            liveBadgeText = "রিয়েলটাইম",
            viewsCount = "১৮.৫K",
            author = "অর্থনীতি প্রতিবেদক",
            publishDate = "আজ দুপুর ১:৪২",
            summary = "বাংলাদেশ ব্যাংকের সর্বশেষ পরিসংখ্যান অনুযায়ী ব্যাংকিং চ্যানেলে প্রবাসীদের পাঠানো রেমিট্যান্সের পরিমাণ গত বছরের একই সময়ের চেয়ে ৩৩ শতাংশ বৃদ্ধি পেয়েছে।"
        ),
        NewsItem(
            id = "ln_dengue",
            title = "ডেঙ্গু প্রতিরোধে ঢাকার দুই সিটির বিশেষ ক্র্যাশ কর্মসূচি শুরু",
            source = "সমকাল",
            timeAgo = "৭ মিনিট আগে",
            category = "স্বাস্থ্য",
            imageRes = R.drawable.img_news_metro,
            isLive = true,
            viewsCount = "২৫.১K",
            author = "নিজস্ব প্রতিবেদক",
            publishDate = "আজ দুপুর ১:৩৭",
            summary = "ডেঙ্গু সংক্রমণ নিয়ন্ত্রণে ওয়ার্ডভিত্তিক বিশেষ পরিচ্ছন্নতা অভিযান এবং লার্ভিসাইডিং স্প্রে করার বিশেষ দল মাঠে নামিয়েছে ঢাকা উত্তর ও দক্ষিণ সিটি করপোরেশন।"
        ),
        NewsItem(
            id = "ln_worldbank",
            title = "বাংলাদেশের অর্থনৈতিক প্রবৃদ্ধি আরও গতিশীল হওয়ার আভাস: বিশ্বব্যাংক",
            source = "কালের কণ্ঠ",
            timeAgo = "১৫ মিনিট আগে",
            category = "ব্যবসা",
            imageRes = R.drawable.img_news_economy,
            isLive = false,
            viewsCount = "৩১.২K",
            author = "বাণিজ্য ডেস্ক",
            publishDate = "আজ দুপুর ১:২৯",
            summary = "বিশ্বব্যাংকের সর্বশেষ অর্থনৈতিক পূর্বাভাসে বলা হয়েছে, তৈরি পোশাক খাত ও রেমিট্যান্সের শক্ত ভিত্তির ওপর ভর করে চলতি অর্থবছরে দেশের প্রবৃদ্ধি বাড়বে।"
        ),
        NewsItem(
            id = "ln_campus_admission",
            title = "পাবলিক বিশ্ববিদ্যালয়গুলোতে সমন্বিত ভর্তি পরীক্ষার তারিখ চূড়ান্ত",
            source = "দ্য ডেইলি ক্যাম্পাস",
            timeAgo = "২২ মিনিট আগে",
            category = "শিক্ষা",
            imageRes = R.drawable.img_news_metro,
            isLive = false,
            viewsCount = "৪২.৮K",
            author = "ক্যাম্পাস প্রতিনিধি",
            publishDate = "আজ দুপুর ১:২২",
            summary = "জিএসটি গুচ্ছভুক্ত বিশ্ববিদ্যালয়গুলোর ভর্তি পরীক্ষা আগামী মাসের প্রথম সপ্তাহ থেকে শুরু হবে বলে উপাচার্যদের যৌথ সভায় নীতিগত সিদ্ধান্ত গৃহীত হয়েছে।"
        ),
        NewsItem(
            id = "ln_shakib",
            title = "জাতীয় দলের ক্যাম্প ও আসন্ন টেস্ট সিরিজের স্কোয়াড ঘোষণা কাল",
            source = "যুগান্তর",
            timeAgo = "২৮ মিনিট আগে",
            category = "খেলাধুলা",
            imageRes = R.drawable.img_news_sports,
            isLive = false,
            viewsCount = "৫০.৪K",
            author = "ক্রীড়া প্রতিবেদক",
            publishDate = "আজ দুপুর ১:১৬",
            summary = "মিরপুর শেরেবাংলা জাতীয় স্টেডিয়ামে প্রধান নির্বাচক সংবাদ সম্মেলনের মাধ্যমে ১৬ সদস্যের মূল টেস্ট দল ঘোষণা করবেন।"
        ),
        NewsItem(
            id = "ln_election_bdnews",
            title = "নির্বাচনী প্রক্রিয়ায় স্বচ্ছতা নিশ্চিতে ইভিএম ও প্রযুক্তির আধুনিকায়ন",
            source = "bdnews24",
            timeAgo = "৪০ মিনিট আগে",
            category = "রাজনীতি",
            imageRes = R.drawable.img_breaking_news,
            isLive = false,
            viewsCount = "২২.৭K",
            author = "রাজনীতি ডেস্ক",
            publishDate = "আজ দুপুর ১:০৪",
            summary = "ভোটগ্রহণে সর্বোচ্চ স্বচ্ছতা বজায় রাখতে সিসিটিভি ক্যামেরার লাইভ মনিটরিং এবং আইনশৃঙ্খলা বাহিনীর বডি ওর্ন ক্যামেরার সংখ্যা বাড়ানো হচ্ছে।"
        ),
        NewsItem(
            id = "ln_ict_fellowship",
            title = "আইটি ও এআই স্টার্টআপের জন্য ১০০ কোটি টাকার নতুন ফান্ড",
            source = "বাংলা ট্রিবিউন",
            timeAgo = "৫২ মিনিট আগে",
            category = "প্রযুক্তি",
            imageRes = R.drawable.img_news_economy,
            isLive = false,
            viewsCount = "১৯.৩K",
            author = "প্রযুক্তি প্রতিবেদক",
            publishDate = "আজ দুপুর ১২:৫২",
            summary = "তথ্যপ্রযুক্তি বিভাগের সহায়তায় দেশের তরুণ উদ্ভাবক ও স্টার্টআপদের জন্য সহজ শর্তে সিড ফান্ডিং দেওয়ার নতুন কর্মসূচি চালু হলো।"
        ),
        NewsItem(
            id = "ln_padma_agri",
            title = "পদ্মা সেতুর সুফল: রাজধানীতে তাজা শাকসবজি ও ফল পৌঁছাচ্ছে দ্রুত",
            source = "ইত্তেফাক",
            timeAgo = "১ ঘণ্টা আগে",
            category = "কৃষি",
            imageRes = R.drawable.img_news_metro,
            isLive = false,
            viewsCount = "১৬.৮K",
            author = "কৃষি সংবাদকর্মী",
            publishDate = "আজ দুপুর ১২:৪৫",
            summary = "পরিবহন সময় কমে যাওয়ায় দক্ষিণবঙ্গের কৃষকেরা পণ্যের ন্যায্য মূল্য পাচ্ছেন এবং রাজধানীর বাজারে সরবরাহ স্থিতিশীল থাকছে।"
        )
    )

    // Popular News List (জনপ্রিয় সংবাদ - সর্বাধিক পঠিত ও ট্রেন্ডিং)
    val popularNewsList = listOf(
        NewsItem(
            id = "pn_1",
            rank = "01",
            title = "পদ্মা সেতু ও আধুনিক এক্সপ্রেসওয়ের বহুমুখী সুফল: পাল্টে গেছে দক্ষিণাঞ্চলের অর্থনীতি",
            source = "যুগান্তর",
            timeAgo = "আজকের শীর্ষ",
            category = "জাতীয়",
            imageRes = R.drawable.img_news_economy,
            viewsCount = "৮৮.২K পঠিত",
            isBreaking = true,
            summary = "যোগাযোগ ব্যবস্থার যুগান্তকারী অগ্রগতির ফলে দক্ষিণ-পশ্চিমাঞ্চলের ২১টি জেলায় কৃষি ও শিল্পখাতে নতুন উদ্যোক্তাদের জোয়ার তৈরি হয়েছে।"
        ),
        NewsItem(
            id = "pn_2",
            rank = "02",
            title = "দ্বাদশ জাতীয় সংসদ নির্বাচন নিয়ে নতুন তফসিল ঘোষণা: গুরুত্বপূর্ণ নির্দেশনা জারি",
            source = "প্রথম আলো",
            timeAgo = "২ ঘণ্টা আগে",
            category = "রাজনীতি",
            imageRes = R.drawable.img_breaking_news,
            viewsCount = "৭২.৫K পঠিত",
            summary = "নির্বাচন কমিশন আজ নতুন তফসিল ঘোষণা করেছে। সকল দলের অংশগ্রহণ নিশ্চিত করতে বিশেষ উদ্যোগ ও মনিটরিং সেল গঠন করা হয়েছে।"
        ),
        NewsItem(
            id = "pn_3",
            rank = "03",
            title = "সিরিজ জয়ের উল্লাসে টাইগাররা: শেষ ওভারের রুদ্ধশ্বাস নাটকীয়তা",
            source = "বিডিনিউজ২৪",
            timeAgo = "১ ঘণ্টা আগে",
            category = "খেলাধুলা",
            imageRes = R.drawable.img_news_sports,
            viewsCount = "৬১.৯K পঠিত",
            summary = "রুদ্ধশ্বাস ম্যাচে অসাধারণ বোলিং ও ফিল্ডিং নৈপুণ্যে অবিস্মরণীয় জয় তুলে নিল বাংলাদেশ দল। সামাজিক যোগাযোগ মাধ্যমে অভিনন্দনের বন্যা।"
        ),
        NewsItem(
            id = "pn_4",
            rank = "04",
            title = "এক মাসে রেকর্ড ২৪০ কোটি ডলার রেমিট্যান্স: ব্যাংকে বেড়েছে ডলারের সরবরাহ",
            source = "কালের কণ্ঠ",
            timeAgo = "৩ ঘণ্টা আগে",
            category = "ব্যবসা",
            imageRes = R.drawable.img_news_economy,
            viewsCount = "৫৩.৪K পঠিত",
            summary = "প্রবাসী আয়ের উর্ধ্বগতি ও রপ্তানি আয়ের কারণে বৈদেশিক মুদ্রার রিজার্ভে ইতিবাচক প্রভাব পড়তে শুরু করেছে।"
        ),
        NewsItem(
            id = "pn_5",
            rank = "05",
            title = "মেট্রোরেলে যাত্রীদের উপচে পড়া ভিড়: পিক আওয়ারে অতিরিক্ত ট্রেনের ঘোষণা",
            source = "সমকাল",
            timeAgo = "৪ ঘণ্টা আগে",
            category = "জাতীয়",
            imageRes = R.drawable.img_news_metro,
            viewsCount = "৪১.৭K পঠিত",
            summary = "অফিসগামীদের সুবিধার্থে মতিঝিল থেকে উত্তরা রুটে ট্রেনের ব্যবধান কমিয়ে আনার সিদ্ধান্ত নিয়েছে ডিএমটিসিএল।"
        )
    )

    // Screen 4 & Screen 8: Newspapers List (120 Newspapers & Portals across 10 Categories)
    val newspapersList: List<Newspaper> get() = NewspaperCatalog.allNewspapers
    val topNewspapers: List<Newspaper> get() = NewspaperCatalog.topNewspapers

    // Screen 3: Exact 14 Categories with high-fidelity styling matching Image 3
    val categories = listOf(
        NewsCategory("cat_bd", "বাংলাদেশ", "flag", 0xFF2E7D32),
        NewsCategory("cat_intl", "আন্তর্জাতিক", "globe", 0xFF1976D2),
        NewsCategory("cat_politics", "রাজনীতি", "account_balance", 0xFF00796B),
        NewsCategory("cat_biz", "ব্যবসা", "bar_chart", 0xFF43A047),
        NewsCategory("cat_sports", "খেলাধুলা", "sports_soccer", 0xFFE53935),
        NewsCategory("cat_edu", "শিক্ষা", "school", 0xFF1E88E5),
        NewsCategory("cat_ent", "বিনোদন", "movie", 0xFFD81B60),
        NewsCategory("cat_tech", "প্রযুক্তি", "memory", 0xFF0288D1),
        NewsCategory("cat_health", "স্বাস্থ্য", "favorite", 0xFFE53935),
        NewsCategory("cat_lifestyle", "লাইফস্টাইল", "local_florist", 0xFF43A047),
        NewsCategory("cat_jobs", "চাকরি", "work", 0xFF5E35B1),
        NewsCategory("cat_religion", "ধর্ম", "mosque", 0xFFF57C00),
        NewsCategory("cat_travel", "ভ্রমণ", "flight", 0xFF039BE5),
        NewsCategory("cat_agriculture", "কৃষি", "agriculture", 0xFF388E3C)
    )

    // Screen 10: Notifications List matching Image 10
    val notificationsList = listOf(
        AppNotification(
            id = "notif_1",
            category = "Breaking News",
            title = "নির্বাচন কমিশন নতুন তফসিল ঘোষণা করেছে",
            time = "আজ ৪:৩০ PM",
            type = NotificationType.BREAKING
        ),
        AppNotification(
            id = "notif_2",
            category = "আন্তর্জাতিক খবর",
            title = "জাতিসংঘে বাংলাদেশের নতুন প্রস্তাব",
            time = "আজ ২:১৫ PM",
            type = NotificationType.INTERNATIONAL
        ),
        AppNotification(
            id = "notif_3",
            category = "খেলাধুলা",
            title = "বাংলাদেশ জিতেছে সিরিজের প্রথম ম্যাচ",
            time = "আজ ৩:২০ PM",
            type = NotificationType.SPORTS
        ),
        AppNotification(
            id = "notif_4",
            category = "ব্যবসা",
            title = "শেয়ারবাজারে বড় উত্থান",
            time = "আজ ৩:১০ PM",
            type = NotificationType.BUSINESS
        ),
        AppNotification(
            id = "notif_5",
            category = "শিক্ষা",
            title = "বিশ্ববিদ্যালয় ভর্তি পরীক্ষা নিয়ে নতুন সিদ্ধান্ত",
            time = "আজ ১:৪৫ PM",
            type = NotificationType.EDUCATION
        )
    )
}
