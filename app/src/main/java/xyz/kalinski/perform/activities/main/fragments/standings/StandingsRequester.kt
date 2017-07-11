package xyz.kalinski.perform.activities.main.fragments.standings

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import xyz.kalinski.perform.activities.main.fragments.scores.IScoresPresenter
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Inject

class StandingsRequester @Inject constructor(val api: PerformApi) {

    var request: Disposable? = null

    fun getStandings(listener: IScoresPresenter.RequesterListener) {
        request = api.getStandings()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            standings ->
                            listener.onItemsReceived(standings)

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