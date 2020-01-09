package com.example.demo.reddit.di.modules

import android.app.Application
import android.content.Context
import com.example.demo.reddit.models.ApplicationState
import com.example.demo.reddit.di.scope.ApplicationScope
import com.example.demo.reddit.utils.RxBus
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject

@Module
class ApplicationModule(private val application: Application) {

    @ApplicationScope
    @Provides
    fun providesApplicationContext(): Context = application.applicationContext

    @ApplicationScope
    @Provides
    fun providesApplicationScope() = ApplicationState()

    @ApplicationScope
    @Provides
    fun providerRxBus(publisher: PublishSubject<Any>) = RxBus(publisher)

    @ApplicationScope
    @Provides
    fun providerPublishSubject(): PublishSubject<Any> = PublishSubject.create<Any>()

}
