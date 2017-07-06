package xyz.kalinski.perform.activities.sample

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sample.*
import xyz.kalinski.perform.PerformApplication
import xyz.kalinski.perform.R
import xyz.kalinski.perform.bases.BaseActivity

class SampleActivity(override val layoutId: Int = R.layout.activity_sample) : BaseActivity(), SampleView {

    private var presenter: SamplePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SamplePresenterImpl(this)
        btnConnect.setOnClickListener { presenter?.onConnecting() }
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showSomethingError() {
        errorText.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }
}
