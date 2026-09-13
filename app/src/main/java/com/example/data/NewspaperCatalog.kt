package com.example.data

import com.example.model.Category
import com.example.model.Newspaper

object NewspaperCatalog {

    const val CAT_TOP = "শীর্ষ পত্রিকা"
    const val CAT_BANGLA_PAPER = "বাংলা পত্রিকা"
    const val CAT_ONLINE = "অনলাইন পোর্টাল"
    const val CAT_BUSINESS = "ব্যবসা-বাণিজ্য"
    const val CAT_SPORTS = "খেলাধুলা"
    const val CAT_EDUCATION = "শিক্ষা"
    const val CAT_ENGLISH = "ইংরেজি পত্রিকা"
    const val CAT_AGENCY = "সংবাদ সংস্থা"
    const val CAT_INTERNATIONAL = "আন্তর্জাতিক বাংলা"
    const val CAT_MORE_ONLINE = "অন্যান্য পোর্টাল"

    /**
     * Centralized list of Category objects with robust metadata, icons, color codes,
     * descriptions, and newspaper counts for navigation.
     */
    val categories: List<Category> = listOf(
        Category(
            id = "cat_all",
            nameBangla = "সকল",
            nameEnglish = "All",
            iconName = "dashboard",
            iconColorHex = 0xFFD32F2F,
            description = "সকল ১২০+ পত্রিকা ও অনলাইন পোর্টাল",
            newspaperCount = 120
        ),
        Category(
            id = "cat_top",
            nameBangla = CAT_TOP,
            nameEnglish = "Top Newspapers",
            iconName = "star",
            iconColorHex = 0xFFE53935,
            description = "বাংলাদেশের শীর্ষ স্থানীয় জাতীয় সংবাদপত্র",
            newspaperCount = 6,
            isPopular = true
        ),
        Category(
            id = "cat_bangla",
            nameBangla = CAT_BANGLA_PAPER,
            nameEnglish = "Bangla Dailies",
            iconName = "menu_book",
            iconColorHex = 0xFFC2185B,
            description = "জাতীয় ও প্রিন্ট বাংলা দৈনিক পত্রিকা",
            newspaperCount = 19,
            isPopular = true
        ),
        Category(
            id = "cat_online",
            nameBangla = CAT_ONLINE,
            nameEnglish = "Online Portals",
            iconName = "language",
            iconColorHex = 0xFF1976D2,
            description = "২৪/৭ ডিজিটাল ও অনলাইন নিউজ পোর্টাল",
            newspaperCount = 15,
            isPopular = true
        ),
        Category(
            id = "cat_business",
            nameBangla = CAT_BUSINESS,
            nameEnglish = "Business & Economy",
            iconName = "trending_up",
            iconColorHex = 0xFFFB8C00,
            description = "শেয়ারবাজার, ব্যাংক ও অর্থনৈতিক খবর",
            newspaperCount = 12
        ),
        Category(
            id = "cat_sports",
            nameBangla = CAT_SPORTS,
            nameEnglish = "Sports Media",
            iconName = "sports_cricket",
            iconColorHex = 0xFF2E7D32,
            description = "ক্রিকেট, ফুটবল ও লাইভ স্পোর্টস স্কোর",
            newspaperCount = 5
        ),
        Category(
            id = "cat_education",
            nameBangla = CAT_EDUCATION,
            nameEnglish = "Education & Campus",
            iconName = "school",
            iconColorHex = 0xFF1E88E5,
            description = "বিশ্ববিদ্যালয় ভর্তি ও শিক্ষা মন্ত্রণালয় সংবাদ",
            newspaperCount = 3
        ),
        Category(
            id = "cat_english",
            nameBangla = CAT_ENGLISH,
            nameEnglish = "English Newspapers",
            iconName = "article",
            iconColorHex = 0xFF5E35B1,
            description = "Leading Bangladeshi English daily newspapers",
            newspaperCount = 12
        ),
        Category(
            id = "cat_agency",
            nameBangla = CAT_AGENCY,
            nameEnglish = "News Agencies",
            iconName = "podcasts",
            iconColorHex = 0xFF00796B,
            description = "জাতীয় ও আন্তর্জাতিক সংবাদ সংস্থা (BSS, UNB, ENA)",
            newspaperCount = 3
        ),
        Category(
            id = "cat_international",
            nameBangla = CAT_INTERNATIONAL,
            nameEnglish = "International Bangla",
            iconName = "public",
            iconColorHex = 0xFF0288D1,
            description = "আন্তর্জাতিক সম্প্রচার মাধ্যমের বাংলা সেবা",
            newspaperCount = 5
        ),
        Category(
            id = "cat_more_online",
            nameBangla = CAT_MORE_ONLINE,
            nameEnglish = "More News Portals",
            iconName = "explore",
            iconColorHex = 0xFF4527A0,
            description = "দেশের জনপ্রিয় অনলাইন সংবাদ মাধ্যমসমূহ",
            newspaperCount = 40
        )
    )

    val categoriesList: List<String> = categories.map { it.nameBangla }

    // 1. Top Bangladesh Newspapers
    val topNewspapers = listOf(
        Newspaper(
            id = "np_prothom_alo",
            nameBangla = "প্রথম আলো",
            nameEnglish = "Prothom Alo",
            tagLine = "যা কিছু ভালো তার সাথে প্রথম আলো",
            primaryColorHex = 0xFFE53935,
            logoText = "প্রথম আলো",
            category = CAT_TOP,
            isFavorite = true,
            websiteUrl = "https://www.prothomalo.com",
            articlesCount = "1.2M+",
            establishedYear = "১৯৯৮",
            newspaperType = "দৈনিক",
            description = "বাংলাদেশের অন্যতম বৃহৎ ও জনপ্রিয় দৈনিক পত্রিকা।"
        ),
        Newspaper(
            id = "np_ittefaq",
            nameBangla = "ইত্তেফাক",
            nameEnglish = "Ittefaq",
            tagLine = "ঐতিহ্য ও সত্যের প্রতীক",
            primaryColorHex = 0xFF1E88E5,
            logoText = "ইত্তেফাক",
            category = CAT_TOP,
            isFavorite = false,
            websiteUrl = "https://www.ittefaq.com.bd",
            articlesCount = "850K+",
            establishedYear = "১৯৫৩",
            newspaperType = "দৈনিক",
            description = "বাংলাদেশের অন্যতম প্রাচীন ও ঐতিহ্যবাহী জাতীয় দৈনিক পত্রিকা।"
        ),
        Newspaper(
            id = "np_kaler_kantho",
            nameBangla = "কালের কণ্ঠ",
            nameEnglish = "Kaler Kantho",
            tagLine = "সত্যের সঙ্গে সন্ধিহীন",
            primaryColorHex = 0xFFD81B60,
            logoText = "কালের কণ্ঠ",
            category = CAT_TOP,
            isFavorite = false,
            websiteUrl = "https://www.kalerkantho.com",
            articlesCount = "720K+",
            establishedYear = "২০১০",
            newspaperType = "দৈনিক",
            description = "বসুন্ধরা গ্রুপ কর্তৃক প্রকাশিত অন্যতম শীর্ষস্থানীয় জাতীয় দৈনিক।"
        ),
        Newspaper(
            id = "np_bd_pratidin",
            nameBangla = "বাংলাদেশ প্রতিদিন",
            nameEnglish = "Bangladesh Pratidin",
            tagLine = "আমরা জনগণের কথা বলি",
            primaryColorHex = 0xFF2E7D32,
            logoText = "বাংলাদেশ প্রতিদিন",
            category = CAT_TOP,
            isFavorite = true,
            websiteUrl = "https://www.bd-pratidin.com",
            articlesCount = "980K+",
            establishedYear = "২০১০",
            newspaperType = "দৈনিক",
            description = "সর্বাধিক প্রচারিত ও জনপ্রিয় বাংলা জাতীয় সংবাদপত্র।"
        ),
        Newspaper(
            id = "np_samakal",
            nameBangla = "সমকাল",
            nameEnglish = "Samakal",
            tagLine = "মুক্তির চেতনায় নির্ভীক",
            primaryColorHex = 0xFFF57C00,
            logoText = "সমকাল",
            category = CAT_TOP,
            isFavorite = true,
            websiteUrl = "https://www.samakal.com",
            articlesCount = "650K+",
            establishedYear = "২০০৫",
            newspaperType = "দৈনিক",
            description = "বস্তুনিষ্ঠ ও প্রগতিশীল চিন্তার বিশিষ্ট জাতীয় দৈনিক।"
        ),
        Newspaper(
            id = "np_jugantor",
            nameBangla = "যুগান্তর",
            nameEnglish = "Jugantor",
            tagLine = "সত্যের সন্ধানে নির্ভীক",
            primaryColorHex = 0xFF8E24AA,
            logoText = "যুগান্তর",
            category = CAT_TOP,
            isFavorite = true,
            websiteUrl = "https://www.jugantor.com",
            articlesCount = "800K+",
            establishedYear = "২০০০",
            newspaperType = "দৈনিক",
            description = "যমুনা গ্রুপ কর্তৃক প্রকাশিত অন্যতম প্রভাবশালী জাতীয় দৈনিক।"
        )
    )

