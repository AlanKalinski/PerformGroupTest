package xyz.kalinski.perform.activities.main.fragments.scores

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import xyz.kalinski.perform.activities.main.fragments.news.IScoresView
import xyz.kalinski.perform.network.models.Match
import xyz.kalinski.perform.network.models.ResponseXml
import java.util.*
import java.util.concurrent.TimeUnit

class ScoresPresenter : IScoresPresenter, IScoresPresenter.RequesterListener {

    lateinit var requester: ScoresRequester

    var view: IScoresView? = null
    var xml: ResponseXml? = null
    var interval: Disposable? = null

    val REFRESH_INTERVAL = 30L

    override fun initView(view: IScoresView) {
        this.view = view
    }

    override fun initRequester(requester: ScoresRequester) {
        this.requester = requester
    }

    override fun getScores() {
        interval = Observable.interval(REFRESH_INTERVAL, TimeUnit.SECONDS)
                .startWith(0L)
                .subscribeOn(Schedulers.newThread())
                .subscribe({ requester.getScores(this) })
    }

    override fun getList(): ArrayList<Match> {
        val list = arrayListOf<Match>()

        xml?.competition?.season?.round?.groupList?.size ?: return list

        for (i in 0..xml!!.competition!!.season!!.round!!.groupList!!.size - 1)
            xml!!.competition!!.season!!.round!!.groupList!![i].matchList?.let { it1 -> list.addAll(it1) }

        return list
    }

    override fun onDestroy() {
        interval?.dispose()
        requester.dispose()
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