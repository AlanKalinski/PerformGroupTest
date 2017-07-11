package xyz.kalinski.perform.activities.main.fragments.scores

interface IScoresView {
    fun notifyUpdate()
    fun hideProgressBar()
    fun showProgressBar()
    fun requestForItems()
}