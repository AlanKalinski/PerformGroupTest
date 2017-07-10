package xyz.kalinski.perform.bases

import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import xyz.kalinski.perform.activities.main.IMainView

abstract class BaseFragment : Fragment() {

    @StringRes abstract fun getName(): Int
    abstract fun setMainView(view: IMainView)
}

