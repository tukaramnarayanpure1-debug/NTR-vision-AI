package com.example.ui.components

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun HtmlContentViewer(
    htmlSnippet: String,
    title: String = "",
    isDarkMode: Boolean = isSystemInDarkTheme(),
    modifier: Modifier = Modifier
) {
    val bgColor = if (isDarkMode) "#0B0F19" else "#F8FAFC"
    val textColor = if (isDarkMode) "#F3F4F6" else "#0F172A"
    val cardBg = if (isDarkMode) "#111827" else "#FFFFFF"
    val borderColor = if (isDarkMode) "#1F2937" else "#E2E8F0"
    val accentColor = if (isDarkMode) "#38BDF8" else "#1D4ED8"

    val fullHtml = """
        <!DOCTYPE html>
        <html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0">
            <style>
                * { box-sizing: border-box; }
                body {
                    background-color: $bgColor;
                    color: $textColor;
                    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
                    line-height: 1.6;
                    padding: 16px;
                    margin: 0;
                }
                h1, h2, h3 { color: $accentColor; }
                .card {
                    background-color: $cardBg;
                    border: 1px solid $borderColor;
                    border-radius: 12px;
                    padding: 14px;
                    margin-bottom: 14px;
                    box-shadow: 0 2px 4px rgba(0,0,0,0.05);
                }
                table {
                    width: 100%;
                    border-collapse: collapse;
                    margin: 12px 0;
                }
                th, td {
                    border: 1px solid $borderColor;
                    padding: 8px 10px;
                    text-align: left;
                }
                th { background-color: ${if (isDarkMode) "#1F2937" else "#E2E8F0"}; }
                .badge {
                    display: inline-block;
                    background: $accentColor;
                    color: white;
                    padding: 4px 8px;
                    border-radius: 6px;
                    font-size: 12px;
                    font-weight: bold;
                }
                .formula-box {
                    background: ${if (isDarkMode) "#1e293b" else "#f1f5f9"};
                    border-left: 4px solid $accentColor;
                    padding: 10px;
                    font-family: monospace;
                    font-size: 14px;
                    margin: 10px 0;
                    border-radius: 4px;
                }
            </style>
        </head>
        <body>
            <div class="card">
                <span class="badge">NTR Vision AI • Global Study Sheet</span>
                <h2 style="margin-top:8px;">$title</h2>
                $htmlSnippet
            </div>
        </body>
        </html>
    """.trimIndent()

    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.builtInZoomControls = true
                settings.displayZoomControls = false
                setBackgroundColor(0)
            }
        },
        update = { webView ->
            webView.loadDataWithBaseURL(null, fullHtml, "text/html", "UTF-8", null)
        },
        modifier = modifier.fillMaxSize()
    )
}