    // 2. All Bangla Newspapers
    val banglaNewspapers = listOf(
        Newspaper(
            id = "np_kalbela",
            nameBangla = "কালবেলা",
            nameEnglish = "Kalbela",
            tagLine = "নতুন দিনের দৈনিক",
            primaryColorHex = 0xFFC2185B,
            logoText = "কালবেলা",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.kalbela.com",
            articlesCount = "400K+",
            establishedYear = "২০২২",
            description = "আধুনিক ও ডিজিটাল সাংবাদিকতায় অগ্রগামী জাতীয় দৈনিক।"
        ),
        Newspaper(
            id = "np_manabzamin",
            nameBangla = "মানবজমিন",
            nameEnglish = "Manab Zamin",
            tagLine = "প্রথম ট্যাবলয়েড দৈনিক",
            primaryColorHex = 0xFFE64A19,
            logoText = "মানবজমিন",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.mzamin.com",
            articlesCount = "520K+",
            establishedYear = "১৯৯৭",
            newspaperType = "ট্যাবলয়েড",
            description = "বাংলাদেশের প্রথম রঙিন ট্যাবলয়েড দৈনিক সংবাদপত্র।"
        ),
        Newspaper(
            id = "np_jaijaidin",
            nameBangla = "যায়যায়দিন",
            nameEnglish = "Jai Jai Din",
            tagLine = "জনপ্রিয় দৈনিক পত্রিকা",
            primaryColorHex = 0xFF00897B,
            logoText = "যায়যায়দিন",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.jaijaidinbd.com",
            articlesCount = "380K+",
            establishedYear = "১৯৮৪",
            description = "শফিক রেহমান প্রবর্তিত সুপরিচিত প্রগতিশীল দৈনিক।"
        ),
        Newspaper(
            id = "np_amader_shomoy",
            nameBangla = "আমাদের সময়",
            nameEnglish = "Amader Shomoy",
            tagLine = "জনগণের বিশ্বস্ত দৈনিক",
            primaryColorHex = 0xFF00ACC1,
            logoText = "আমাদের সময়",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.dainikamadershomoy.com",
            articlesCount = "450K+",
            establishedYear = "২০০৩",
            description = "সহজবোধ্য ভাষায় জনপ্রিয় ও বহুল পঠিত বাংলা দৈনিক।"
        ),
        Newspaper(
            id = "np_janakantha",
            nameBangla = "জনকণ্ঠ",
            nameEnglish = "Janakantha",
            tagLine = "নির্ভীক সংবাদের রূপকার",
            primaryColorHex = 0xFFD32F2F,
            logoText = "জনকণ্ঠ",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.dailyjanakantha.com",
            articlesCount = "500K+",
            establishedYear = "১৯৯৩",
            description = "জনকণ্ঠ গ্রুপ কর্তৃক প্রকাশিত প্রাচীন বাংলা দৈনিক।"
        ),
        Newspaper(
            id = "np_sangbad",
            nameBangla = "সংবাদ",
            nameEnglish = "Sangbad",
            tagLine = "ঐতিহ্যবাহী বাংলা দৈনিক",
            primaryColorHex = 0xFF3949AB,
            logoText = "সংবাদ",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.sangbad.net.bd",
            articlesCount = "350K+",
            establishedYear = "১৯৫১",
            description = "বাংলাদেশের ভাষা আন্দোলন ও মুক্তিযুদ্ধের স্মৃতিবিজড়িত ঐতিহাসিক পত্রিকা।"
        ),
        Newspaper(
            id = "np_inqilab",
            nameBangla = "ইনকিলাব",
            nameEnglish = "Inqilab",
            tagLine = "বস্তুনিষ্ঠ সংবাদের ধারক",
            primaryColorHex = 0xFF1B5E20,
            logoText = "ইনকিলাব",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.dailyinqilab.com",
            articlesCount = "420K+",
            establishedYear = "১৯৮৬",
            description = "ইসলামিক ও জাতীয় মূল্যবোধের সুপরিচিত বাংলা দৈনিক।"
        ),
        Newspaper(
            id = "np_ajkaler_khobor",
            nameBangla = "আজকালের খবর",
            nameEnglish = "Ajkaler Khobor",
            tagLine = "সময়ের সাথে প্রতিদিন",
            primaryColorHex = 0xFF00838F,
            logoText = "আজকালের খবর",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.ajkalerkhobor.com",
            articlesCount = "220K+",
            establishedYear = "২০১৫",
            description = "জনপ্রিয় জাতীয় বাংলা দৈনিক পত্রিকা।"
        ),
        Newspaper(
            id = "np_ajker_patrika",
            nameBangla = "আজকের পত্রিকা",
            nameEnglish = "Ajker Patrika",
            tagLine = "বিশ্বস্ত সংবাদ প্রতিদিন",
            primaryColorHex = 0xFF009688,
            logoText = "আজকের পত্রিকা",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.ajkerpatrika.com",
            articlesCount = "300K+",
            establishedYear = "২০২১",
            description = "ইউএস-বাংলা গ্রুপের প্রকাশনা আধুনিক জাতীয় দৈনিক।"
        ),
        Newspaper(
            id = "np_protidiner_sangbad",
            nameBangla = "প্রতিদিনের সংবাদ",
            nameEnglish = "Protidiner Sangbad",
            tagLine = "সত্যের পথে অবিচল",
            primaryColorHex = 0xFFE91E63,
            logoText = "প্রতিদিনের সংবাদ",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.protidinersangbad.com",
            articlesCount = "250K+",
            establishedYear = "২০১২",
            description = "দেশের শীর্ষস্থানীয় জাতীয় দৈনিক সংবাদপত্র।"
        ),
        Newspaper(
            id = "np_bangladesher_khabor",
            nameBangla = "বাংলাদেশের খবর",
            nameEnglish = "Bangladesher Khabor",
            tagLine = "সবার আগে সঠিক খবর",
            primaryColorHex = 0xFF5D4037,
            logoText = "বাংলাদেশের খবর",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.bangladesherkhabor.net",
            articlesCount = "210K+",
            establishedYear = "২০১৬",
            description = "জাতীয় ও আন্তর্জাতিক সংবাদ নির্ভর দৈনিক।"
        ),
        Newspaper(
            id = "np_protidiner_bangladesh",
            nameBangla = "প্রতিদিনের বাংলাদেশ",
            nameEnglish = "Protidiner Bangladesh",
            tagLine = "রংপুর থেকে টেকনাফ সব খবর",
            primaryColorHex = 0xFFC62828,
            logoText = "প্রতিদিনের বাংলাদেশ",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.protidinerbangladesh.com",
            articlesCount = "310K+",
            establishedYear = "২০২২",
            description = "রংধনু গ্রুপের জাতীয় বাংলা দৈনিক।"
        ),
        Newspaper(
            id = "np_amar_desh",
            nameBangla = "আমার দেশ",
            nameEnglish = "Amar Desh",
            tagLine = "জনগণের স্বাধীন কণ্ঠস্বর",
            primaryColorHex = 0xFF1565C0,
            logoText = "আমার দেশ",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.dailyamardesh.com",
            articlesCount = "450K+",
            establishedYear = "২০০৪",
            description = "জনপ্রিয় ও প্রভাবশালী বাংলা দৈনিক।"
        ),
        Newspaper(
            id = "np_bd_journal",
            nameBangla = "বাংলাদেশ জার্নাল",
            nameEnglish = "Bangladesh Journal",
            tagLine = "সবার জন্য সত্য সংবাদ",
            primaryColorHex = 0xFF6A1B9A,
            logoText = "বাংলাদেশ জার্নাল",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.bd-journal.com",
            articlesCount = "280K+",
            establishedYear = "২০১৬",
            description = "জনপ্রিয় অনলাইন ও প্রিন্ট জাতীয় দৈনিক।"
        ),
        Newspaper(
            id = "np_amar_sangbad",
            nameBangla = "আমার সংবাদ",
            nameEnglish = "Amar Sangbad",
            tagLine = "দেশের কথা বলে",
            primaryColorHex = 0xFF4E342E,
            logoText = "আমার সংবাদ",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.amarsangbad.com",
            articlesCount = "240K+",
            establishedYear = "২০১৩",
            description = "জাতীয় গুরুত্বপূর্ণ খবরের নির্ভরযোগ্য দৈনিক।"
        ),
        Newspaper(
            id = "np_vorer_pata",
            nameBangla = "ভোরের পাতা",
            nameEnglish = "Vorer Pata",
            tagLine = "উন্নয়ন ও প্রগতির প্রতীক",
            primaryColorHex = 0xFF2E7D32,
            logoText = "ভোরের পাতা",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.bhorerpata.com",
            articlesCount = "220K+",
            establishedYear = "১৯৯৬",
            description = "ভোরের পাতা মিডিয়া গ্রুপ কর্তৃক প্রকাশিত জাতীয় দৈনিক।"
        ),
        Newspaper(
            id = "np_sangram",
            nameBangla = "দৈনিক সংগ্রাম",
            nameEnglish = "Sangram",
            tagLine = "সত্যের জয়গান",
            primaryColorHex = 0xFF37474F,
            logoText = "সংগ্রাম",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.dailysangram.com",
            articlesCount = "320K+",
            establishedYear = "১৯৭০",
            description = "দীর্ঘ ইতিহাসবাহী ঐতিহ্যবাহী বাংলা দৈনিক।"
        ),
        Newspaper(
            id = "np_desh_rupantor",
            nameBangla = "দেশ রূপান্তর",
            nameEnglish = "Desh Rupantor",
            tagLine = "দায়িত্বশীলদের দৈনিক",
            primaryColorHex = 0xFFBF360C,
            logoText = "দেশ রূপান্তর",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.deshrupantor.com",
            articlesCount = "390K+",
            establishedYear = "২০১৮",
            description = "রূপায়ণ গ্রুপ কর্তৃক প্রকাশিত জনপ্রিয় আধুনিক দৈনিক।"
        ),
        Newspaper(
            id = "np_manobkantha",
            nameBangla = "মানবকণ্ঠ",
            nameEnglish = "Manobkantha",
            tagLine = "মানুষের কথা বলে",
            primaryColorHex = 0xFF00695C,
            logoText = "মানবকণ্ঠ",
            category = CAT_BANGLA_PAPER,
            websiteUrl = "https://www.manobkantha.com.bd",
            articlesCount = "290K+",
            establishedYear = "২০১২",
            description = "মানবাধিকার ও উন্নয়ন বিষয়ক জাতীয় দৈনিক।"
        )
    )

