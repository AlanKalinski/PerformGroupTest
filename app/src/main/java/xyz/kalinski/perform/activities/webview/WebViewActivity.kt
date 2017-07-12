package xyz.kalinski.perform.activities.webview

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_webview.*
import xyz.kalinski.perform.R
import xyz.kalinski.perform.activities.main.fragments.news.NewsFragment
import xyz.kalinski.perform.bases.BaseActivity
import xyz.kalinski.perform.models.response.Item


class WebViewActivity(override val layoutId: Int = R.layout.activity_webview) : BaseActivity() {

    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBundle()
        setTitleWithBackButton(if (item.title == null) "News" else item.title!!)
        loadPage()
    }

    private fun getBundle() {
        item = intent.getSerializableExtra(NewsFragment.NEWS_INTENT) as Item
    }

    private fun loadPage() {
        val url = item.link

        val settings = webview.settings
        settings.javaScriptEnabled = true

        webview.loadUrl(url)
    }
}