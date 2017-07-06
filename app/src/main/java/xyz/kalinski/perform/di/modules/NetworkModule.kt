package xyz.kalinski.perform.di.modules

import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import xyz.kalinski.perform.BuildConfig
import xyz.kalinski.perform.config.AppConfig
import javax.inject.Singleton

class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitXML(): Retrofit {
        val logging = HttpLoggingInterceptor()
                .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

        val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

        return Retrofit.Builder()
                .baseUrl(if (AppConfig.PRODUCTION) "" else "")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build()
    }
}