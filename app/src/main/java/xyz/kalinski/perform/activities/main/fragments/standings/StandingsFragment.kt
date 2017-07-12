package xyz.kalinski.perform.activities.main.fragments.standings

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_with_recycler.*
import xyz.kalinski.perform.PerformApplication
import xyz.kalinski.perform.R
import xyz.kalinski.perform.activities.main.IMainView
import xyz.kalinski.perform.activities.main.fragments.standings.adapter.StandingsAdapter
import xyz.kalinski.perform.bases.BaseFragment
import xyz.kalinski.perform.utils.snack
import javax.inject.Inject

class StandingsFragment : BaseFragment(), IStandingsView {

    @Inject lateinit var presenter: IStandingsPresenter
    @Inject lateinit var requester: StandingsRequester

    lateinit var iMainView: IMainView

    override fun setMainView(view: IMainView) {
        iMainView = view
    }

    companion object {
        fun newInstance() = StandingsFragment()
        fun getName(): Int = R.string.standings_fragment_title
    }

    private val standingsList by lazy {
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PerformApplication.standingsComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_with_recycler, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initView() {
        initAdapter()
        initSwipeToRefresh()
        presenter.initView(this)
        presenter.initRequester(requester)
        requestForItems()
    }

    private fun initSwipeToRefresh() {
        swiperefresh.setOnRefreshListener { requestForItems() }
    }

    override fun requestForItems() {
        swiperefresh.isRefreshing = false
        showProgressBar()
        presenter.getStandings()
    }

    private fun initAdapter() {
        presenter.getList()?.let {
            if (standingsList.adapter == null) {
                standingsList.adapter = StandingsAdapter(presenter.getList()!!)
            } else {
                (standingsList.adapter as StandingsAdapter).items = presenter.getList()!!
            }
        }
    }

    override fun notifyUpdate() {
        initAdapter()
        standingsList.adapter.notifyDataSetChanged()
    }

    override fun showProgressBar() {
        swiperefresh.isRefreshing = true
    }

    override fun hideProgressBar() {
        swiperefresh.isRefreshing = false
    }

    override fun showError() {
        hideProgressBar()
        swiperefresh.snack(messageRes = R.string.error_message, length = Snackbar.LENGTH_LONG, f = {
            requestForItems()
            dismiss()
        })
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}