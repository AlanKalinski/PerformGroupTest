package xyz.kalinski.perform.activities.main.fragments.standings

interface IStandingsRequester {
    fun getStandings(listener: IStandingsPresenter.RequesterListener)
    fun dispose()
}