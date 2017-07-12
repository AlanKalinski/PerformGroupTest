package xyz.kalinski.perform.activities.main.fragments.standings

import xyz.kalinski.perform.models.response.Ranking
import javax.inject.Inject

class StandingsPresenter @Inject constructor(val requester: StandingsRequester) : IStandingsPresenter, IStandingsPresenter.RequesterListener {

    var view: IStandingsView? = null

    override fun initView(view: IStandingsView) {
        this.view = view
    }

    override fun getStandings() {
        requester.getStandings(this)
    }

    override fun getList(): ArrayList<Ranking>? {
        return requester.xml?.competition?.season?.round?.resultTable?.rankingList
    }

    override fun onDestroy() {
        view = null
        requester.dispose()
        requester.xml = null
    }

    override fun onItemsReceived() {
        view?.hideProgressBar()
        view?.notifyUpdate()
    }

    override fun onError() {
        view?.showError()
    }
}