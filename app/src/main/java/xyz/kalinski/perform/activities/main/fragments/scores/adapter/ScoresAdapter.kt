package xyz.kalinski.perform.activities.main.fragments.scores.adapter

import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.DrawableUtils
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.scores_item_view.view.*
import org.jetbrains.anko.backgroundColor
import xyz.kalinski.perform.R
import xyz.kalinski.perform.network.models.Match
import xyz.kalinski.perform.utils.inflate

class ScoresAdapter(var items: ArrayList<Match>) : RecyclerView.Adapter<ScoresAdapter.ScoresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ScoresViewHolder(parent.inflate(R.layout.scores_item_view))

    override fun onBindViewHolder(holder: ScoresViewHolder, position: Int) = holder.bind(items[position], position)

    override fun getItemCount() = items.size

    class ScoresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Match, position: Int) = with(itemView) {
            homeTeam.text = item.teamAname
            awayTeam.text = item.teamBname
            score.text = String.format(context.getString(R.string.score_text_format), item.scoreA, item.scoreB)
            if (position % 2 == 0) layout.backgroundColor = ContextCompat.getColor(context, R.color.scoresPrimaryColor)
            else layout.backgroundColor = ContextCompat.getColor(context, R.color.scoresSecondaryColor)
        }
    }

}