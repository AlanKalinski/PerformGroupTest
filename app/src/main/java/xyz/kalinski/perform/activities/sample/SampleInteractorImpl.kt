package xyz.kalinski.perform.activities.sample

import android.os.Handler

internal class SampleInteractorImpl : SampleInteractor {
    override fun doSomething(listener: SampleInteractor.OnDoSomethingListener) {
        listener.onStart()
        Handler().postDelayed({ listener.onError() }, 6000)
    }
}
