package xyz.kalinski.perform.activities.main.fragments.standings

import xyz.kalinski.perform.models.response.Ranking
import xyz.kalinski.perform.models.response.ResponseXml

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