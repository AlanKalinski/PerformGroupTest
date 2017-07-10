package xyz.kalinski.perform.utils

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Transformation
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