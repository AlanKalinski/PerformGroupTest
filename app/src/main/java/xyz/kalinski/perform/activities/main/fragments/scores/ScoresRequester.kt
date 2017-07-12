package xyz.kalinski.perform.activities.main.fragments.scores

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import xyz.kalinski.perform.models.response.ResponseXml
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Inject

class ScoresRequester @Inject constructor(val api: PerformApi) : IScoresRequester {

    var request: Disposable? = null
    var xml: ResponseXml? = null

    override fun getScores(listener: IScoresPresenter.RequesterListener) {
        request = api.getScores()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            scores ->
                            xml = scores
                            listener.onItemsReceived()
                        },
                        {
                            error ->
                            listener.onError()
                        }
                )
    }

    override fun dispose() {
        request?.dispose()
    }
}