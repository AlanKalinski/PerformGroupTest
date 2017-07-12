package xyz.kalinski.perform.di.modules

import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.activities.main.fragments.news.INewsPresenter
import xyz.kalinski.perform.activities.main.fragments.news.INewsRequester
import xyz.kalinski.perform.activities.main.fragments.news.NewsPresenter
import xyz.kalinski.perform.activities.main.fragments.news.NewsRequester
import xyz.kalinski.perform.network.PerformApi
import javax.inject.Singleton

@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideRequester(api: PerformApi): INewsRequester = NewsRequester(api)

    @Provides
    @Singleton
    fun providePresenter(requester: NewsRequester): INewsPresenter = NewsPresenter(requester)
}

