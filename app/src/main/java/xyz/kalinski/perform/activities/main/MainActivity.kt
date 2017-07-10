package xyz.kalinski.perform.activities.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import xyz.kalinski.perform.R
import xyz.kalinski.perform.activities.main.fragments.news.NewsFragment
import xyz.kalinski.perform.bases.BaseActivity
import xyz.kalinski.perform.utils.replaceIfEmpty


class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseActivity(), IMainView {

    private var presenter: IMainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        initToolbar()
        initFragment()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun initFragment() {
        replaceIfEmpty(R.id.fragment) {
            NewsFragment.newInstance()
        }
        supportFragmentManager.beginTransaction().add(R.id.fragment, NewsFragment.newInstance()).commit()

    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }
}
