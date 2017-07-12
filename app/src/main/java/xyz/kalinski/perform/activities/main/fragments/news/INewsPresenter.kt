package xyz.kalinski.perform.activities.main.fragments.news

import xyz.kalinski.perform.models.response.Item

interface INewsPresenter {
    interface RequesterListener {
        fun onItemsReceived()
        fun onError()
    }

    fun getLatestNews()
    fun initRequester(requester: NewsRequester)
    fun initView(view: INewsView)
    fun getNews(): ArrayList<Item>?
    fun onDestroy()
}