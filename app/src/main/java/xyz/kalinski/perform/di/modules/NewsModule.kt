package xyz.kalinski.perform.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.activities.main.fragments.news.INewsPresenter
import xyz.kalinski.perform.activities.main.fragments.news.NewsPresenter
import xyz.kalinski.perform.activities.main.fragments.news.NewsRequester
import javax.inject.Singleton
@Module
class NewsModule {

    @Provides
    @Singleton
    fun providePresenter(): INewsPresenter = NewsPresenter()
}

