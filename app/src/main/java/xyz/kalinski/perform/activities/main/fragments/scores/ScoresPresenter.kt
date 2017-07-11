package xyz.kalinski.perform.activities.main.fragments.scores

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import xyz.kalinski.perform.models.ScoreHeader
import xyz.kalinski.perform.models.response.ResponseXml
import xyz.kalinski.perform.view.ViewType
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

    override fun getList(): ArrayList<ViewType> {
        val list = arrayListOf<ViewType>()

        xml?.competition?.season?.round?.groupList?.size ?: return list

        val dateSet = hashSetOf<ScoreHeader>()

        for (i in 0..xml!!.competition!!.season!!.round!!.groupList!!.size - 1) {
            val group = xml!!.competition!!.season!!.round!!.groupList!![i]
            if (group.matchList != null) {
                for (item in group.matchList!!) {
                    if (item.dateUtc != null) dateSet.add(ScoreHeader(item.dateUtc!!))
                    list.add(item)
                }
            }
        }

        list.addAll(0, dateSet)
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
        view?.hideProgressBar()
        view?.notifyUpdate()
    }

    override fun onError() {
        view?.showError()
    }
}