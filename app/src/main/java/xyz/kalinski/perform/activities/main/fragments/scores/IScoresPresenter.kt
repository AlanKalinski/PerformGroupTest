package xyz.kalinski.perform.activities.main.fragments.scores
import xyz.kalinski.perform.models.response.ResponseXml
import xyz.kalinski.perform.view.ViewType
import java.util.ArrayList

interface IScoresPresenter {
    interface RequesterListener {
        fun onItemsReceived(xml: ResponseXml)
        fun onError()
    }

    fun initView(view: IScoresView)
    fun initRequester(requester: ScoresRequester)
    fun getScores()
    fun getList(): ArrayList<ViewType>
    fun onDestroy()

}