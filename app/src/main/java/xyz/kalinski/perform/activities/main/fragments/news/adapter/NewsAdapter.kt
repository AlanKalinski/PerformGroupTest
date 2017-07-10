package xyz.kalinski.perform.activities.main.fragments.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_item_view.view.*
import xyz.kalinski.perform.R
import xyz.kalinski.perform.network.models.Item
import xyz.kalinski.perform.utils.inflate
import xyz.kalinski.perform.utils.loadImageFill

class NewsAdapter(val items: ArrayList<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(parent.inflate(R.layout.news_item_view))

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
            image.loadImageFill(item.link)
            title.text = item.title
            date.text = item.pubDate
            itemView.setOnClickListener { listener.invoke(item) }
        }
    }

}