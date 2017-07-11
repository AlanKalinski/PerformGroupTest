package xyz.kalinski.perform.activities.main.fragments.scores

import xyz.kalinski.perform.activities.main.fragments.news.IScoresView
import xyz.kalinski.perform.network.models.Match
import xyz.kalinski.perform.network.models.ResponseXml

class ScoresPresenter : IScoresPresenter, IScoresPresenter.RequesterListener {

    lateinit var requester: ScoresRequester
    var view: IScoresView? = null
    var xml: ResponseXml? = null

    override fun initView(view: IScoresView) {
        this.view = view
    }

    override fun initRequester(requester: ScoresRequester) {
        this.requester = requester
    }

    override fun getScores() {
        requester.getScores(this)
    }

    override fun getList(): ArrayList<Match> {
        var list = arrayListOf<Match>()

        xml?.competition?.season?.round?.groupList?.size ?: return list

        for (i in 0..xml!!.competition!!.season!!.round!!.groupList!!.size - 1)
            xml!!.competition!!.season!!.round!!.groupList!![i].matchList?.let { it1 -> list.addAll(it1) }

        return list
    }

    override fun onDestroy() {
        view = null
        xml = null
    }

    override fun onItemsReceived(xml: ResponseXml) {
        this.xml = xml
        view?.notifyUpdate()
    }

    override fun onError() {
    }
}