package xyz.kalinski.perform.activities.main.fragments.standings

interface IStandingsView {
    fun notifyUpdate()
    fun hideProgressBar()
    fun showProgressBar()
    fun requestForItems()
    fun showError()
}