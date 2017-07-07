package xyz.kalinski.perform.activities.main

internal interface IMainInteractor {
    interface OnDoSomethingListener {
        fun onStart()

        fun onError()

        fun onFinished()
    }

    fun doSomething(listener: OnDoSomethingListener)
}
