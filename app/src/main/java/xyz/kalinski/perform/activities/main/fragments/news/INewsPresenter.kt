package xyz.kalinski.perform.activities.main.fragments.news

interface INewsPresenter {
    fun getLatestNews()
    fun initRequester(requester: NewsRequester)
}