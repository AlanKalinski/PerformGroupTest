package xyz.kalinski.perform.activities.main.fragments.standings

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Inject

class StandingsRequester @Inject constructor(val api: PerformApi) {

    fun getStandings() {
        api.getStandings()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            standings ->
                            Timber.d(String.format("Standings result: %s", standings.toString()))
                        },
                        {
                            error ->
                            Timber.e(String.format("%s, ", error.toString()))
                        }
                )
    }
}