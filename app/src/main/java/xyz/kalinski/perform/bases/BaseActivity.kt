package xyz.kalinski.perform.bases

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import android.widget.TextView
import xyz.kalinski.perform.R

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutId: Int
    protected val themeId = R.style.AppTheme

    private var actionBar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(themeId)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initBar()
    }

    private fun initBar() {
        actionBar = supportActionBar
        actionBar?.elevation = 0f
    }

    protected fun setTitle(title: String): ActionBar? {
        actionBar.let {
            val textView = TextView(this)
            textView.text = title
            textView.textSize = resources.getDimension(R.dimen.standard_text_size)
            textView.gravity = Gravity.CENTER
            textView.setTextColor(ResourcesCompat.getColor(resources, android.R.color.white, null))
            actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            actionBar?.setCustomView(
                    textView,
                    ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                            ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER))
        }

        return actionBar
    }

    protected fun setTitleWithBackButton(title: String): ActionBar? {
        setTitle(title)?.setDisplayHomeAsUpEnabled(true)
        return actionBar
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return false
    }
}
