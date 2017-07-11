package xyz.kalinski.perform.activities.main.fragments.standings.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.standings_item_view.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor
import xyz.kalinski.perform.R
import xyz.kalinski.perform.models.response.Ranking
import xyz.kalinski.perform.utils.inflate
import xyz.kalinski.perform.view.ViewHolder
import xyz.kalinski.perform.view.ViewType
import xyz.kalinski.perform.view.ViewTypes


class StandingsAdapter(var items: ArrayList<Ranking>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (position == 0) return
        else holder?.bind(items[position - 1], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        when (viewType) {
            ViewTypes.ITEM.typeId -> return StandingViewHolder(parent.inflate(R.layout.standings_item_view))
            else -> return HeaderViewHolder(parent.inflate(R.layout.standings_header_view))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return ViewTypes.HEADER.typeId
        return items[position - 1].getType().typeId
    }

    override fun getItemCount() = items.size + 1

    class StandingViewHolder(itemView: View) : ViewHolder(itemView) {
        override fun bind(it: ViewType, pos: Int) = with(itemView) {
            val item = it as Ranking
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

            val positionChange = item.rank - item.lastRank
            if (positionChange > 0) {
                changePosition.text = String.format("+%d", positionChange)
                changePosition.textColor = ContextCompat.getColor(context, R.color.green)
            } else if (positionChange < 0) {
                changePosition.text = String.format("%d", positionChange)
                changePosition.textColor = ContextCompat.getColor(context, R.color.red)
            } else {
                changePosition.visibility = View.GONE
                teamName.layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 7f)
            }

            if (pos % 2 == 0) layout.backgroundColor = ContextCompat.getColor(context, R.color.scoresPrimaryColor)
            else layout.backgroundColor = ContextCompat.getColor(context, R.color.scoresSecondaryColor)
        }
    }

    class HeaderViewHolder(itemView: View) : ViewHolder(itemView) {
        override fun bind(it: ViewType, pos: Int) = with(itemView) {

        }
    }

}