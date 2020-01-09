package com.example.demo.reddit.ui.main.subreddit

import android.view.View
import com.bumptech.glide.Glide
import com.example.demo.reddit.R
import com.example.demo.reddit.data.remote.models.Child
import com.example.demo.reddit.data.remote.models.PostData
import com.example.demo.reddit.ui.base.BaseFragment
import com.example.demo.reddit.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sub_reddit_fragment.*
import kotlinx.android.synthetic.main.toolbar_main.view.*
import javax.inject.Inject

class SubRedditFragment : BaseFragment<SubRedditContract.View, SubRedditContract.Presenter>(),
    SubRedditContract.View {

    @Inject
    lateinit var subRedditPresenter: SubRedditPresenter
    private lateinit var subRedditPostAdapter: SubRedditPostAdapter

    override fun initUI() {
        subRedditPostAdapter = SubRedditPostAdapter({ presenter?.onItemClicked(it) },
            { presenter?.onVoteIconClicked(it) })
        subRedditRecyclerView.adapter = subRedditPostAdapter
        (activity as MainActivity).mainToolbar.menu.setOnClickListener {
            presenter?.publishBackPress()
            fragmentManager?.popBackStack()
        }
    }

    override fun showSubRedditPostItems(children: List<Child>?) {
        subRedditPostAdapter.postList = children?.toMutableList() ?: mutableListOf()
        subRedditPostAdapter.notifyDataSetChanged()
    }

    override fun updateView(currentPost: PostData?) {
        (activity as? MainActivity)?.updateToolBar(View.VISIBLE, currentPost?.url ?: "")
        Glide.with(this)
            .load(currentPost?.bannerImg)
            .into(contentImage)

        Glide.with(this)
            .load(currentPost?.iconImg)
            .into(subredditImage)

        subredditName.text = currentPost?.title
        subredditDescription.text = currentPost?.publicDescription
    }

    override fun onBackPressed(): Boolean {
        if (fragmentManager?.backStackEntryCount!! > 0) {
            presenter?.publishBackPress()
            fragmentManager?.popBackStack()
            return true
        }
        return false
    }
    override fun initPresenter() = subRedditPresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId(): Int = R.layout.sub_reddit_fragment
}