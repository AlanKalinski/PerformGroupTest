package xyz.kalinski.perform.di.modules

import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.activities.main.IMainPresenter
import xyz.kalinski.perform.activities.main.MainPresenter
import javax.inject.Singleton

@Module
class MainActivityModule {

    @Provides
    @Singleton
    fun providePresenter(): IMainPresenter = MainPresenter()
}

