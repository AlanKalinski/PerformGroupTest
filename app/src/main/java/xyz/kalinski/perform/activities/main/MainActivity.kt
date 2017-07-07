package xyz.kalinski.perform.activities.main

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sample.*
import xyz.kalinski.perform.R
import xyz.kalinski.perform.bases.BaseActivity


class MainActivity(override val layoutId: Int = R.layout.activity_sample) : BaseActivity(), IMainView {

    private var presenter: IMainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
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
