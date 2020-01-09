package com.example.demo.reddit.ui.main

import com.example.demo.reddit.ui.base.BaseContract

interface MainContract {

    interface View : BaseContract.View {
        fun initUI()
    }

    interface Presenter : BaseContract.Presenter<View> {
    }
}