package com.example.demo.reddit.di.modules

import android.app.Application
import android.content.Context
import com.example.demo.reddit.di.scope.ApplicationScope
import com.example.demo.reddit.utils.PrefManager
import dagger.Module
import dagger.Provides

@Module
class DbModule(private val application: Application) {

    @ApplicationScope
    @Provides
    fun sharedPreferences(context: Context) =
        context.getSharedPreferences("reddit", Context.MODE_PRIVATE)

}
