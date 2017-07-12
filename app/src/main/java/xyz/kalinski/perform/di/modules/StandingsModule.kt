package xyz.kalinski.perform.di.modules

import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.activities.main.fragments.standings.IStandingsPresenter
import xyz.kalinski.perform.activities.main.fragments.standings.StandingsPresenter
import xyz.kalinski.perform.activities.main.fragments.standings.StandingsRequester
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Singleton

@Module
class StandingsModule {

    @Provides
    @Singleton
    fun provideRequester(api: PerformApi): StandingsRequester = StandingsRequester(api)

    @Provides
    @Singleton
    fun providePresenter(requester: StandingsRequester): IStandingsPresenter = StandingsPresenter(requester)
}

