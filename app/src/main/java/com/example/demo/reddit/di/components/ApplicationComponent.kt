package com.example.demo.reddit.di.components

import com.example.demo.reddit.di.modules.ApplicationModule
import com.example.demo.reddit.di.modules.CacheModule
import com.example.demo.reddit.di.modules.DbModule
import com.example.demo.reddit.di.modules.NetworkModule
import com.example.demo.reddit.di.scope.ApplicationScope
import com.example.demo.reddit.ui.main.MainActivity
import com.example.demo.reddit.ui.main.home.HomeFragment
import com.example.demo.reddit.ui.main.subreddit.SubRedditFragment
import com.example.demo.reddit.ui.signin.SignIn
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class, NetworkModule::class, CacheModule::class, DbModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: SignIn)
    fun inject(homeFragment: HomeFragment)
    fun inject(subRedditFragment: SubRedditFragment)

}
