package xyz.kalinski.perform.activities.main.fragments.scores

import xyz.kalinski.perform.view.ViewType
import java.util.*

interface IScoresPresenter {
    interface RequesterListener {
        fun onItemsReceived()
        fun onError()
    }

    fun initView(view: IScoresView)
    fun initRequester(requester: ScoresRequester)
    fun getScores()
    fun getList(): ArrayList<ViewType>
    fun onDestroy()

}