package xyz.kalinski.perform.activities.main.fragments.news

import dagger.Module
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import xyz.kalinski.perform.models.response.NewsRss
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Inject

@Module
class NewsRequester @Inject constructor(val api: PerformApi) {

    var newsRss: NewsRss? = null
    var request: Disposable? = null

    fun getLatestNews(listener: INewsPresenter.RequesterListener) {
        request = api.getLatestNews()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            news ->
                            newsRss = news
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