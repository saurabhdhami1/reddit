package com.example.demo.reddit.ui.main.home

import com.example.demo.reddit.data.remote.models.Child
import com.example.demo.reddit.ui.base.BaseContract

interface HomeContract {

    interface View : BaseContract.View {
        fun initUI()
        fun showPostItems(children: List<Child>?)
        fun addItemToList(item: Child, position: Int)
        fun navigateToSubReddit()
        fun updateViewWhenBackPress()
        fun showError(message: String?)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onItemClicked(post: Child)
        fun onVoteIconClicked(pair: Pair<Int, Child>)
        fun onSearchButtonClicked(text: String)
    }
}