package com.example.demo.reddit.ui.main.home

import android.view.View
import com.example.demo.reddit.data.remote.models.Child
import com.example.demo.reddit.domain.*
import com.example.demo.reddit.events.BackPressEvent
import com.example.demo.reddit.extensions.applySchedulers
import com.example.demo.reddit.models.ApplicationState
import com.example.demo.reddit.ui.base.BasePresenter
import com.example.demo.reddit.utils.RxBus
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val fetchRedditPostUseCase: FetchRedditPostUseCase,
    private val fetchPostPositionUseCase: FetchPostPositionUseCase,
    private val votePostUseCase: VotePostUseCase,
    private val fetchRedditPostUpdatesUseCase: FetchRedditPostUpdatesUseCase,
    private val applicationState: ApplicationState,
    private val rxBus: RxBus,
    private val getRedditPostUseCase: GetRedditPostUseCase,
    private val saveSubRedditPostUseCase: SaveSubRedditPostUseCase
) :
    BasePresenter<HomeContract.View>(), HomeContract.Presenter {

    @Inject
    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
        loadRedditPost()
        listenToRedditPost()
        listenToBackPressEvent()
    }

    private fun loadRedditPost() {
        disposables?.add(
            fetchRedditPostUseCase.execute(Unit)
                .applySchedulers()
                .subscribe({
                    getView()?.showPostItems(it.children)
                }, {
                })
        )
    }

    private fun listenToRedditPost() {
        disposables?.add(
            fetchRedditPostUpdatesUseCase.execute(Unit).listen()
                .applySchedulers()
                .subscribe({
                    getView()?.showPostItems(it.children)


                },
                    {
                })
        )
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

    override fun onItemClicked(post: Child) {
        applicationState.currentSubRedditUrl = post.data?.url
        applicationState.currentPost = post.data
        getView()?.navigateToSubReddit()
    }

    override fun onSearchButtonClicked(text: String) {
        if (text.isNotEmpty()) {
            val searchText = " r/$text"
            applicationState.currentSubRedditUrl = searchText
            disposables?.add(getRedditPostUseCase.execute(searchText)
                .map { saveSubRedditPostUseCase.execute(it) }
                .applySchedulers()
                .subscribe({
                    getView()?.navigateToSubReddit()
                }, {
                    getView()?.showError(it.message)
                })
            )
        } else {

        }

    }

    private fun listenToBackPressEvent() {
        disposables?.add(
            rxBus.listen(BackPressEvent::class.java)
                .applySchedulers()
                .subscribe({
                    getView()?.updateViewWhenBackPress()
                }, {})
        )
    }
}