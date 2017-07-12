package xyz.kalinski.perform.di.modules

import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.activities.main.fragments.scores.IScoresPresenter
import xyz.kalinski.perform.activities.main.fragments.scores.ScoresPresenter
import javax.inject.Singleton

@Module
class ScoresModule {

    @Provides
    @Singleton
    fun providePresenter(): IScoresPresenter = ScoresPresenter()
}

