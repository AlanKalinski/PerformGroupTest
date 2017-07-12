package xyz.kalinski.perform.di.components

import dagger.Component
import xyz.kalinski.perform.activities.main.MainActivity
import xyz.kalinski.perform.di.modules.AppModule
import xyz.kalinski.perform.di.modules.MainActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        MainActivityModule::class
))
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}