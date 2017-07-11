package xyz.kalinski.perform.activities.main.fragments.scores
import xyz.kalinski.perform.network.models.Match
import xyz.kalinski.perform.network.models.ResponseXml

interface IScoresPresenter {
    interface RequesterListener {
        fun onItemsReceived(xml: ResponseXml)
        fun onError()
    }

    fun initView(view: IScoresView)
    fun initRequester(requester: ScoresRequester)
    fun getScores()
    fun getList(): ArrayList<Match>
    fun onDestroy()

}