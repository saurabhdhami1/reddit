package com.example.demo.reddit.ui.main.home

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.demo.reddit.R
import com.example.demo.reddit.data.remote.models.Child
import com.example.demo.reddit.ui.base.BaseFragment
import com.example.demo.reddit.ui.main.MainActivity
import com.example.demo.reddit.ui.main.subreddit.SubRedditFragment
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeContract.View, HomeContract.Presenter>(), HomeContract.View {

    @Inject
    lateinit var homePresenter: HomePresenter

    private lateinit var postAdapter: PostAdapter
    override fun initUI() {
        postAdapter = PostAdapter({ presenter?.onItemClicked(it) },
            { presenter?.onVoteIconClicked(it) })
        postRecyclerView.adapter = postAdapter

        searchImage.setOnClickListener {
            val text = searchEditText.text.toString()
            view?.hideKeyboard()
            presenter?.onSearchButtonClicked(text)

            home_progress.visibility = View.VISIBLE;

        }
    }

    override fun showError(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun showPostItems(children: List<Child>?) {
        home_progress.visibility = View.GONE;
        postAdapter.postList = children?.toMutableList() ?: mutableListOf()
        postAdapter.notifyDataSetChanged()
    }

    override fun addItemToList(item: Child, position: Int) {
        postAdapter.postList.add(item)
        postAdapter.notifyItemChanged(position)
    }

    override fun navigateToSubReddit() {
        container.visibility = View.VISIBLE
        postRecyclerView.visibility = View.GONE
        relLayout.visibility = View.GONE
        val fragment = SubRedditFragment()
        val fragments = childFragmentManager.fragments
        if (fragments.contains(childFragmentManager.findFragmentByTag("SubRedditFragment"))) {
            return
        }
        fragmentManager
            ?.beginTransaction()
            ?.replace(container.id, fragment, "SubRedditFragment")
            ?.addToBackStack("SubRedditFragment")
            ?.commit()
    }

    override fun updateViewWhenBackPress() {
        postRecyclerView.visibility = View.VISIBLE
        container.visibility = View.GONE
        relLayout.visibility = View.VISIBLE
        (activity as? MainActivity)?.updateToolBar(View.GONE, getString(R.string.popular))

    }

    private fun View.hideKeyboard() {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }

    override fun initPresenter(): HomeContract.Presenter = homePresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId(): Int = R.layout.home_fragment
}