package xyz.kalinski.perform.utils

import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import xyz.kalinski.perform.bases.BaseFragment

fun AppCompatActivity.replace(@IdRes id: Int,
                              provider: () -> BaseFragment): BaseFragment? {

    val fm = supportFragmentManager
    fm.beginTransaction()
            .replace(id, provider())
            .commit()

    return provider()
}