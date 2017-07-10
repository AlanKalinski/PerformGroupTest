package xyz.kalinski.perform.activities.main.fragments.standings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.kalinski.perform.PerformApplication
import xyz.kalinski.perform.R
import xyz.kalinski.perform.bases.BaseFragment
import javax.inject.Inject

class StandingsFragment : BaseFragment() {

    companion object {
        fun newInstance() = StandingsFragment()
    }

    @Inject lateinit var requester: StandingsRequester


    override fun getName(): String {
        return getString(R.string.scores_fragment_title)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PerformApplication.standingsComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initView()
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    private fun initView() {
    }
}