package xyz.kalinski.perform.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.kalinski.perform.network.response.SampleApiResponse

interface ApiClient {

    @GET("")
    fun getSample(@Query("token") token: String): Observable<SampleApiResponse>

}
