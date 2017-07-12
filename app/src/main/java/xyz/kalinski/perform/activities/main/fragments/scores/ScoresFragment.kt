package xyz.kalinski.perform.activities.main.fragments.scores

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_with_recycler.*
import xyz.kalinski.perform.PerformApplication
import xyz.kalinski.perform.R
import xyz.kalinski.perform.activities.main.fragments.scores.adapter.ScoresAdapter
import xyz.kalinski.perform.bases.BaseFragment
import xyz.kalinski.perform.utils.snack
import javax.inject.Inject

class ScoresFragment : BaseFragment(), IScoresView {

    @Inject lateinit var presenter: IScoresPresenter
    @Inject lateinit var requester: ScoresRequester

    companion object {
        fun newInstance() = ScoresFragment()
        fun getName(): Int = R.string.scores_fragment_title
    }

    private val scoresList by lazy {
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PerformApplication.scoresComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_with_recycler, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        presenter.initView(this)
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initView() {
        initAdapter()
        initSwipeToRefresh()
        requestForItems()
    }

    private fun initSwipeToRefresh() {
        swiperefresh.setOnRefreshListener { requestForItems() }
    }

    override fun requestForItems() {
        swiperefresh.isRefreshing = false
        showProgressBar()
        presenter.getScores()
    }

    private fun initAdapter() {
        if (scoresList.adapter == null) {
            scoresList.adapter = ScoresAdapter(presenter.getList())
        } else {
            (scoresList.adapter as ScoresAdapter).items = presenter.getList()
        }
    }

    override fun notifyUpdate() {
        initAdapter()
        scoresList.adapter.notifyDataSetChanged()
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