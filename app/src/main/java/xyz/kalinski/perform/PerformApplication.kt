package xyz.kalinski.perform

import android.app.Application
import timber.log.Timber
import xyz.kalinski.perform.di.components.AppComponent
import xyz.kalinski.perform.di.components.DaggerAppComponent
import xyz.kalinski.perform.di.modules.AppModule
import xyz.kalinski.perform.di.modules.DataModule

class PerformApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .dataModule(DataModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        setUpLogging()
    }

    private fun setUpLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}