package xyz.kalinski.perform.bases

import android.support.v4.app.Fragment
import xyz.kalinski.perform.activities.main.IMainView

abstract class BaseFragment : Fragment() {

    abstract fun setMainView(view: IMainView)
}

