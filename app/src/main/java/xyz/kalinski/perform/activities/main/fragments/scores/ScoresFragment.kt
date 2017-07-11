package xyz.kalinski.perform.activities.main.fragments.scores

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_news.*
import xyz.kalinski.perform.PerformApplication
import xyz.kalinski.perform.R
import xyz.kalinski.perform.activities.main.IMainView
import xyz.kalinski.perform.activities.main.fragments.news.IScoresView
import xyz.kalinski.perform.activities.main.fragments.scores.adapter.ScoresAdapter
import xyz.kalinski.perform.bases.BaseFragment
import javax.inject.Inject

class ScoresFragment : BaseFragment(), IScoresView {

    @Inject lateinit var presenter: IScoresPresenter
    @Inject lateinit var requester: ScoresRequester

    lateinit var iMainView: IMainView

    override fun setMainView(view: IMainView) {
        iMainView = view
        iMainView.changeTitle(getName())
    }

    companion object {
        fun newInstance() = ScoresFragment()
    }

    private val scoresList by lazy {
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView
    }


    override fun getName(): Int {
        return R.string.scores_fragment_title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PerformApplication.scoresComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initView() {
        initAdapter()
        presenter.initView(this)
        presenter.initRequester(requester)
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

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}