    // 3. Top Bangla News Sites
    val topNewsSites = listOf(
        Newspaper(
            id = "np_bdnews24",
            nameBangla = "বিডিনিউজ২৪",
            nameEnglish = "bdnews24",
            tagLine = "প্রথম ২৪/৭ ইন্টারনেট সংবাদপত্র",
            primaryColorHex = 0xFFD32F2F,
            logoText = "bdnews24",
            category = CAT_ONLINE,
            websiteUrl = "https://bangla.bdnews24.com",
            articlesCount = "1.5M+",
            establishedYear = "২০০৫",
            newspaperType = "অনলাইন পোর্টাল",
            description = "বাংলাদেশের প্রথম ও বৃহত্তম অনলাইন সংবাদ মাধ্যম।"
        ),
        Newspaper(
            id = "np_banglanews24",
            nameBangla = "বাংলানিউজ২৪",
            nameEnglish = "Banglanews24",
            tagLine = "সর্বদা সত্যের সঙ্গে",
            primaryColorHex = 0xFFE65100,
            logoText = "বাংলানিউজ",
            category = CAT_ONLINE,
            websiteUrl = "https://www.banglanews24.com",
            articlesCount = "1.2M+",
            establishedYear = "২০১০",
            newspaperType = "অনলাইন পোর্টাল",
            description = "বসুন্ধরা গ্রুপ পরিচালিত অন্যতম শীর্ষ অনলাইন নিউজ পোর্টাল।"
        ),
        Newspaper(
            id = "np_bd24live",
            nameBangla = "বিডি২৪লাইভ",
            nameEnglish = "BD24Live",
            tagLine = "খবর ২৪ ঘণ্টা লাইভ",
            primaryColorHex = 0xFF0091EA,
            logoText = "বিডি২৪",
            category = CAT_ONLINE,
            websiteUrl = "https://www.bd24live.com",
            articlesCount = "600K+",
            establishedYear = "২০১১",
            newspaperType = "অনলাইন পোর্টাল",
            description = "দ্রুত ও বিশ্বাসযোগ্য খবরের ডিজিটাল প্ল্যাটফর্ম।"
        ),
        Newspaper(
            id = "np_bangla_tribune",
            nameBangla = "বাংলা ট্রিবিউন",
            nameEnglish = "Bangla Tribune",
            tagLine = "খবরের পেছনে খবর",
            primaryColorHex = 0xFF3949AB,
            logoText = "বাংলা ট্রিবিউন",
            category = CAT_ONLINE,
            websiteUrl = "https://www.banglatribune.com",
            articlesCount = "650K+",
            establishedYear = "২০১৪",
            newspaperType = "অনলাইন পোর্টাল",
            description = "গবেষণামূলক ও অনুসন্ধানী সংবাদের শীর্ষ মাধ্যম।"
        ),
        Newspaper(
            id = "np_jago_news",
            nameBangla = "জাগো নিউজ ২৪",
            nameEnglish = "Jago News 24",
            tagLine = "সময়ের সাহসী কণ্ঠ",
            primaryColorHex = 0xFFFF6F00,
            logoText = "জাগো নিউজ",
            category = CAT_ONLINE,
            websiteUrl = "https://www.jagonews24.com",
            articlesCount = "1.1M+",
            establishedYear = "২০১৪",
            newspaperType = "অনলাইন পোর্টাল",
            description = "প্রাণ-আরএফএল গ্রুপ পরিচালিত অন্যতম জনপ্রিয় পোর্টাল।"
        ),
        Newspaper(
            id = "np_risingbd",
            nameBangla = "রাইজিংবিডি",
            nameEnglish = "Risingbd",
            tagLine = "বাস্তবতার সাথে পথচলা",
            primaryColorHex = 0xFF00B0FF,
            logoText = "রাইজিংবিডি",
            category = CAT_ONLINE,
            websiteUrl = "https://www.risingbd.com",
            articlesCount = "750K+",
            establishedYear = "২০১৩",
            newspaperType = "অনলাইন পোর্টাল",
            description = "ওয়ালটন গ্রুপ সমর্থিত প্রথম সারির নিউজ পোর্টাল।"
        ),
        Newspaper(
            id = "np_dhakatimes24",
            nameBangla = "ঢাকাটাইমস২৪",
            nameEnglish = "DhakaTimes24",
            tagLine = "জনগণের পাশে প্রতি মুহূর্ত",
            primaryColorHex = 0xFF4527A0,
            logoText = "ঢাকাটাইমস",
            category = CAT_ONLINE,
            websiteUrl = "https://www.dhakatimes24.com",
            articlesCount = "580K+",
            establishedYear = "২০১৩",
            newspaperType = "অনলাইন পোর্টাল",
            description = "রাজধানী ঢাকা ও দেশজুড়ে লাইভ খবরের পোর্টাল।"
        ),
        Newspaper(
            id = "np_amadershomoy_com",
            nameBangla = "আমাদের সময়.কম",
            nameEnglish = "AmaderShomoy.com",
            tagLine = "ডিজিটাল সংবাদ মাধ্যম",
            primaryColorHex = 0xFF00838F,
            logoText = "আমাদের সময়",
            category = CAT_ONLINE,
            websiteUrl = "https://www.amadershomoy.com",
            articlesCount = "400K+",
            establishedYear = "২০১৫",
            newspaperType = "অনলাইন পোর্টাল",
            description = "আমাদের সময় গ্রুপের অনলাইন ডিজিটাল সংস্করণ।"
        ),
        Newspaper(
            id = "np_mtnews24",
            nameBangla = "এমটিনিউজ২৪",
            nameEnglish = "MTnews24",
            tagLine = "সত্য উন্মোচনে নির্ভীক",
            primaryColorHex = 0xFFAD1457,
            logoText = "এমটি",
            category = CAT_ONLINE,
            websiteUrl = "https://mtnews24.com",
            articlesCount = "350K+",
            establishedYear = "২০১৬",
            newspaperType = "অনলাইন পোর্টাল",
            description = "জনপ্রিয় বিনোদন ও জাতীয় সংবাদ মাধ্যম।"
        ),
        Newspaper(
            id = "np_dmp_news",
            nameBangla = "ডিএমপি নিউজ",
            nameEnglish = "DMP News",
            tagLine = "ঢাকা মেট্রোপলিটন পুলিশ নিউজ",
            primaryColorHex = 0xFF1A237E,
            logoText = "DMP",
            category = CAT_ONLINE,
            websiteUrl = "https://dmpnews.org",
            articlesCount = "180K+",
            establishedYear = "২০১৬",
            newspaperType = "নিউজ পোর্টাল",
            description = "ডিএমপির অফিশিয়াল ক্রাইম ও ট্রাফিক সংক্রান্ত নিউজ পোর্টাল।"
        ),
        Newspaper(
            id = "np_dhaka_post",
            nameBangla = "ঢাকা পোস্ট",
            nameEnglish = "Dhaka Post",
            tagLine = "সত্যের সাথে সবসময়",
            primaryColorHex = 0xFF2E7D32,
            logoText = "ঢাকা পোস্ট",
            category = CAT_ONLINE,
            websiteUrl = "https://www.dhakapost.com",
            articlesCount = "820K+",
            establishedYear = "২০২১",
            newspaperType = "অনলাইন পোর্টাল",
            description = "ইউএস-বাংলা গ্রুপের শীর্ষস্থানীয় মাল্টিমিডিয়া নিউজ পোর্টাল।"
        ),
        Newspaper(
            id = "np_bangladesh_times",
            nameBangla = "বাংলাদেশ টাইমস",
            nameEnglish = "Bangladesh Times",
            tagLine = "দেশের কথা দশের কথা",
            primaryColorHex = 0xFF0277BD,
            logoText = "টাইমস",
            category = CAT_ONLINE,
            websiteUrl = "https://www.bangladeshtimes.com",
            articlesCount = "290K+",
            establishedYear = "২০১৪",
            newspaperType = "অনলাইন পোর্টাল",
            description = "বস্তুনিষ্ঠ সংবাদের অনলাইন নিউজ পোর্টাল।"
        ),
        Newspaper(
            id = "np_sarabangla",
            nameBangla = "সারাবাংলা",
            nameEnglish = "Sarabangla",
            tagLine = "সারাবাংলার সব খবর",
            primaryColorHex = 0xFF00897B,
            logoText = "সারাবাংলা",
            category = CAT_ONLINE,
            websiteUrl = "https://sarabangla.net",
            articlesCount = "450K+",
            establishedYear = "২০১৭",
            newspaperType = "অনলাইন পোর্টাল",
            description = "সারাদেশের জেলা ও তৃণমূল খবরের অনলাইন মাধ্যম।"
        ),
        Newspaper(
            id = "np_barta24",
            nameBangla = "বার্তা২৪.কম",
            nameEnglish = "barta24.com",
            tagLine = "নিউজ যখন তখন",
            primaryColorHex = 0xFFC2185B,
            logoText = "বার্তা২৪",
            category = CAT_ONLINE,
            websiteUrl = "https://barta24.com",
            articlesCount = "380K+",
            establishedYear = "২০১৮",
            newspaperType = "অনলাইন পোর্টাল",
            description = "আধুনিক মাল্টিমিডিয়া ডিজিটাল নিউজ পোর্টাল।"
        ),
        Newspaper(
            id = "np_shomoyer_alo",
            nameBangla = "সময়ের আলো",
            nameEnglish = "Shomoyer Alo",
            tagLine = "আলো ছড়াবে সত্যের সাথে",
            primaryColorHex = 0xFFE64A19,
            logoText = "সময়ের আলো",
            category = CAT_ONLINE,
            websiteUrl = "https://www.shomoyeralo.com",
            articlesCount = "320K+",
            establishedYear = "২০১৯",
            newspaperType = "অনলাইন ও প্রিন্ট",
            description = "আমিন মোহাম্মদ গ্রুপ প্রকাশিত সংবাদ মাধ্যম।"
        )
    )

