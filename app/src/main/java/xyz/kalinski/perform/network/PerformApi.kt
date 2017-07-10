package xyz.kalinski.perform.network

import io.reactivex.Observable
import xyz.kalinski.perform.network.models.NewsRss
import xyz.kalinski.perform.network.models.ResponseXml
import javax.inject.Inject

class PerformApi @Inject constructor(private val service: ApiClient) : IPerformApi {
    override fun getScores(): Observable<ResponseXml> {
        return service.getScores()
    }

    override fun getStandings(): Observable<ResponseXml> {
        return service.getStandings()
    }

    override fun getLatestNews(): Observable<NewsRss> {
        return service.getLatestNews()
    }
}
