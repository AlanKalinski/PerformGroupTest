package xyz.kalinski.perform.activities.sample

internal interface SamplePresenter {
    fun onConnecting()

    fun onSomethingError()

    fun onDestroy()
}
