package xyz.kalinski.perform.activities.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import xyz.kalinski.perform.R
import xyz.kalinski.perform.activities.main.fragments.news.NewsFragment
import xyz.kalinski.perform.activities.main.fragments.scores.ScoresFragment
import xyz.kalinski.perform.activities.main.fragments.standings.StandingsFragment
import xyz.kalinski.perform.bases.BaseActivity
import xyz.kalinski.perform.bases.BaseFragment
import xyz.kalinski.perform.utils.replace


class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseActivity(), IMainView {

    private lateinit var selectedFragment: BaseFragment
    private var presenter: IMainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        initFragment()
    }

    private fun initFragment() {
        selectedFragment = replace(R.id.fragment) {
            NewsFragment.newInstance()
        } as BaseFragment
        selectedFragment.setMainView(this)
    }

    override fun changeTitle(title: Int) {
        setTitle(getString(title))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.latest_news -> {
                if (selectedFragment != NewsFragment.newInstance()) {
                    replace(R.id.fragment) {
                        NewsFragment.newInstance()
                    }
                }
                return true
            }
            R.id.scores -> {
                if (selectedFragment != ScoresFragment.newInstance()) {
                    replace(R.id.fragment) {
                        ScoresFragment.newInstance()
                    }
                }
                return true
            }
            R.id.standing -> {
                if (selectedFragment != StandingsFragment.newInstance()) {
                    replace(R.id.fragment) {
                        StandingsFragment.newInstance()
                    }
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }
}
