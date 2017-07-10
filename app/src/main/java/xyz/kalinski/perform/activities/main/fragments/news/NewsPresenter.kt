package xyz.kalinski.perform.activities.main.fragments.news

import xyz.kalinski.perform.network.models.Item
import xyz.kalinski.perform.network.models.NewsRss

class NewsPresenter : INewsPresenter, INewsPresenter.RequesterListener {

    lateinit var requester: NewsRequester
    lateinit var view: INewsView

    var newsRss: NewsRss? = null

    override fun initRequester(requester: NewsRequester) {
        this.requester = requester
    }

    override fun initView(view: INewsView){
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
        view.notifyUpdate()
    }

    override fun onError() {
    }
}