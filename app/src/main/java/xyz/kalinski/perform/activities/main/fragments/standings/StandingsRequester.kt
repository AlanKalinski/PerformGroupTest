package xyz.kalinski.perform.activities.main.fragments.standings

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import xyz.kalinski.perform.models.response.ResponseXml
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Inject

class StandingsRequester @Inject constructor(val api: PerformApi) {

    var request: Disposable? = null
    var xml: ResponseXml? = null

    fun getStandings(listener: IStandingsPresenter.RequesterListener) {
        request = api.getStandings()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            standings ->
                            xml = standings
                            listener.onItemsReceived()

                        },
                        {
                            error ->
                            listener.onError()
                        }
                )
    }

    fun dispose() {
        request?.dispose()
    }
}