package xyz.kalinski.perform.di.modules

import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.activities.main.fragments.standings.IStandingsPresenter
import xyz.kalinski.perform.activities.main.fragments.standings.StandingsPresenter
import javax.inject.Singleton

@Module
class StandingsModule {

    @Provides
    @Singleton
    fun providePresenter(): IStandingsPresenter = StandingsPresenter()
}

