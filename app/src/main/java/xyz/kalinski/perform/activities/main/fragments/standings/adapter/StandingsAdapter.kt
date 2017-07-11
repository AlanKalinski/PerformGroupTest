package xyz.kalinski.perform.activities.main.fragments.standings.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.standings_item_view.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor
import xyz.kalinski.perform.R
import xyz.kalinski.perform.models.response.Ranking
import xyz.kalinski.perform.utils.inflate

class StandingsAdapter(var items: ArrayList<Ranking>) : RecyclerView.Adapter<StandingsAdapter.StandingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StandingViewHolder(parent.inflate(R.layout.standings_item_view))

    override fun onBindViewHolder(holder: StandingViewHolder, position: Int) = holder.bind(items[position], position)

    override fun getItemCount() = items.size

    class StandingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Ranking, pos: Int) = with(itemView) {
            position.text = String.format("%d", item.rank)
            teamName.text = String.format("%s", item.clubName)
            played.text = String.format("%d", item.matchesTotal)
            won.text = String.format("%d", item.matchesWon)
            draw.text = String.format("%d", item.matchesDraw)
            lose.text = String.format("%d", item.matchesLost)
            points.text = String.format("%d", item.points)

            val balance = item.goalsPro - item.goalsAgainst
            goalBalance.text = String.format("%d", balance)
            if (balance > 0) goalBalance.textColor = ContextCompat.getColor(context, R.color.green)
            else if (balance < 0) goalBalance.textColor = ContextCompat.getColor(context, R.color.red)
            else goalBalance.textColor = ContextCompat.getColor(context, R.color.gray)

            if (pos % 2 == 0) layout.backgroundColor = ContextCompat.getColor(context, R.color.scoresPrimaryColor)
            else layout.backgroundColor = ContextCompat.getColor(context, R.color.scoresSecondaryColor)
        }
    }

}