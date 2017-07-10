package xyz.kalinski.perform.activities.main.fragments.news

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Inject

class NewsRequester @Inject constructor(val api: PerformApi) {

    fun getLatestNews() {
        api.getLatestNews()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            news ->
                            Timber.d(String.format("News result: %s", news.toString()))
                        },
                        {
                            error ->
                            Timber.e(String.format("%s, ", error.toString()))
                        }
                )
    }
}