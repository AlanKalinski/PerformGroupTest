package xyz.kalinski.perform.activities.main.fragments.scores

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Inject

class ScoresRequester @Inject constructor(val api: PerformApi) {

    var request: Disposable? = null

    fun getScores(listener: IScoresPresenter.RequesterListener) {
        request = api.getScores()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            scores ->
                            listener.onItemsReceived(scores)
                        },
                        {
                            error ->
                            listener.onError()
                        }
                )
    }

    fun dispose(){
        request?.dispose()
    }
}