    // 4. Business Newspapers/Sites
    val businessNewspapers = listOf(
        Newspaper(
            id = "np_bonik_barta",
            nameBangla = "বণিক বার্তা",
            nameEnglish = "Bonik Barta",
            tagLine = "অর্থনীতি ও বাণিজ্যের অগ্রদূত",
            primaryColorHex = 0xFFFB8C00,
            logoText = "বণিক বার্তা",
            category = CAT_BUSINESS,
            websiteUrl = "https://bonikbarta.net",
            articlesCount = "310K+",
            establishedYear = "২০১১",
            newspaperType = "ব্যবসা দৈনিক",
            description = "দেশের প্রধান অর্থনৈতিক ও বাণিজ্যিক জাতীয় দৈনিক।"
        ),
        Newspaper(
            id = "np_arthosuchak",
            nameBangla = "অর্থসূচক",
            nameEnglish = "ArthoSuchak",
            tagLine = "শেয়ারবাজার ও অর্থনীতির দিকদর্শন",
            primaryColorHex = 0xFF2E7D32,
            logoText = "অর্থসূচক",
            category = CAT_BUSINESS,
            websiteUrl = "https://arthosuchak.com",
            articlesCount = "240K+",
            establishedYear = "২০১৩",
            newspaperType = "অর্থনৈতিক পোর্টাল",
            description = "শেয়ারবাজার ও করপোরেট অর্থনীতির অন্যতম বিশেষায়িত নিউজ পোর্টাল।"
        ),
        Newspaper(
            id = "np_sharenews24",
            nameBangla = "শেয়ারনিউজ২৪",
            nameEnglish = "ShareNews24",
            tagLine = "পুঁজিবাজারের বিশ্বস্ত সংবাদ",
            primaryColorHex = 0xFF1565C0,
            logoText = "শেয়ারনিউজ",
            category = CAT_BUSINESS,
            websiteUrl = "https://sharenews24.com",
            articlesCount = "190K+",
            establishedYear = "২০১৪",
            newspaperType = "শেয়ারবাজার পোর্টাল",
            description = "ঢাকা ও চট্টগ্রাম স্টক এক্সচেঞ্জের রিয়েলটাইম আপডেট।"
        ),
        Newspaper(
            id = "np_dse",
            nameBangla = "ঢাকা স্টক এক্সচেঞ্জ",
            nameEnglish = "Dhaka Stock Exchange",
            tagLine = "প্রধান পুঁজিবাজার প্ল্যাটফর্ম",
            primaryColorHex = 0xFF0D47A1,
            logoText = "DSE",
            category = CAT_BUSINESS,
            websiteUrl = "https://www.dsebd.org",
            articlesCount = "100K+",
            establishedYear = "১৯৫৪",
            newspaperType = "স্টক এক্সচেঞ্জ",
            description = "বাংলাদেশের প্রধান সিকিউরিটিজ ও পুঁজিবাজারের অফিশিয়াল প্ল্যাটফর্ম।"
        ),
        Newspaper(
            id = "np_ajker_bazzar",
            nameBangla = "আজকের বাজার",
            nameEnglish = "Ajker Bazzar",
            tagLine = "ব্যবসা-বাণিজ্যের সব খবর",
            primaryColorHex = 0xFF00695C,
            logoText = "আজকের বাজার",
            category = CAT_BUSINESS,
            websiteUrl = "https://ajkerbazzar.com",
            articlesCount = "150K+",
            establishedYear = "২০১৬",
            newspaperType = "ব্যবসা পোর্টাল",
            description = "দৈনন্দিন বাজারদর ও ব্যবসা সংক্রান্ত নিউজ পোর্টাল।"
        ),
        Newspaper(
            id = "np_sharebazarnews",
            nameBangla = "শেয়ার বাজার নিউজ",
            nameEnglish = "Share Bazar News",
            tagLine = "বিনিয়োগকারীদের আস্থার প্রতীক",
            primaryColorHex = 0xFF00838F,
            logoText = "শেয়ারবাজার",
            category = CAT_BUSINESS,
            websiteUrl = "https://www.sharebazarnews.com",
            articlesCount = "170K+",
            establishedYear = "২০১৫",
            newspaperType = "পুঁজিবাজার পোর্টাল",
            description = "পুঁজিবাজারের কোম্পানি বিশ্লেষণ ও শেয়ার দর খবর।"
        ),
        Newspaper(
            id = "np_sharebarta24",
            nameBangla = "শেয়ারবার্তা২৪",
            nameEnglish = "ShareBarta24",
            tagLine = "পুঁজিবাজারের নির্ভীক বার্তা",
            primaryColorHex = 0xFF4E342E,
            logoText = "শেয়ারবার্তা",
            category = CAT_BUSINESS,
            websiteUrl = "https://sharebarta24.com",
            articlesCount = "140K+",
            establishedYear = "২০১৬",
            newspaperType = "পুঁজিবাজার পোর্টাল",
            description = "শেয়ারবাজার ও করপোরেট খবর পরিবেশন।"
        ),
        Newspaper(
            id = "np_sharemarketbd",
            nameBangla = "শেয়ারমার্কেটবিডি",
            nameEnglish = "ShareMarketBD",
            tagLine = "বিনিয়োগ সহায়ক তথ্যকেন্দ্র",
            primaryColorHex = 0xFF37474F,
            logoText = "মার্কেটবিডি",
            category = CAT_BUSINESS,
            websiteUrl = "https://sharemarketbd.com",
            articlesCount = "130K+",
            establishedYear = "২০১৭",
            newspaperType = "পুঁজিবাজার পোর্টাল",
            description = "মিউচুয়াল ফান্ড ও শেয়ার বিশ্লেষণ।"
        ),
        Newspaper(
            id = "np_share_biz",
            nameBangla = "শেয়ার বিজ",
            nameEnglish = "Share Biz",
            tagLine = "বাণিজ্য ও অর্থনীতি প্রতিদিন",
            primaryColorHex = 0xFFE65100,
            logoText = "শেয়ার বিজ",
            category = CAT_BUSINESS,
            websiteUrl = "https://sharebiz.net",
            articlesCount = "220K+",
            establishedYear = "২০১৬",
            newspaperType = "ব্যবসা দৈনিক",
            description = "জাতীয় বাণিজ্যিক দৈনিক ও অনলাইন সংস্করণ।"
        ),
        Newspaper(
            id = "np_business24bd",
            nameBangla = "বিজনেস২৪বিডি",
            nameEnglish = "Business24BD",
            tagLine = "বাণিজ্যিক দুনিয়ার সব সংবাদ",
            primaryColorHex = 0xFF283593,
            logoText = "বিজনেস২৪",
            category = CAT_BUSINESS,
            websiteUrl = "https://business24bd.com",
            articlesCount = "110K+",
            establishedYear = "২০১৮",
            newspaperType = "ব্যবসা পোর্টাল",
            description = "রপ্তানি, আমদানি ও কর্পোরেট খবরের অনলাইন পোর্টাল।"
        ),
        Newspaper(
            id = "np_bank_bima",
            nameBangla = "ব্যাংক বীমা শিল্প",
            nameEnglish = "Bank Bima Shilpa",
            tagLine = "আর্থিক খাতের বিশ্বস্ত পত্রিকা",
            primaryColorHex = 0xFF004D40,
            logoText = "ব্যাংক বীমা",
            category = CAT_BUSINESS,
            websiteUrl = "https://bankbimashilpa.com",
            articlesCount = "120K+",
            establishedYear = "২০১৭",
            newspaperType = "আর্থিক পোর্টাল",
            description = "ব্যাংকিং ও বীমা খাতের বিশেষায়িত সংবাদ।"
        ),
        Newspaper(
            id = "np_arthoniteer_kagoj",
            nameBangla = "অর্থনীতির কাগজ",
            nameEnglish = "Arthoniteer Kagoj",
            tagLine = "অর্থনীতির নির্ভীক কথন",
            primaryColorHex = 0xFF558B2F,
            logoText = "অর্থনীতি",
            category = CAT_BUSINESS,
            websiteUrl = "https://arthoniteerkagoj.com",
            articlesCount = "95K+",
            establishedYear = "২০১৯",
            newspaperType = "অর্থনৈতিক পোর্টাল",
            description = "সামষ্টিক অর্থনীতি ও বাজেট বিশ্লেষণের পোর্টাল।"
        )
    )

