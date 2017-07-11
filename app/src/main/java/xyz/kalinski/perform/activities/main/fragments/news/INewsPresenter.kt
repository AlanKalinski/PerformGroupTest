package xyz.kalinski.perform.activities.main.fragments.news

import xyz.kalinski.perform.models.response.Item
import xyz.kalinski.perform.models.response.NewsRss

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