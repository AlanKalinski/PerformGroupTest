package xyz.kalinski.perform.activities.webview

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_webview.*
import xyz.kalinski.perform.R
import xyz.kalinski.perform.bases.BaseActivity


class WebViewActivity(override val layoutId: Int = R.layout.activity_webview) : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitleWithBackButton("WebView") //TODO
        loadPage()
    }

    private fun loadPage() {
        val url = intent.getStringExtra("URL")

        val settings = webview.settings
        settings.javaScriptEnabled = true

        webview.loadUrl(url)
    }
}