package xyz.kalinski.perform.activities.main.fragments.scores.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.scores_header_view.view.*
import kotlinx.android.synthetic.main.scores_item_view.view.*
import org.jetbrains.anko.backgroundColor
import xyz.kalinski.perform.R
import xyz.kalinski.perform.models.ScoreHeader
import xyz.kalinski.perform.models.response.Match
import xyz.kalinski.perform.utils.inflate
import xyz.kalinski.perform.view.AutoUpdatableAdapter
import xyz.kalinski.perform.view.ViewHolder
import xyz.kalinski.perform.view.ViewType
import xyz.kalinski.perform.view.ViewTypes
import kotlin.properties.Delegates

class ScoresAdapter : RecyclerView.Adapter<ViewHolder>(), AutoUpdatableAdapter {
    var items: List<ViewType> by Delegates.observable(emptyList()) {
        prop, old, new ->
        autoNotify(old, new) { o, n -> compare(o, n) }
    }

    fun compare(o: ViewType, n: ViewType): Boolean {
        if ((o.getType() == n.getType()) && (o is Match) && (n is Match) && (o.id == n.id)) return true
        if ((o.getType() == n.getType()) && (o is ScoreHeader) && (n is ScoreHeader) && (o.date == n.date)) return true
        return false
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(items[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        when (viewType) {
            ViewTypes.ITEM.typeId -> return ScoresViewHolder(parent.inflate(R.layout.scores_item_view))
            ViewTypes.HEADER.typeId -> return HeaderViewHolder(parent.inflate(R.layout.scores_header_view))
        }
        return null
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].getType().typeId
    }

    class ScoresViewHolder(itemView: View) : ViewHolder(itemView) {
        override fun bind(it: ViewType, pos: Int) = with(itemView) {
            val item = it as Match
            homeTeam.text = item.teamAname
            awayTeam.text = item.teamBname
            score.text = String.format(context.getString(R.string.score_text_format), item.scoreA, item.scoreB)
            if (pos % 2 == 0) layout.backgroundColor = ContextCompat.getColor(context, R.color.scoresPrimaryColor)
            else layout.backgroundColor = ContextCompat.getColor(context, R.color.scoresSecondaryColor)
        }
    }

    class HeaderViewHolder(itemView: View) : ViewHolder(itemView) {
        override fun bind(it: ViewType, pos: Int) = with(itemView) {
            val item = it as ScoreHeader
            date.text = item.date
        }
    }
}