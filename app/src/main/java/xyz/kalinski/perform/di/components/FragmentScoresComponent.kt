package xyz.kalinski.perform.di.components

import dagger.Component
import xyz.kalinski.perform.activities.main.fragments.scores.ScoresFragment
import xyz.kalinski.perform.di.modules.AppModule
import xyz.kalinski.perform.di.modules.NetworkModule
import xyz.kalinski.perform.di.modules.ScoresModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NetworkModule::class,
        ScoresModule::class
))
interface FragmentScoresComponent {
    fun inject(fragment: ScoresFragment)
}