    // 5. Sports News
    val sportsNews = listOf(
        Newspaper(
            id = "np_bdcrictime",
            nameBangla = "বিডিক্রিকটাইম",
            nameEnglish = "bdcrictime",
            tagLine = "বাংলাদেশের ক্রিকেটের প্রাণ",
            primaryColorHex = 0xFF2E7D32,
            logoText = "বিডিক্রিক",
            category = CAT_SPORTS,
            websiteUrl = "https://www.bdcrictime.com",
            articlesCount = "380K+",
            establishedYear = "২০১১",
            newspaperType = "ক্রীড়া পোর্টাল",
            description = "বাংলাদেশের ক্রিকেটপ্রেমীদের প্রধান অনলাইন ঠিকানা ও লাইভ স্কোর।"
        ),
        Newspaper(
            id = "np_t_sports",
            nameBangla = "টি স্পোর্টস",
            nameEnglish = "T Sports",
            tagLine = "দেশের প্রথম ও একমাত্র স্পোর্টস চ্যানেল",
            primaryColorHex = 0xFFD50000,
            logoText = "T Sports",
            category = CAT_SPORTS,
            websiteUrl = "https://tsports.com",
            articlesCount = "260K+",
            establishedYear = "২০২০",
            newspaperType = "টিভি ও অনলাইন",
            description = "বসুন্ধরা গ্রুপের স্পোর্টস টেলিভিশন ও ডিজিটাল স্পোর্টস প্ল্যাটফর্ম।"
        ),
        Newspaper(
            id = "np_cricfrenzy",
            nameBangla = "ক্রিকফ্রেঞ্জি",
            nameEnglish = "Cricfrenzy",
            tagLine = "ক্রিকেট উন্মাদনায় সবসময়",
            primaryColorHex = 0xFF0288D1,
            logoText = "ক্রিকফ্রেঞ্জি",
            category = CAT_SPORTS,
            websiteUrl = "https://cricfrenzy.com",
            articlesCount = "210K+",
            establishedYear = "২০১৭",
            newspaperType = "ক্রিকেট পোর্টাল",
            description = "আন্তর্জাতিক ও ঘরোয়া ক্রিকেটের পুঙ্খানুপুঙ্খ প্রতিবেদন।"
        ),
        Newspaper(
            id = "np_sportsmail24",
            nameBangla = "স্পোর্টসমেইল২৪",
            nameEnglish = "Sportsmail24.com",
            tagLine = "খেলাধুলার সব খবরের ঠিকানা",
            primaryColorHex = 0xFFE65100,
            logoText = "স্পোর্টসমেইল",
            category = CAT_SPORTS,
            websiteUrl = "https://sportsmail24.com",
            articlesCount = "180K+",
            establishedYear = "২০১৫",
            newspaperType = "স্পোর্টস পোর্টাল",
            description = "ফুটবল, ক্রিকেট ও অলিম্পিক খবরের বিশেষায়িত সাইট।"
        ),
        Newspaper(
            id = "np_offside_bd",
            nameBangla = "অফসাইড বাংলাদেশ",
            nameEnglish = "Offside Bangladesh",
            tagLine = "বাংলাদেশি ফুটবলের কণ্ঠস্বর",
            primaryColorHex = 0xFF388E3C,
            logoText = "অফসাইড",
            category = CAT_SPORTS,
            websiteUrl = "https://offsidebangladesh.com",
            articlesCount = "140K+",
            establishedYear = "২০১৮",
            newspaperType = "ফুটবল পোর্টাল",
            description = "বাংলাদেশ প্রিমিয়ার লিগ ও জাতীয় ফুটবল দলের খবর।"
        )
    )

    // 6. Education News
    val educationNews = listOf(
        Newspaper(
            id = "np_dainik_shiksha",
            nameBangla = "দৈনিক শিক্ষা",
            nameEnglish = "Dainik Shiksha",
            tagLine = "শিক্ষা খাতের প্রথম জাতীয় পত্রিকা",
            primaryColorHex = 0xFF1E88E5,
            logoText = "দৈনিক শিক্ষা",
            category = CAT_EDUCATION,
            websiteUrl = "https://www.dainikshiksha.com",
            articlesCount = "420K+",
            establishedYear = "২০১০",
            newspaperType = "শিক্ষা পোর্টাল",
            description = "বাংলাদেশের শিক্ষক, শিক্ষার্থী ও শিক্ষা মন্ত্রণালয়ের প্রধান সংবাদ মাধ্যম।"
        ),
        Newspaper(
            id = "np_daily_campus",
            nameBangla = "দ্য ডেইলি ক্যাম্পাস",
            nameEnglish = "The Daily Campus",
            tagLine = "বিশ্ববিদ্যালয় ও ক্যাম্পাসের কণ্ঠস্বর",
            primaryColorHex = 0xFF00897B,
            logoText = "ডেইলি ক্যাম্পাস",
            category = CAT_EDUCATION,
            websiteUrl = "https://thedailycampus.com",
            articlesCount = "310K+",
            establishedYear = "২০১৮",
            newspaperType = "ক্যাম্পাস পোর্টাল",
            description = "সকল পাবলিক ও প্রাইভেট বিশ্ববিদ্যালয়ের ভর্তি পরীক্ষা ও অ্যাকাডেমিক খবর।"
        ),
        Newspaper(
            id = "np_shikkhabarta",
            nameBangla = "শিক্ষাবার্তা",
            nameEnglish = "Shikkhabarta",
            tagLine = "শিক্ষার আলো ঘরে ঘরে",
            primaryColorHex = 0xFF7B1FA2,
            logoText = "শিক্ষাবার্তা",
            category = CAT_EDUCATION,
            websiteUrl = "https://shikkhabarta.com",
            articlesCount = "190K+",
            establishedYear = "২০১৭",
            newspaperType = "শিক্ষা পোর্টাল",
            description = "প্রাথমিক, মাধ্যমিক ও উচ্চশিক্ষার সর্বশেষ সরকারি নোটিশ ও সংবাদ।"
        )
    )

