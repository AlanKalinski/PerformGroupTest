package xyz.kalinski.perform.activities.main.fragments.news

import xyz.kalinski.perform.network.models.Item
import xyz.kalinski.perform.network.models.NewsRss

class NewsPresenter : INewsPresenter, INewsPresenter.RequesterListener {

    lateinit var requester: NewsRequester
    var view: INewsView? = null
    var newsRss: NewsRss? = null

    override fun initRequester(requester: NewsRequester) {
        this.requester = requester
    }

    override fun initView(view: INewsView) {
        this.view = view
    }

    override fun getLatestNews() {
        requester.getLatestNews(this)
    }

    override fun getNews(): ArrayList<Item>? {
        return newsRss?.channel?.items
    }

    override fun onItemsReceived(newsRss: NewsRss) {
        this.newsRss = newsRss
        view?.hideProgressBar()
        view?.notifyUpdate()
    }

    override fun onError() {
    }

    override fun onDestroy() {
        view = null
        newsRss = null
    }
}