package xyz.kalinski.perform.activities.sample

internal interface SampleInteractor {
    interface OnDoSomethingListener {
        fun onStart()

        fun onError()

        fun onFinished()
    }

    fun doSomething(listener: OnDoSomethingListener)
}
