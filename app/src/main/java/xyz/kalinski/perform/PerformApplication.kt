package xyz.kalinski.perform

import android.app.Application
import timber.log.Timber
import xyz.kalinski.perform.di.components.*
import xyz.kalinski.perform.di.modules.AppModule

class PerformApplication : Application() {

    companion object {
        lateinit var newsComponent: FragmentNewsComponent
        lateinit var scoresComponent: FragmentScoresComponent
        lateinit var standingsComponent: FragmentStandingsComponent
    }

    override fun onCreate() {
        super.onCreate()
        setUpModules()
        setUpLogging()
    }

    private fun setUpModules() {
        newsComponent = DaggerFragmentNewsComponent.builder()
                .appModule(AppModule(this))
                .build()

        scoresComponent = DaggerFragmentScoresComponent.builder()
                .appModule(AppModule(this))
                .build()

        standingsComponent = DaggerFragmentStandingsComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    private fun setUpLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}