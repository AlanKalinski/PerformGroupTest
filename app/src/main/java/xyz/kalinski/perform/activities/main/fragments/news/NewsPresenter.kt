package xyz.kalinski.perform.activities.main.fragments.news

import xyz.kalinski.perform.models.response.Item

class NewsPresenter : INewsPresenter, INewsPresenter.RequesterListener {

    lateinit var requester: NewsRequester
    var view: INewsView? = null

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
        return requester.newsRss?.channel?.items
    }

    override fun onItemsReceived() {
        view?.hideProgressBar()
        view?.notifyUpdate()
    }

    override fun onError() {
        view?.showError()
    }

    override fun onDestroy() {
        view = null
        requester.dispose()
        requester.newsRss = null
    }
}