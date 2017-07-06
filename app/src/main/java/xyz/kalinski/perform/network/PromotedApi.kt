package xyz.kalinski.perform.network

import io.reactivex.Observable
import xyz.kalinski.perform.network.response.SampleApiResponse

interface PromotedApi {
    fun getPromoted(): Observable<SampleApiResponse>
}