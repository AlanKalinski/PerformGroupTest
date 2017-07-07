package xyz.kalinski.perform.di.components

import dagger.Component
import xyz.kalinski.perform.PerformApplication
import xyz.kalinski.perform.di.modules.AppModule
import xyz.kalinski.perform.di.modules.DataModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf
(
        AppModule::class,
        DataModule::class
)
)
interface AppComponent {

    fun inject(app: PerformApplication)

}