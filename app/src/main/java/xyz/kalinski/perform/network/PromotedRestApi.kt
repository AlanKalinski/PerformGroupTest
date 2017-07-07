package xyz.kalinski.perform.network

import io.reactivex.Observable
import xyz.kalinski.perform.network.response.SampleApiResponse
import javax.inject.Inject

class PromotedRestApi @Inject constructor(private val service: ApiClient) : PromotedApi {

    override fun getPromoted(): Observable<SampleApiResponse> {
        return service.getSample("")
    }
}
