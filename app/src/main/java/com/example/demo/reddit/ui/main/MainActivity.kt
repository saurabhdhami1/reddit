package com.example.demo.reddit.ui.main

import android.os.Bundle
import android.view.View
import com.example.demo.reddit.R
import com.example.demo.reddit.ui.base.BaseActivity
import com.example.demo.reddit.ui.base.BaseFragment
import com.example.demo.reddit.ui.main.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.view.*
import javax.inject.Inject


class MainActivity : BaseActivity<MainContract.View, MainContract.Presenter>(),
    MainContract.View {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateToolBar(View.GONE, getString(R.string.popular))
    }

    override fun initUI() {
        val fragment = HomeFragment()
        val fragments = supportFragmentManager.fragments
        if (fragments.contains(supportFragmentManager.findFragmentByTag("HomeFragment"))) {
            return
        }
        supportFragmentManager
            .beginTransaction()
            .add(mainContainer.id, fragment, "HomeFragment")
            .addToBackStack("HomeFragment")
            .commit()
    }

    fun updateToolBar(visiblity: Int, toolbarText: String) {
        mainToolbar.menu.visibility = visiblity
        mainToolbar.toolbarHeading.text = toolbarText
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.fragments.last()
        val handled = (currentFragment as? BaseFragment<*, *>)?.onBackPressed() ?: false
        if (!handled){
            moveTaskToBack(true)
        }
    }

    override fun initPresenter() = mainPresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId(): Int = R.layout.activity_main

}
