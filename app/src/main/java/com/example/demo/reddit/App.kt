package com.example.demo.reddit

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.demo.reddit.di.components.ApplicationComponent
import com.example.demo.reddit.di.components.DaggerApplicationComponent
import com.example.demo.reddit.di.modules.ApplicationModule
import com.example.demo.reddit.di.modules.CacheModule
import com.example.demo.reddit.di.modules.DbModule
import com.example.demo.reddit.di.modules.NetworkModule

class App : Application(), LifecycleObserver {

    val applicationComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .cacheModule(CacheModule(this))
            .networkModule(NetworkModule(this))
            .dbModule(DbModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }
}