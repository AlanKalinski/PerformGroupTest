package xyz.kalinski.perform.activities.main

import android.os.Handler

internal class MainInteractor : IMainInteractor {

    override fun doSomething(listener: IMainInteractor.OnDoSomethingListener) {
        listener.onStart()

        Handler().postDelayed({ listener.onError() }, 6000)
    }
}
