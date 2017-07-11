package xyz.kalinski.perform.activities.main.fragments.news

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_with_recycler.*
import kotlinx.android.synthetic.main.progressbar.*
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
        return inflater.inflate(R.layout.fragment_with_recycler, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getName(): Int {
        return R.string.news_fragment_title
    }

    private fun initView() {
        initAdapter()
        initSwipeToRefresh()
        presenter.initView(this)
        presenter.initRequester(requester)
        requestForItems()
    }

    private fun initSwipeToRefresh() {
        swiperefresh.setOnRefreshListener { requestForItems() }
    }


    override fun requestForItems() {
        swiperefresh.isRefreshing = false
        showProgressBar()
        presenter.getLatestNews()
    }

    private fun initAdapter() {
        presenter.getNews()?.let {
            if (newsList.adapter == null) {
                newsList.adapter = NewsAdapter(presenter.getNews()!!, this)
            } else {
                (newsList.adapter as NewsAdapter).items = presenter.getNews()!!
            }
        }
    }

    override fun notifyUpdate() {
        initAdapter()
        newsList.adapter.notifyDataSetChanged()
    }

    override fun invoke(item: Item) {
        val intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra("URL", item.link)
        startActivity(intent)
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
