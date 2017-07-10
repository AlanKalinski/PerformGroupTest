package xyz.kalinski.perform.activities.main

internal class MainPresenter(private var view: IMainView?) : IMainPresenter {

    override fun onDestroy() {
        view = null
    }
}
