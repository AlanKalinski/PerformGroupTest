package xyz.kalinski.perform.network

import io.reactivex.Observable
import xyz.kalinski.perform.models.response.NewsRss
import xyz.kalinski.perform.models.response.ResponseXml

interface IPerformApi {
    fun getLatestNews(): Observable<NewsRss>
    fun getScores(): Observable<ResponseXml>
    fun getStandings(): Observable<ResponseXml>
}