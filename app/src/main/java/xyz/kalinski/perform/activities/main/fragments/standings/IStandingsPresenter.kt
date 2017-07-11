package xyz.kalinski.perform.activities.main.fragments.standings

import xyz.kalinski.perform.network.models.Ranking
import xyz.kalinski.perform.network.models.ResponseXml

interface IStandingsPresenter {
    interface RequesterListener {
        fun onItemsReceived(xml: ResponseXml)
        fun onError()
    }

    fun initView(view: IStandingsView)
    fun initRequester(requester: StandingsRequester)
    fun getStandings()
    fun getList(): ArrayList<Ranking>?
    fun onDestroy()
}