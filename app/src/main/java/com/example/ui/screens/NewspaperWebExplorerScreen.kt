package com.example.ui.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.model.Newspaper
import com.example.ui.theme.BorderLight
import com.example.ui.theme.PureWhite
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.SubtleGray
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextSlate600
import com.example.ui.theme.TextSlate800

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun NewspaperWebExplorerScreen(
    newspaper: Newspaper,
    isFavorite: Boolean = false,
    onBack: () -> Unit,
    onFavoriteToggle: () -> Unit = {},
    onShowDetails: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var webViewInstance by remember { mutableStateOf<WebView?>(null) }
    var currentUrl by remember { mutableStateOf(newspaper.websiteUrl) }
    var pageTitle by remember { mutableStateOf(newspaper.nameBangla) }
    var progress by remember { mutableFloatStateOf(0.1f) }
    var isLoading by remember { mutableStateOf(true) }
    var hasError by remember { mutableStateOf(false) }
    var canGoBack by remember { mutableStateOf(false) }
    var canGoForward by remember { mutableStateOf(false) }

    val brandColor = Color(newspaper.primaryColorHex)

    // Back handler: Navigate back inside web view if history exists, otherwise exit screen
    BackHandler {
        if (webViewInstance?.canGoBack() == true) {
            webViewInstance?.goBack()
        } else {
            onBack()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            webViewInstance?.stopLoading()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PureWhite)
            .statusBarsPadding()
            .testTag("newspaper_web_explorer_screen")
    ) {
        // --- Top Bar: Navigation & Website Info ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Close / Back button
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(SubtleGray)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "বন্ধ করুন",
                    tint = TextSlate800,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Newspaper Branding Badge & Title
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(brandColor.copy(alpha = 0.12f))
                    .border(1.dp, brandColor.copy(alpha = 0.25f), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = newspaper.logoText.take(2),
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = brandColor
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = newspaper.nameBangla,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    ),
                    color = TextSlate800,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "নিরাপদ সংযোগ",
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(11.dp)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = currentUrl.removePrefix("https://").removePrefix("http://").removePrefix("www."),
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.5.sp),
                        color = TextSlate600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Quick Actions: Favorite, Share, Open in Browser
            IconButton(
                onClick = onFavoriteToggle,
                modifier = Modifier.size(34.dp)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "পছন্দের তালিকা",
                    tint = if (isFavorite) RedPrimary else TextMuted,
                    modifier = Modifier.size(20.dp)
                )
            }

            IconButton(
                onClick = {
                    try {
                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_SUBJECT, newspaper.nameBangla)
                            putExtra(Intent.EXTRA_TEXT, "${newspaper.nameBangla}\n$currentUrl")
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "শেয়ার করুন"))
                    } catch (e: Exception) {
                        // ignore
                    }
                },
                modifier = Modifier.size(34.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "শেয়ার করুন",
                    tint = TextSlate800,
                    modifier = Modifier.size(18.dp)
                )
            }

            IconButton(
                onClick = {
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(currentUrl))
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        // ignore
                    }
                },
                modifier = Modifier.size(34.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.OpenInBrowser,
                    contentDescription = "ব্রাউজারে খুলুন",
                    tint = TextSlate800,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        // Web Loading Progress Bar
        AnimatedVisibility(
            visible = isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp),
                color = RedPrimary,
                trackColor = SubtleGray
            )
        }

        // --- Main Web View or Error State ---
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            AndroidView(
                factory = { ctx ->
                    WebView(ctx).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )

                        settings.apply {
                            javaScriptEnabled = true
                            domStorageEnabled = true
                            loadWithOverviewMode = true
                            useWideViewPort = true
                            builtInZoomControls = true
                            displayZoomControls = false
                            setSupportZoom(true)
                            cacheMode = WebSettings.LOAD_DEFAULT
                            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                            userAgentString = settings.userAgentString + " AllBanglaNewsApp/1.0"
                        }

                        webViewClient = object : WebViewClient() {
                            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                                super.onPageStarted(view, url, favicon)
                                isLoading = true
                                hasError = false
                                url?.let { currentUrl = it }
                                canGoBack = view?.canGoBack() == true
                                canGoForward = view?.canGoForward() == true
                            }

                            override fun onPageFinished(view: WebView?, url: String?) {
                                super.onPageFinished(view, url)
                                isLoading = false
                                url?.let { currentUrl = it }
                                pageTitle = view?.title ?: newspaper.nameBangla
                                canGoBack = view?.canGoBack() == true
                                canGoForward = view?.canGoForward() == true
                            }

                            override fun onReceivedError(
                                view: WebView?,
                                request: WebResourceRequest?,
                                error: WebResourceError?
                            ) {
                                super.onReceivedError(view, request, error)
                                if (request?.isForMainFrame == true) {
                                    hasError = true
                                    isLoading = false
                                }
                            }

                            override fun shouldOverrideUrlLoading(
                                view: WebView?,
                                request: WebResourceRequest?
                            ): Boolean {
                                val url = request?.url?.toString() ?: return false
                                return if (url.startsWith("http://") || url.startsWith("https://")) {
                                    false
                                } else {
                                    try {
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                        context.startActivity(intent)
                                        true
                                    } catch (e: Exception) {
                                        true
                                    }
                                }
                            }
                        }

                        webChromeClient = object : WebChromeClient() {
                            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                                progress = (newProgress / 100f).coerceIn(0.05f, 1f)
                                if (newProgress >= 100) {
                                    isLoading = false
                                }
                                canGoBack = view?.canGoBack() == true
                                canGoForward = view?.canGoForward() == true
                            }

                            override fun onReceivedTitle(view: WebView?, title: String?) {
                                super.onReceivedTitle(view, title)
                                if (!title.isNullOrBlank()) {
                                    pageTitle = title
                                }
                            }
                        }

                        loadUrl(newspaper.websiteUrl)
                        webViewInstance = this
                    }
                },
                modifier = Modifier.fillMaxSize()
            )

            // Error Overlay with Retry and External Browser Fallback
            if (hasError) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(PureWhite)
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "🌐",
                            fontSize = 42.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "সংযুক্ত হতে সমস্যা হচ্ছে",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = TextSlate800
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "${newspaper.nameBangla} ওয়েবসাইটে সংযোগ স্থাপন করা যাচ্ছে না। আপনার ইন্টারনেট সংযোগ পরীক্ষা করুন।",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSlate600,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Button(
                                onClick = {
                                    hasError = false
                                    isLoading = true
                                    webViewInstance?.reload()
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = RedPrimary)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Refresh,
                                    contentDescription = null,
                                    tint = PureWhite,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("পুনরায় চেষ্টা করুন", color = PureWhite, fontSize = 13.sp)
                            }

                            Button(
                                onClick = {
                                    try {
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newspaper.websiteUrl))
                                        context.startActivity(intent)
                                    } catch (e: Exception) {
                                        // ignore
                                    }
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = SubtleGray)
                            ) {
                                Text("ব্রাউজারে খুলুন", color = TextSlate800, fontSize = 13.sp)
                            }
                        }
                    }
                }
            }
        }

        // --- Bottom Browser Control Toolbar ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(PureWhite)
                .border(width = 1.dp, color = BorderLight)
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Web Back
            IconButton(
                onClick = { webViewInstance?.goBack() },
                enabled = canGoBack,
                modifier = Modifier.size(38.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "পূর্ববর্তী পৃষ্ঠা",
                    tint = if (canGoBack) TextSlate800 else TextMuted,
                    modifier = Modifier.size(20.dp)
                )
            }

            // Web Forward
            IconButton(
                onClick = { webViewInstance?.goForward() },
                enabled = canGoForward,
                modifier = Modifier.size(38.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "পরবর্তী পৃষ্ঠা",
                    tint = if (canGoForward) TextSlate800 else TextMuted,
                    modifier = Modifier.size(20.dp)
                )
            }

            // Reload / Refresh
            IconButton(
                onClick = {
                    isLoading = true
                    webViewInstance?.reload()
                },
                modifier = Modifier.size(38.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "রিলোড করুন",
                    tint = TextSlate800,
                    modifier = Modifier.size(20.dp)
                )
            }

            // Return to Newspaper Home URL
            IconButton(
                onClick = {
                    isLoading = true
                    webViewInstance?.loadUrl(newspaper.websiteUrl)
                },
                modifier = Modifier.size(38.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "মূল পাতা",
                    tint = TextSlate800,
                    modifier = Modifier.size(20.dp)
                )
            }

            // View Newspaper Details
            IconButton(
                onClick = onShowDetails,
                modifier = Modifier.size(38.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "পত্রিকার তথ্য",
                    tint = RedPrimary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
