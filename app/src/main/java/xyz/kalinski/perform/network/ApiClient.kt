package xyz.kalinski.perform.network

import io.reactivex.Observable
import retrofit2.http.GET
import xyz.kalinski.perform.models.response.NewsRss
import xyz.kalinski.perform.models.response.ResponseXml

interface ApiClient {

    @GET("/utilities/interviews/techtest/latestnews.xml")
    fun getLatestNews(): Observable<NewsRss>

    @GET("/utilities/interviews/techtest/scores.xml")
    fun getScores(): Observable<ResponseXml>

    @GET("/utilities/interviews/techtest/standings.xml")
    fun getStandings(): Observable<ResponseXml>

}
