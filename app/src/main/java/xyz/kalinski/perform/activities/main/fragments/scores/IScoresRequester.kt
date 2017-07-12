package xyz.kalinski.perform.activities.main.fragments.scores

interface IScoresRequester {
    fun getScores(listener: IScoresPresenter.RequesterListener)
    fun dispose()
}