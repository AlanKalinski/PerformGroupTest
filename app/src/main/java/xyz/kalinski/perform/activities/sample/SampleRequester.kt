package xyz.kalinski.perform.activities.sample

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import xyz.kalinski.perform.network.PromotedRestApi
import javax.inject.Inject

class SampleRequester @Inject constructor(restApi: PromotedRestApi) {

    val api: PromotedRestApi = restApi

    fun getPromoted() {
        api.getPromoted()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            promoted ->
                            Timber.e(String.format("Promoted result: %s", promoted.toString()))
                        },
                        {
                            error ->
                            Timber.e("Get Promoted Error")
                        }
                )
    }
}