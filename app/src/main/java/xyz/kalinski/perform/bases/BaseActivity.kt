package xyz.kalinski.perform.bases

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import xyz.kalinski.perform.R

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutId: Int
    protected val themeId = R.style.AppTheme

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(themeId)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}
