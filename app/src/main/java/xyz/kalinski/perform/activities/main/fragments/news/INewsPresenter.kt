package xyz.kalinski.perform.activities.main.fragments.news

import xyz.kalinski.perform.network.models.Item
import xyz.kalinski.perform.network.models.NewsRss

interface INewsPresenter {
    interface RequesterListener {
        fun onItemsReceived(newsRss:NewsRss)
        fun onError()
    }
    fun getLatestNews()
    fun initRequester(requester: NewsRequester)
    fun initView(view: INewsView)
    fun getNews(): ArrayList<Item>?
    fun onDestroy()
}