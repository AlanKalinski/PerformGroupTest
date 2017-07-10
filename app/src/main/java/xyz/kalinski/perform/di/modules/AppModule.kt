package xyz.kalinski.perform.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.PerformApplication
import javax.inject.Singleton

@Module
class AppModule(val app: PerformApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app

}