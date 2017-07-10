package xyz.kalinski.perform.activities.main.fragments.news

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Inject

class NewsRequester @Inject constructor(val api: PerformApi) {

    fun getLatestNews(listener: INewsPresenter.RequesterListener) {
        api.getLatestNews()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            news ->
                            listener.onItemsReceived(news)
                        },
                        {
                            error ->
                            listener.onError()
                        }
                )
    }
}