    // 7. English Newspapers
    val englishNewspapers = listOf(
        Newspaper(
            id = "np_daily_star",
            nameBangla = "দ্য ডেইলি স্টার",
            nameEnglish = "Daily Star",
            tagLine = "Journalism Without Fear or Favour",
            primaryColorHex = 0xFFC62828,
            logoText = "Daily Star",
            category = CAT_ENGLISH,
            websiteUrl = "https://www.thedailystar.net",
            articlesCount = "1.3M+",
            establishedYear = "১৯৯১",
            newspaperType = "English Daily",
            description = "The largest circulating English-language daily newspaper in Bangladesh."
        ),
        Newspaper(
            id = "np_dhaka_tribune",
            nameBangla = "ঢাকা ট্রিবিউন",
            nameEnglish = "Dhaka Tribune",
            tagLine = "The News You Can Trust",
            primaryColorHex = 0xFF1565C0,
            logoText = "Dhaka Tribune",
            category = CAT_ENGLISH,
            websiteUrl = "https://www.dhakatribune.com",
            articlesCount = "950K+",
            establishedYear = "২০১৩",
            newspaperType = "English Daily",
            description = "Leading Bangladeshi English broadsheet known for progressive journalism."
        ),
        Newspaper(
            id = "np_new_age",
            nameBangla = "নিউ এজ",
            nameEnglish = "New Age",
            tagLine = "The Outspoken Daily",
            primaryColorHex = 0xFF2E7D32,
            logoText = "New Age",
            category = CAT_ENGLISH,
            websiteUrl = "https://www.newagebd.net",
            articlesCount = "600K+",
            establishedYear = "২০০৩",
            newspaperType = "English Daily",
            description = "Prominent English-language daily renowned for hard-hitting investigative stories."
        ),
        Newspaper(
            id = "np_daily_sun",
            nameBangla = "ডেইলি সান",
            nameEnglish = "Daily Sun",
            tagLine = "True and Impartial",
            primaryColorHex = 0xFFF57F17,
            logoText = "Daily Sun",
            category = CAT_ENGLISH,
            websiteUrl = "https://www.daily-sun.com",
            articlesCount = "650K+",
            establishedYear = "২০১০",
            newspaperType = "English Daily",
            description = "Major English daily published by the East West Media Group (Bashundhara)."
        ),
        Newspaper(
            id = "np_financial_express",
            nameBangla = "দ্য ফাইন্যান্সিয়াল এক্সপ্রেস",
            nameEnglish = "Financial Express",
            tagLine = "First Financial Daily of Bangladesh",
            primaryColorHex = 0xFF00695C,
            logoText = "Financial Express",
            category = CAT_ENGLISH,
            websiteUrl = "https://thefinancialexpress.com.bd",
            articlesCount = "520K+",
            establishedYear = "১৯৯৩",
            newspaperType = "Business Daily",
            description = "Leading English financial and economic daily newspaper of Bangladesh."
        ),
        Newspaper(
            id = "np_observer",
            nameBangla = "দ্য ডেইলি অবজারভার",
            nameEnglish = "Observer",
            tagLine = "Sharp, Candid & Credible",
            primaryColorHex = 0xFF283593,
            logoText = "Observer",
            category = CAT_ENGLISH,
            websiteUrl = "https://www.observerbd.com",
            articlesCount = "480K+",
            establishedYear = "২০১১",
            newspaperType = "English Daily",
            description = "Respected English national daily edited by veteran editors."
        ),
        Newspaper(
            id = "np_bangladesh_today",
            nameBangla = "দ্য বাংলাদেশ টুডে",
            nameEnglish = "Bangladesh Today",
            tagLine = "Reflecting The Nation",
            primaryColorHex = 0xFFAD1457,
            logoText = "BD Today",
            category = CAT_ENGLISH,
            websiteUrl = "https://thebangladeshtoday.com",
            articlesCount = "310K+",
            establishedYear = "২০০২",
            newspaperType = "English Daily",
            description = "English newspaper covering national politics, trade, and youth trends."
        ),
        Newspaper(
            id = "np_asian_age",
            nameBangla = "দ্য এশিয়ান এইজ",
            nameEnglish = "Asian Age",
            tagLine = "Bridging Asia and the World",
            primaryColorHex = 0xFFD84315,
            logoText = "Asian Age",
            category = CAT_ENGLISH,
            websiteUrl = "https://dailyasianage.com",
            articlesCount = "350K+",
            establishedYear = "২০১৬",
            newspaperType = "English Daily",
            description = "English national daily focusing on diplomacy, business, and geopolitical analysis."
        ),
        Newspaper(
            id = "np_prothom_alo_en",
            nameBangla = "প্রথম আলো ইংরেজি",
            nameEnglish = "Prothom Alo English",
            tagLine = "Connecting Bangladesh Globally",
            primaryColorHex = 0xFFE53935,
            logoText = "PA English",
            category = CAT_ENGLISH,
            websiteUrl = "https://en.prothomalo.com",
            articlesCount = "600K+",
            establishedYear = "২০১৪",
            newspaperType = "English Portal",
            description = "English edition of Prothom Alo covering news from a global perspective."
        ),
        Newspaper(
            id = "np_bd_post",
            nameBangla = "বাংলাদেশ পোস্ট",
            nameEnglish = "Bangladesh Post",
            tagLine = "A New Dawn in Journalism",
            primaryColorHex = 0xFF0277BD,
            logoText = "BD Post",
            category = CAT_ENGLISH,
            websiteUrl = "https://bangladeshpost.net",
            articlesCount = "290K+",
            establishedYear = "২০১৯",
            newspaperType = "English Daily",
            description = "Modern English newspaper with in-depth lifestyle and national reports."
        ),
        Newspaper(
            id = "np_energy_bangla",
            nameBangla = "এনার্জি বাংলা",
            nameEnglish = "Energy Bangla",
            tagLine = "Dedicated to Power & Energy Sector",
            primaryColorHex = 0xFF558B2F,
            logoText = "Energy",
            category = CAT_ENGLISH,
            websiteUrl = "https://energybangla.com",
            articlesCount = "150K+",
            establishedYear = "২০০৯",
            newspaperType = "Specialized English",
            description = "Pioneering news publication focusing on power, oil, gas, and energy in South Asia."
        ),
        Newspaper(
            id = "np_good_morning",
            nameBangla = "দ্য গুড মর্নিং",
            nameEnglish = "Good Morning",
            tagLine = "Morning News for Bangladesh",
            primaryColorHex = 0xFF6A1B9A,
            logoText = "Good Morning",
            category = CAT_ENGLISH,
            websiteUrl = "https://goodmorning.com.bd",
            articlesCount = "120K+",
            establishedYear = "২০১৮",
            newspaperType = "English Portal",
            description = "English digital daily with feature stories and current events."
        )
    )

    // 8. News Agencies
    val newsAgencies = listOf(
        Newspaper(
            id = "np_bss",
            nameBangla = "বাসস",
            nameEnglish = "Bangladesh National News Agency (BSS)",
            tagLine = "জাতীয় সংবাদ সংস্থা",
            primaryColorHex = 0xFF004D40,
            logoText = "বাসস",
            category = CAT_AGENCY,
            websiteUrl = "https://www.bssnews.net",
            articlesCount = "800K+",
            establishedYear = "১৯৭২",
            newspaperType = "জাতীয় সংবাদ সংস্থা",
            description = "বাংলাদেশের একমাত্র রাষ্ট্রীয় ও জাতীয় বার্তা সংস্থা।"
        ),
        Newspaper(
            id = "np_unb",
            nameBangla = "ইউএনবি",
            nameEnglish = "United News of Bangladesh (UNB)",
            tagLine = "বিশ্বস্ত বেসরকারি সংবাদ সংস্থা",
            primaryColorHex = 0xFF1565C0,
            logoText = "UNB",
            category = CAT_AGENCY,
            websiteUrl = "https://unb.com.bd",
            articlesCount = "650K+",
            establishedYear = "১৯৮৮",
            newspaperType = "বার্তা সংস্থা",
            description = "বাংলাদেশের প্রথম ও শীর্ষ বেসরকারি বার্তা সংস্থা এবং অ্যাসোসিয়েটেড প্রেস (AP) এর পার্টনার।"
        ),
        Newspaper(
            id = "np_ena",
            nameBangla = "ইনা",
            nameEnglish = "Eastern News Agency (ENA)",
            tagLine = "ঐতিহাসিক বেসরকারি সংবাদ সংস্থা",
            primaryColorHex = 0xFF4527A0,
            logoText = "ENA",
            category = CAT_AGENCY,
            websiteUrl = "https://enabangladesh.com",
            articlesCount = "200K+",
            establishedYear = "১৯৭০",
            newspaperType = "বার্তা সংস্থা",
            description = "বাংলাদেশের প্রাচীনতম বেসরকারি সংবাদ বার্তা সংস্থা।"
        )
    )

