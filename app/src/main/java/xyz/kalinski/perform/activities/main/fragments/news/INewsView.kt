package xyz.kalinski.perform.activities.main.fragments.news

import xyz.kalinski.perform.network.models.NewsRss

interface INewsView {
    fun notifyUpdate()
    fun hideProgressBar()
    fun showProgressBar()
    fun requestForItems()
}