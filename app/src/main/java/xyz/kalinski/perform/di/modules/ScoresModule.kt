package xyz.kalinski.perform.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.activities.main.fragments.news.INewsPresenter
import xyz.kalinski.perform.activities.main.fragments.news.NewsPresenter
import xyz.kalinski.perform.activities.main.fragments.news.NewsRequester
import xyz.kalinski.perform.activities.main.fragments.scores.IScoresPresenter
import xyz.kalinski.perform.activities.main.fragments.scores.ScoresPresenter
import javax.inject.Singleton
@Module
class ScoresModule {

    @Provides
    @Singleton
    fun providePresenter(): IScoresPresenter = ScoresPresenter()
}

