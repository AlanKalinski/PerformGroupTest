package xyz.kalinski.perform.models

import xyz.kalinski.perform.view.ViewType
import xyz.kalinski.perform.view.ViewTypes


class ScoreHeader(
        val date: String
) : ViewType {
    override fun getType(): ViewTypes = ViewTypes.HEADER

    override fun equals(other: Any?): Boolean {
        return other is ScoreHeader && other.date === this.date
    }

    override fun hashCode(): Int {
        return date.hashCode()
    }
}