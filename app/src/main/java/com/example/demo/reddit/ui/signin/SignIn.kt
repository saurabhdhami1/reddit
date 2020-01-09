package com.example.demo.reddit.ui.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.demo.reddit.R
import com.example.demo.reddit.ui.base.BaseActivity
import com.example.demo.reddit.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import javax.inject.Inject

class SignIn : BaseActivity<SignInContract.View, SignInContract.Presenter>(),
    SignInContract.View {

    @Inject
    lateinit var signInPresenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val username = emailFromUser?.text?.toString()
        val password = password?.text?.toString()
        signIn.setOnClickListener {
            val pair = Pair(username, password)
            presenter?.onSignInButtonClicked(pair)
        }
    }

    override fun initUi() {

    }

    override fun showSignInError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun successfullySignedIn() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }


    override fun initPresenter(): SignInContract.Presenter = signInPresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId(): Int = R.layout.activity_sign_in
}
