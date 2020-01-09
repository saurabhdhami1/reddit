package com.example.demo.reddit.di.modules

import android.app.Application
import com.example.demo.reddit.data.remote.interceptors.DeviceUrlInterceptor
import com.example.demo.reddit.data.remote.interceptors.HeaderInterceptor
import com.example.demo.reddit.data.remote.interceptors.RegistrationUrlInterceptor
import com.example.demo.reddit.data.remote.services.DeviceApiService
import com.example.demo.reddit.data.remote.services.RedditPostService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.example.demo.reddit.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named


@Module
class NetworkModule(private val application: Application) {

    companion object {
        const val CACHE_SIZE = 10 * 1024 * 1024L // 10 MiB
    }

    @ApplicationScope
    @Provides
    fun provideGson() = GsonBuilder().create()

    @ApplicationScope
    @Provides
    fun provideOkHttpCache() = Cache(application.cacheDir, CACHE_SIZE)


    @ApplicationScope
    @Provides
    fun provideHeadersInterceptor() = HeaderInterceptor()

    @ApplicationScope
    @Provides
    fun provideRegistrationUrlInterceptor() = RegistrationUrlInterceptor()

    @ApplicationScope
    @Provides
    fun provideDeviceUrlInterceptor() = DeviceUrlInterceptor()

    @ApplicationScope
    @Provides
    @Named("CommonOkHttpClient")
    fun provideOkHttpClient(cache: Cache, headerInterceptor: HeaderInterceptor,
                            registrationUrlInterceptor: RegistrationUrlInterceptor
    )
            = with(OkHttpClient.Builder()) {
        cache(cache)
        addInterceptor(headerInterceptor)
        addInterceptor(registrationUrlInterceptor)
        build()
    }

    @ApplicationScope
    @Provides
    @Named("DeviceRetrofit")
    fun provideDeviceRetrofit(gson: Gson, @Named("CommonOkHttpClient") okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://www.reddit.com/api/")
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @ApplicationScope
    @Provides
    fun provideDeviceApiService(@Named("DeviceRetrofit") retrofit: Retrofit) = retrofit.create(
        DeviceApiService::class.java)

    @ApplicationScope
    @Provides
    @Named("RedditOauthTokenRetrofit")
    fun provideRedditRetrofit(gson: Gson, @Named("CommonOkHttpClient") okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://oauth.reddit.com/")
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @ApplicationScope
    @Provides
    fun provideRedditApiService(@Named("RedditOauthTokenRetrofit") retrofit: Retrofit) = retrofit.create(
        RedditPostService::class.java)


}