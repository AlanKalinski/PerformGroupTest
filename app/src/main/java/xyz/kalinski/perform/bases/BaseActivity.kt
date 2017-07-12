package xyz.kalinski.perform.bases

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import xyz.kalinski.perform.R

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutId: Int
    protected val themeId = R.style.AppTheme

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(themeId)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initBar()
    }

    private fun initBar() {
        supportActionBar?.elevation = 0f
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    protected fun setTitle(title: String) {
        supportActionBar?.title = title
    }

    protected fun setTitleWithBackButton(title: String) {
        setTitle(title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> consume { onBackPressed() }
        }
        return false
    }

    inline fun consume(f: () -> Unit): Boolean {
        f()
        return true
    }

}
