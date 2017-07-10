package xyz.kalinski.perform.activities.webview

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_webview.*
import xyz.kalinski.perform.R
import xyz.kalinski.perform.bases.BaseActivity


class WebViewActivity(override val layoutId: Int = R.layout.activity_webview) : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar)
        loadPage()
        super.onCreate(savedInstanceState)
    }

    private fun loadPage() {
        val url = intent.getStringExtra("URL")

        val settings = webView.settings
        settings.javaScriptEnabled = true

        webView.loadUrl(url)
    }
}