package com.example.demo.reddit.ui.main

import com.example.demo.reddit.domain.AddAuthenticationInHeaderUseCase
import com.example.demo.reddit.domain.SetAccessTokenUseCase
import com.example.demo.reddit.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val setAccessTokenUseCase: SetAccessTokenUseCase,
    private val addAuthenticationInHeaderUseCase: AddAuthenticationInHeaderUseCase
) :
    BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
    }


    override fun onDestroyed() {
        super.onDestroyed()
        disposables?.clear()
    }
}