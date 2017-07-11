package xyz.kalinski.perform.view

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(it: ViewType, pos: Int)
}