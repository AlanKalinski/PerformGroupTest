package xyz.kalinski.perform.activities.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import xyz.kalinski.perform.R
import xyz.kalinski.perform.activities.main.fragments.news.NewsFragment
import xyz.kalinski.perform.bases.BaseActivity
import xyz.kalinski.perform.bases.BaseFragment
import xyz.kalinski.perform.utils.replaceIfEmpty


class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseActivity(), IMainView {

    private lateinit var selectedFragment: BaseFragment
    private var presenter: IMainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        initFragment()
    }

    override fun onResume() {
        initToolbar()
        super.onResume()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun initFragment() {
        selectedFragment = replaceIfEmpty(R.id.fragment) {
            NewsFragment.newInstance()
        }
        selectedFragment.setMainView(this)
    }

    override fun changeTitle(title: Int) {
        this.title = getString(title)
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }
}
