package xyz.kalinski.perform

import android.app.Application
import android.content.Context
import timber.log.Timber
import xyz.kalinski.perform.di.components.AppComponent
import xyz.kalinski.perform.di.modules.AppModule

class PerformApplication : Application() {


    companion object {
        lateinit var newsComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                .build()
        setUpLogging()
    }

    private fun setUpLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
