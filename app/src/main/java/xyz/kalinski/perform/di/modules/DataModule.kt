package xyz.kalinski.perform.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import xyz.kalinski.perform.storage.SharedPrefs
import javax.inject.Singleton

@Module
class DataModule(val context: Context) {

    @Provides
    @Singleton
    fun provideSharedPrefs(): SharedPrefs = SharedPrefs(context)
}