package xyz.kalinski.perform.activities.main.fragments.news

import xyz.kalinski.perform.models.response.Item
import javax.inject.Inject

class NewsPresenter @Inject constructor(val requester: NewsRequester) : INewsPresenter, INewsPresenter.RequesterListener {

    var view: INewsView? = null

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