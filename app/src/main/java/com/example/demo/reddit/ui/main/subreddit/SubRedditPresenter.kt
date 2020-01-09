package com.example.demo.reddit.ui.main.subreddit

import com.example.demo.reddit.data.remote.models.Child
import com.example.demo.reddit.domain.*
import com.example.demo.reddit.events.BackPressEvent
import com.example.demo.reddit.extensions.applySchedulers
import com.example.demo.reddit.models.ApplicationState
import com.example.demo.reddit.ui.base.BasePresenter
import com.example.demo.reddit.utils.RxBus
import javax.inject.Inject

class SubRedditPresenter @Inject constructor(
    private val applicationState: ApplicationState,
    private val getRedditPostUseCase: GetRedditPostUseCase,
    private val fetchPostPositionUseCase: FetchPostPositionUseCase,
    private val votePostUseCase: VotePostUseCase,
    private val saveSubRedditPostUseCase: SaveSubRedditPostUseCase,
    private val fetchSubRedditPostUpdatesUseCase: FetchSubRedditPostUpdatesUseCase,
    private val rxBus: RxBus
) :
    BasePresenter<SubRedditContract.View>(), SubRedditContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
        loadSubReddit()
        listenToRedditPost()
        getView()?.updateView(applicationState.currentPost)
    }

    private fun loadSubReddit() {
        disposables?.add(
            getRedditPostUseCase.execute(
                applicationState.currentSubRedditUrl ?: ""
            )
                .map {
                    saveSubRedditPostUseCase.execute(it) }
                .applySchedulers()
                .subscribe({
                }, {})
        )
    }

    private fun listenToRedditPost() {
        disposables?.add(
            fetchSubRedditPostUpdatesUseCase.execute(Unit).listen()
                .applySchedulers()
                .subscribe({
                    getView()?.showSubRedditPostItems(it.children)
                }, {

                })
        )
    }

    override fun publishBackPress() {
        rxBus.publish(BackPressEvent())
    }

    override fun onItemClicked(child: Child) {

    }

    override fun onVoteIconClicked(pair: Pair<Int, Child>) {
        val id = pair.second.data?.id ?: ""
        disposables?.add(fetchPostPositionUseCase.execute(id)
            .map { votePostUseCase.execute(pair) }
            .applySchedulers()
            .subscribe({
            }, {
            })
        )
    }
}