    // 9. International Bangla
    val internationalBangla = listOf(
        Newspaper(
            id = "np_bbc_bangla",
            nameBangla = "বিবিসি বাংলা",
            nameEnglish = "BBC Bangla",
            tagLine = "আন্তর্জাতিক মানসম্পন্ন নিরপেক্ষ সংবাদ",
            primaryColorHex = 0xFFB71C1C,
            logoText = "BBC",
            category = CAT_INTERNATIONAL,
            websiteUrl = "https://www.bbc.com/bengali",
            articlesCount = "1.0M+",
            establishedYear = "১৯৪১",
            newspaperType = "আন্তর্জাতিক গণমাধ্যম",
            description = "ব্রিটিশ ব্রডকাস্টিং করপোরেশন (বিবিসি) এর বাংলা ভাষার বিশ্বাসযোগ্য বৈশ্বিক সেবা।"
        ),
        Newspaper(
            id = "np_voa_bangla",
            nameBangla = "ভয়েস অব আমেরিকা বাংলা",
            nameEnglish = "VOA Bangla",
            tagLine = "সত্য ও মুক্ত সমাজের প্রতীক",
            primaryColorHex = 0xFF0D47A1,
            logoText = "VOA",
            category = CAT_INTERNATIONAL,
            websiteUrl = "https://www.voabangla.com",
            articlesCount = "500K+",
            establishedYear = "১৯৫৮",
            newspaperType = "আন্তর্জাতিক গণমাধ্যম",
            description = "যুক্তরাষ্ট্রের আন্তর্জাতিক সম্প্রচার সংস্থা ভয়েস অব আমেরিকার বাংলা বিভাগ।"
        ),
        Newspaper(
            id = "np_dw_bangla",
            nameBangla = "ডয়চে ভেলে বাংলা",
            nameEnglish = "DW Bangla",
            tagLine = "জার্মানি ও বিশ্বের অন্তর্দৃষ্টি",
            primaryColorHex = 0xFF00838F,
            logoText = "DW",
            category = CAT_INTERNATIONAL,
            websiteUrl = "https://www.dw.com/bn",
            articlesCount = "450K+",
            establishedYear = "১৯৬৫",
            newspaperType = "আন্তর্জাতিক গণমাধ্যম",
            description = "জার্মানির আন্তর্জাতিক সম্প্রচারমাধ্যম ডয়চে ভেলের বাংলা বিভাগ।"
        ),
        Newspaper(
            id = "np_nhk_bangla",
            nameBangla = "এনএইচকে ওয়ার্ল্ড বাংলা",
            nameEnglish = "NHK World Bangla",
            tagLine = "জাপানের আন্তর্জাতিক কণ্ঠ",
            primaryColorHex = 0xFFC2185B,
            logoText = "NHK",
            category = CAT_INTERNATIONAL,
            websiteUrl = "https://www3.nhk.or.jp/nhkworld/bn",
            articlesCount = "300K+",
            establishedYear = "১৯৪৩",
            newspaperType = "আন্তর্জাতিক গণমাধ্যম",
            description = "জাপানের রাষ্ট্রীয় সম্প্রচার সংস্থা এনএইচকে এর বাংলা সংবাদ সেবা।"
        ),
        Newspaper(
            id = "np_cri_bangla",
            nameBangla = "চীন আন্তর্জাতিক বেতার",
            nameEnglish = "CRI Bangla",
            tagLine = "চীন ও বিশ্বের মেলবন্ধন",
            primaryColorHex = 0xFFD84315,
            logoText = "CRI",
            category = CAT_INTERNATIONAL,
            websiteUrl = "https://bengali.cri.cn",
            articlesCount = "250K+",
            establishedYear = "১৯৬৯",
            newspaperType = "আন্তর্জাতিক গণমাধ্যম",
            description = "চায়না মিডিয়া গ্রুপের বাংলা ভাষার আন্তর্জাতিক সংবাদ ও সাংস্কৃতিক প্ল্যাটফর্ম।"
        )
    )

