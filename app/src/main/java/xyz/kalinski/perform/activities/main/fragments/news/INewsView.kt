package xyz.kalinski.perform.activities.main.fragments.news

interface INewsView {
    fun notifyUpdate()
    fun hideProgressBar()
    fun showProgressBar()
    fun requestForItems()
    fun showError()
}