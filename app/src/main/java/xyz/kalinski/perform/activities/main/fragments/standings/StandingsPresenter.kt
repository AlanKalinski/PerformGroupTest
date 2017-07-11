package xyz.kalinski.perform.activities.main.fragments.standings

import xyz.kalinski.perform.activities.main.fragments.scores.IScoresPresenter
import xyz.kalinski.perform.network.models.Ranking
import xyz.kalinski.perform.network.models.ResponseXml

class StandingsPresenter : IStandingsPresenter, IScoresPresenter.RequesterListener {

    lateinit var requester: StandingsRequester

    var view: IStandingsView? = null
    var xml: ResponseXml? = null

    override fun initView(view: IStandingsView) {
        this.view = view
    }

    override fun initRequester(requester: StandingsRequester) {
        this.requester = requester
    }

    override fun getStandings() {
        requester.getStandings(this)
    }

    override fun getList(): ArrayList<Ranking>? {
        return xml?.competition?.season?.round?.resultTable?.rankingList
    }

    override fun onDestroy() {
        requester.dispose()
        view = null
        xml = null
    }

    override fun onItemsReceived(xml: ResponseXml) {
        this.xml = xml
        view?.hideProgressBar()
        view?.notifyUpdate()
    }

    override fun onError() {
    }
}