    // 10. More Bangla News Sites (40 Sites)
    val moreBanglaNewsSites = listOf(
        Newspaper("np_bd_morning", "বিডি মর্নিং", "BD Morning", "দিনের শুরুতে সত্য সংবাদ", 0xFF00897B, "বিডি মর্নিং", CAT_MORE_ONLINE, false, "https://www.bdmorning.com"),
        Newspaper("np_bangla_telegraph", "বাংলা টেলিগ্রাফ", "Bangla Telegraph", "দ্রুততম অনলাইন সংবাদ", 0xFF1976D2, "টেলিগ্রাফ", CAT_MORE_ONLINE, false, "https://banglatelegraph.com"),
        Newspaper("np_last_news_bd", "লাস্ট নিউজ বিডি", "Last News BD", "সর্বশেষ খবরের মুহূর্ত", 0xFFD32F2F, "লাস্ট নিউজ", CAT_MORE_ONLINE, false, "https://lastnewsbd.com"),
        Newspaper("np_zoom_bangla", "জুম বাংলা", "Zoom Bangla", "ডিজিটাল দুনিয়ার সব খবর", 0xFF388E3C, "জুম বাংলা", CAT_MORE_ONLINE, false, "https://zoombangla.com"),
        Newspaper("np_somoyer_konthosor", "সময়ের কণ্ঠস্বর", "Somoyer Konthosor", "জনতার পক্ষে সোচ্চার", 0xFFE64A19, "কণ্ঠস্বর", CAT_MORE_ONLINE, false, "https://www.somoyerkonthosor.com"),
        Newspaper("np_the_report24", "দ্য রিপোর্ট ২৪", "The Report 24", "গবেষণামূলক প্রতিবেদন", 0xFF512DA8, "রিপোর্ট", CAT_MORE_ONLINE, false, "https://thereport24.com"),
        Newspaper("np_just_news_bd", "জাস্ট নিউজ বিডি", "Just News BD", "রাজনীতি ও জাতীয় খবর", 0xFF00796B, "জাস্ট নিউজ", CAT_MORE_ONLINE, false, "https://justnewsbd.com"),
        Newspaper("np_bbarta24", "বিবার্তা২৪", "BBarta24", "মুক্ত ও নির্ভীক সংবাদ", 0xFFC2185B, "বিবার্তা", CAT_MORE_ONLINE, false, "https://bbarta24.net"),
        Newspaper("np_barta_bazar", "বার্তা বাজার", "Barta Bazar", "খবরের বিশাল বাজার", 0xFF0288D1, "বার্তা বাজার", CAT_MORE_ONLINE, false, "https://bartabazar.com"),
        Newspaper("np_dhaka_today", "ঢাকা টুডে", "Dhaka Today", "আজকের ঢাকার সব খবর", 0xFF303F9F, "ঢাকা টুডে", CAT_MORE_ONLINE, false, "https://dhakatoday.com"),
        Newspaper("np_gonokantho", "গণকণ্ঠ", "Gonokantho", "জনগণের নিজস্ব প্ল্যাটফর্ম", 0xFFD81B60, "গণকণ্ঠ", CAT_MORE_ONLINE, false, "https://gonokantho.com"),
        Newspaper("np_fair_news", "ফেয়ার নিউজ সার্ভিস", "Fair News Service", "নিরপেক্ষ ও বস্তুনিষ্ঠ", 0xFF00838F, "ফেয়ার নিউজ", CAT_MORE_ONLINE, false, "https://fairnewsservice.com"),
        Newspaper("np_politics_news24", "পলিটিক্স নিউজ ২৪", "Politics News 24", "রাজনৈতিক সমীকরণের খবর", 0xFFBF360C, "পলিটিক্স", CAT_MORE_ONLINE, false, "https://politicsnews24.com"),
        Newspaper("np_uttaradhikar71", "উত্তরাধিকার ৭১ নিউজ", "Uttaradhikar 71 News", "মুক্তিযুদ্ধের চেতনায়", 0xFF2E7D32, "৭১ নিউজ", CAT_MORE_ONLINE, false, "https://uttaradhikar71news.com"),
        Newspaper("np_bd_view24", "বিডি ভিউ ২৪", "BD View 24", "দেশের চিত্র এক নজরে", 0xFF0277BD, "বিডি ভিউ", CAT_MORE_ONLINE, false, "https://bdview24.com"),
        Newspaper("np_fulki", "ফুলকি", "Fulki", "প্রতিবাদের স্ফুলিঙ্গ", 0xFF8E24AA, "ফুলকি", CAT_MORE_ONLINE, false, "https://fulki.com"),
        Newspaper("np_dhaka_news24", "ঢাকা নিউজ ২৪", "Dhaka News 24", "রাজধানীর সংবাদ লাইভ", 0xFF1565C0, "ঢাকা নিউজ", CAT_MORE_ONLINE, false, "https://dhakanews24.com"),
        Newspaper("np_amader_protidin", "আমাদের প্রতিদিন", "Amader Protidin", "প্রতিদিনের খবর প্রতিদিন", 0xFF00695C, "আমাদের প্রতিদিন", CAT_MORE_ONLINE, false, "https://amaderprotidin.com"),
        Newspaper("np_natun_barta", "নতুন বার্তা", "Natun Barta", "নতুন দিনের ভাবনা", 0xFFC62828, "নতুন বার্তা", CAT_MORE_ONLINE, false, "https://natunbarta.com"),
        Newspaper("np_united_news24", "ইউনাইটেড নিউজ ২৪", "United News 24", "ঐক্যের সংবাদ মাধ্যম", 0xFF4527A0, "ইউনাইটেড", CAT_MORE_ONLINE, false, "https://unitednews24.com"),
        Newspaper("np_dhaka_protidin", "ঢাকা প্রতিদিন", "Dhaka Protidin", "ঢাকার প্রতিদিনের খবর", 0xFF283593, "ঢাকা প্রতিদিন", CAT_MORE_ONLINE, false, "https://dhakaprotidin.com"),
        Newspaper("np_bangla_post_bd", "বাংলা পোস্ট বিডি", "Bangla Post BD", "ডিজিটাল পোস্টাল খবর", 0xFF00897B, "বাংলা পোস্ট", CAT_MORE_ONLINE, false, "https://banglapostbd.com"),
        Newspaper("np_sorejomin_barta", "সরেজমিন বার্তা", "Sorejomin Barta", "ঘটনাস্থল থেকে সরাসরি", 0xFFE65100, "সরেজমিন", CAT_MORE_ONLINE, false, "https://sorejominbarta.com"),
        Newspaper("np_alokito_protidin", "আলোকিত প্রতিদিন", "Alokito Protidin", "আলোকিত জীবনের সন্ধানে", 0xFF558B2F, "আলোকিত", CAT_MORE_ONLINE, false, "https://alokitoprotidin.com"),
        Newspaper("np_prothom_khabor", "প্রথম খবর", "Prothom Khabor", "খবর সবার আগে", 0xFFAD1457, "প্রথম খবর", CAT_MORE_ONLINE, false, "https://prothomkhabor.com"),
        Newspaper("np_barta_bangla", "বার্তা বাংলা", "Barta Bangla", "বাংলার নিজস্ব বার্তা", 0xFF00838F, "বার্তা বাংলা", CAT_MORE_ONLINE, false, "https://bartabangla.com"),
        Newspaper("np_news71_online", "নিউজ৭১ অনলাইন", "News71 Online", "একাত্তরের প্রেরণায়", 0xFF2E7D32, "নিউজ৭১", CAT_MORE_ONLINE, false, "https://news71online.com"),
        Newspaper("np_latest_bd_news", "লেটেস্ট বিডি নিউজ", "Latest BD News", "লাইভ ব্রেকিং নিউজ", 0xFFD32F2F, "লেটেস্ট বিডি", CAT_MORE_ONLINE, false, "https://latestbdnews.com"),
        Newspaper("np_one_news_bd", "ওয়ান নিউজ বিডি", "One News BD", "এক ঠিকানায় সব খবর", 0xFF1976D2, "ওয়ান নিউজ", CAT_MORE_ONLINE, false, "https://onenewsbd.com"),
        Newspaper("np_khola_kagoj", "খোলা কাগজ", "Khola Kagoj", "খোলামেলা সত্য ভাষণ", 0xFFE64A19, "খোলা কাগজ", CAT_MORE_ONLINE, false, "https://kholakagojbd.com"),
        Newspaper("np_bahumatrik", "বহুমাত্রিক", "Bahumatrik", "নানামুখী দৃষ্টিকোণ", 0xFF6A1B9A, "বহুমাত্রিক", CAT_MORE_ONLINE, false, "https://bahumatrik.com"),
        Newspaper("np_shotto_bani", "সত্য বাণী", "Shotto Bani", "সত্যের পথে অবিচল", 0xFF00796B, "সত্য বাণী", CAT_MORE_ONLINE, false, "https://shottobani.com"),
        Newspaper("np_lakhokantho", "লাখো কণ্ঠ", "Lakhokantho", "লাখো জনতার স্বর", 0xFFC2185B, "লাখো কণ্ঠ", CAT_MORE_ONLINE, false, "https://lakhokantho.com"),
        Newspaper("np_medivoice", "মেডিভয়েস", "MediVoice", "স্বাস্থ্য ও চিকিৎসকদের কণ্ঠ", 0xFF0288D1, "মেডিভয়েস", CAT_MORE_ONLINE, false, "https://medivoicebd.com"),
        Newspaper("np_sangbad_protidin24", "সংবাদ প্রতিদিন ২৪", "Sangbad Protidin 24", "দিনবদলের সংবাদ", 0xFFD81B60, "সংবাদ প্রতিদিন", CAT_MORE_ONLINE, false, "https://sangbadprotidin24.com"),
        Newspaper("np_khobor_protidin24", "খবর প্রতিদিন ২৪", "Khobor Protidin 24", "খবর ২৪ ঘণ্টা", 0xFF5D4037, "খবর প্রতিদিন", CAT_MORE_ONLINE, false, "https://khoborprotidin24.com"),
        Newspaper("np_khabor", "খবর", "Khabor", "দেশের খবর বিদেশের খবর", 0xFF37474F, "খবর", CAT_MORE_ONLINE, false, "https://khabor.com"),
        Newspaper("np_bd_bulletin", "বিডি বুলেটিন", "BD Bulletin", "সংক্ষিপ্ত ও গভীর খবর", 0xFF00695C, "বুলেটিন", CAT_MORE_ONLINE, false, "https://bdbulletin.com"),
        Newspaper("np_bbc24_news", "বিবিসি২৪ নিউজ", "BBC24 News", "অনলাইন সংবাদ প্ল্যাটফর্ম", 0xFFB71C1C, "বিবিসি২৪", CAT_MORE_ONLINE, false, "https://bbc24news.com"),
        Newspaper("np_suprobhat", "সুप्रभात", "Suprobhat", "নতুন সূর্যে নতুন খবর", 0xFF1E88E5, "সুप्रभात", CAT_MORE_ONLINE, false, "https://suprobhat.com")
    )

    // Complete Combined List of all 120 Newspapers & Portals
    val allNewspapers: List<Newspaper> by lazy {
        topNewspapers +
                banglaNewspapers +
                topNewsSites +
                businessNewspapers +
                sportsNews +
                educationNews +
                englishNewspapers +
                newsAgencies +
                internationalBangla +
                moreBanglaNewsSites
    }

    fun getNewspapersByCategory(cat: String): List<Newspaper> {
        return if (cat == "সকল") {
            allNewspapers
        } else {
            allNewspapers.filter { it.category == cat }
        }
    }

    /**
     * Find a newspaper by unique identifier.
     */
    fun findById(id: String): Newspaper? = allNewspapers.firstOrNull { it.id == id }

    /**
     * Find a newspaper by its website URL or domain.
     */
    fun findByUrl(url: String): Newspaper? {
        val clean = url.trim().lowercase()
        return allNewspapers.firstOrNull {
            it.websiteUrl.equals(clean, ignoreCase = true) ||
                    it.cleanDomain.equals(clean, ignoreCase = true) ||
                    clean.contains(it.cleanDomain)
        }
    }

    /**
     * Search newspapers across Bengali name, English name, tagline, and category.
     */
    fun searchNewspapers(query: String): List<Newspaper> {
        val q = query.trim()
        if (q.isEmpty()) return allNewspapers
        return allNewspapers.filter { it.matchesQuery(q) }
    }

    /**
     * Lookup a Category object by its ID.
     */
    fun getCategoryById(id: String): Category? = categories.firstOrNull { it.id == id }

    /**
     * Lookup a Category object by its Bengali or English title.
     */
    fun getCategoryByName(name: String): Category? = categories.firstOrNull {
        it.nameBangla.equals(name, ignoreCase = true) ||
                it.nameEnglish.equals(name, ignoreCase = true)
    }

    /**
     * Retrieve all newspapers under a specific Category object.
     */
    fun getNewspapersForCategory(category: Category): List<Newspaper> {
        return getNewspapersByCategory(category.nameBangla)
    }
}
