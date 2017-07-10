package xyz.kalinski.perform.activities.main.fragments.scores

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Inject

class ScoresRequester @Inject constructor(val api: PerformApi) {

    fun getScores() {
        api.getScores()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            scores ->
                            Timber.d(String.format("Scores result: %s", scores.toString()))
                        },
                        {
                            error ->
                            Timber.e(String.format("%s, ", error.toString()))
                        }
                )
    }
}