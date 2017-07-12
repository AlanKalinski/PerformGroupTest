package xyz.kalinski.perform.activities.main.fragments.standings

import xyz.kalinski.perform.models.response.Ranking

interface IStandingsPresenter {
    interface RequesterListener {
        fun onItemsReceived()
        fun onError()
    }

    fun initView(view: IStandingsView)
    fun getStandings()
    fun getList(): ArrayList<Ranking>?
    fun onDestroy()
}