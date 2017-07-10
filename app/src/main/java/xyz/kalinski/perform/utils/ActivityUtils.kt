package xyz.kalinski.perform.utils

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.replaceIfEmpty(@IdRes id: Int,
                                     provider: () -> Fragment) {

    val fm = supportFragmentManager
    val fragment = fm.findFragmentById(id)
    if (fragment == null) {
        fm.beginTransaction()
                .replace(id, provider())
                .commit()

    }
}

fun AppCompatActivity.replace(@IdRes id: Int,
                              provider: () -> Fragment) {

    val fm = supportFragmentManager
    fm.beginTransaction()
            .replace(id, provider())
            .commit()
}