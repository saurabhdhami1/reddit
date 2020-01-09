package com.example.demo.reddit.ui.signin

import com.example.demo.reddit.ui.base.BaseContract

class SignInContract {

    interface View : BaseContract.View {
        fun  initUi()
        fun successfullySignedIn()
        fun showSignInError(message: String?)
    }

    interface Presenter : BaseContract.Presenter<View>{
        fun onSignInButtonClicked(pair: Pair<String?, String?>)

    }
}