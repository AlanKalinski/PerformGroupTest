package xyz.kalinski.perform.utils

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ImageView.loadImageCenter(imageUrl: String?) {
    Glide
            .with(context)
            .load(imageUrl)
            .fitCenter()
            /*.placeholder(R.drawable.image_placeholder)
            .error(R.drawable.image_error)*/
            .crossFade()
            .into(this)
}

fun ImageView.loadImageFill(imageUrl: String?) {
    Glide
            .with(context)
            .load(imageUrl)
            .centerCrop()
            /*.placeholder(R.drawable.image_placeholder)
            .error(R.drawable.image_error)*/
            .crossFade()
            .into(this)
}

inline fun View.snack(@StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    snack(resources.getString(messageRes), length, f)
}

inline fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

fun Snackbar.action(@StringRes actionRes: Int, color: Int? = null, listener: (View) -> Unit) {
    action(view.resources.getString(actionRes), color, listener)
}

fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}