package com.example.demo.reddit.ui.signin

import com.example.demo.reddit.domain.*
import com.example.demo.reddit.extensions.applySchedulers
import com.example.demo.reddit.ui.base.BasePresenter
import javax.inject.Inject

class SignInPresenter @Inject constructor(
    private val getRedditPostUseCase: GetRedditPostUseCase,
    private val setAccessTokenUseCase: SetAccessTokenUseCase,
    private val addAuthenticationInHeaderUseCase: AddAuthenticationInHeaderUseCase,
    private val fetchRedditPostUpdatesUseCase: FetchRedditPostUpdatesUseCase,
    private val saveRedditPostToCacheUseCase: SaveRedditPostToCacheUseCase
) : BasePresenter<SignInContract.View>(), SignInContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUi()
        listenToRedditPost()
    }

    private fun listenToRedditPost() {
        disposables?.add(
            fetchRedditPostUpdatesUseCase.execute(Unit).listen()
                .applySchedulers()
                .subscribe({
                    println(it)
                }, {

                })
        )
    }

    override fun onSignInButtonClicked(pair: Pair<String?, String?>) {
        disposables?.add(
            addAuthenticationInHeaderUseCase.execute(pair)
                .map { setAccessTokenUseCase.execute(Unit) }
                .map { getRedditPostUseCase.execute(POPULAR_POST_URL) }
                .map { saveRedditPostToCacheUseCase.execute(it.blockingGet()) }
                .applySchedulers()
                .subscribe({
                    getView()?.successfullySignedIn()
                }, {
                    getView()?.showSignInError(it.message)
                })
        )
    }

    companion object {
        const val POPULAR_POST_URL = "subreddits/popular"
    }
}