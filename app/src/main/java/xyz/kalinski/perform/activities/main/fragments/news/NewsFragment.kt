package xyz.kalinski.perform.activities.main.fragments.news

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_news.*
import xyz.kalinski.perform.PerformApplication
import xyz.kalinski.perform.R
import xyz.kalinski.perform.activities.main.IMainView
import xyz.kalinski.perform.activities.main.fragments.news.adapter.NewsAdapter
import xyz.kalinski.perform.activities.webview.WebViewActivity
import xyz.kalinski.perform.bases.BaseFragment
import xyz.kalinski.perform.network.models.Item
import javax.inject.Inject

class NewsFragment : BaseFragment(), INewsView, (Item) -> Unit {

    @Inject lateinit var presenter: INewsPresenter
    @Inject lateinit var requester: NewsRequester
    lateinit var iMainView: IMainView

    companion object {
        fun newInstance() = NewsFragment()
    }

    private val newsList by lazy {
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView
    }

    override fun setMainView(view: IMainView) {
        iMainView = view
        iMainView.changeTitle(getName())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        PerformApplication.newsComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initView()
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun getName(): Int {
        return R.string.news_fragment_title
    }

    private fun initView() {
        initAdapter()
        presenter.initView(this)
        presenter.initRequester(requester)
        presenter.getLatestNews()
    }

    private fun initAdapter() {
        presenter.getNews()?.let {
            if (newsList.adapter == null) {
                newsList.adapter = NewsAdapter(presenter.getNews()!!, this)
            }
        }
    }

    override fun notifyUpdate() {
        initAdapter()
        newsList.adapter.notifyDataSetChanged()
    }

    override fun invoke(item: Item) {
        /*var intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("URL", item.link)
        startActivity(intent)*/
    }
}
