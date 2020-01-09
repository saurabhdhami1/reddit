package com.example.demo.reddit.ui.main.subreddit

import com.example.demo.reddit.data.remote.models.Child
import com.example.demo.reddit.data.remote.models.PostData
import com.example.demo.reddit.ui.base.BaseContract

interface SubRedditContract {

    interface View : BaseContract.View {
        fun initUI()
        fun showSubRedditPostItems(children: List<Child>?)
        fun updateView(currentPost: PostData?)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onItemClicked(child: Child)
        fun onVoteIconClicked(pair: Pair<Int, Child>)
        fun publishBackPress()

    }
}