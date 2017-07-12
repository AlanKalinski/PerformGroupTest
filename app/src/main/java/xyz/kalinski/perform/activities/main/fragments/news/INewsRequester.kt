package xyz.kalinski.perform.activities.main.fragments.news

interface INewsRequester {
    fun getLatestNews(listener: INewsPresenter.RequesterListener)
    fun dispose()
}