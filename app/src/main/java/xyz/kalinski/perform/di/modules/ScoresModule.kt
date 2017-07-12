package xyz.kalinski.perform.di.modules

import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.activities.main.fragments.scores.IScoresPresenter
import xyz.kalinski.perform.activities.main.fragments.scores.ScoresPresenter
import xyz.kalinski.perform.activities.main.fragments.scores.ScoresRequester
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Singleton

@Module
class ScoresModule {

    @Provides
    @Singleton
    fun provideRequester(api: PerformApi): ScoresRequester = ScoresRequester(api)

    @Provides
    @Singleton
    fun providePresenter(requester: ScoresRequester): IScoresPresenter = ScoresPresenter(requester)
}

