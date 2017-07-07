package xyz.kalinski.perform.activities.main

internal interface IMainPresenter {
    fun onConnecting()

    fun onSomethingError()

    fun onDestroy()
}
