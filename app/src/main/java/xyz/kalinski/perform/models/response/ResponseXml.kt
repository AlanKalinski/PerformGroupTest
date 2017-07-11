package xyz.kalinski.perform.models.response

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import xyz.kalinski.perform.view.ViewType
import xyz.kalinski.perform.view.ViewTypes

@Root(name = "gsmrs")
data class ResponseXml(
        @field:Attribute(name = "version") var version: String? = null,
        @field:Attribute(name = "sport") var sport: String? = null,
        @field:Attribute(name = "lang") var lang: String? = null,
        @field:Attribute(name = "last_generated") var lastGenerated: String? = null,
        @field:Element(name = "method") var method: Method? = null,
        @field:Element(name = "competition") var competition: Competition? = null
)

@Root(strict = false)
data class Method(
        @field:Attribute(name = "method_id") var methodId: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:ElementList(name = "parameter", inline = true) var parameters: ArrayList<Parameter>? = null
)

@Root(strict = false)
data class Parameter(
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "value") var value: String? = null
)

@Root(strict = false)
data class Competition(
        @field:Attribute(name = "competition_id") var id: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "teamtype") var teamType: String? = null,
        @field:Attribute(name = "display_order") var displayOrder: Int? = null,
        @field:Attribute(name = "type") var type: String? = null,
        @field:Attribute(name = "area_id") var areaId: Long? = null,
        @field:Attribute(name = "area_name") var areaName: String? = null,
        @field:Attribute(name = "last_updated") var lastUpdated: String? = null,
        @field:Attribute(name = "soccertype") var soccerType: String? = null,
        @field:Element(name = "season") var season: Season? = null
)

@Root(strict = false)
data class Season(
        @field:Attribute(name = "season_id") var id: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "start_date") var startDate: String? = null,
        @field:Attribute(name = "end_date") var endDate: String? = null,
        @field:Attribute(name = "service_level") var serviceLevel: Int? = null,
        @field:Attribute(name = "last_updated") var lastUpdated: String? = null,
        @field:Attribute(name = "last_playedmatch_date", required = false) var lastPlayedMatchDate: String? = null,
        @field:Element(name = "round") var round: Round? = null
)

@Root(strict = false)
data class Round(
        @field:Attribute(name = "round_id") var id: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "start_date") var startDate: String? = null,
        @field:Attribute(name = "end_date") var endDate: String? = null,
        @field:Attribute(name = "type") var type: String? = null,
        @field:Attribute(name = "ordermethod", required = false) var orderMethod: Int? = null,
        @field:Attribute(name = "groups") var groups: Int? = null,
        @field:Attribute(name = "has_outgroup_matches") var hasOuthroupMatches: String? = null,
        @field:Attribute(name = "last_updated", required = false) var lastUpdated: String? = null,
        @field:ElementList(name = "group", inline = true, required = false) var groupList: ArrayList<Group>? = null,
        @field:Element(name = "resultstable", required = false) var resultTable: ResultTable? = null
)

@Root(strict = false)
data class Group(
        @field:Attribute(name = "group_id") var id: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "last_updated") var lastUpdated: String? = null,
        @field:ElementList(name = "match", inline = true) var matchList: ArrayList<Match>? = null
)

@Root(strict = false)
data class Match(
        @field:Attribute(name = "match_id") var id: Long? = null,
        @field:Attribute(name = "date_utc") var dateUtc: String? = null,
        @field:Attribute(name = "time_utc") var timeUtc: String? = null,
        @field:Attribute(name = "date_london") var dateLondon: String? = null,
        @field:Attribute(name = "time_london") var timeLondon: String? = null,
        @field:Attribute(name = "team_A_id") var teamAid: Long? = null,
        @field:Attribute(name = "team_A_name") var teamAname: String? = null,
        @field:Attribute(name = "team_A_country") var teamAcountry: String? = null,
        @field:Attribute(name = "team_B_id") var teamBid: Long? = null,
        @field:Attribute(name = "team_B_name") var teamBname: String? = null,
        @field:Attribute(name = "team_B_country") var teamBcountry: String? = null,
        @field:Attribute(name = "status") var status: String? = null,
        @field:Attribute(name = "gameweek") var gameWeek: Int? = null,
        @field:Attribute(name = "fs_A") var scoreA: Int? = null,
        @field:Attribute(name = "fs_B") var scoreB: Int? = null,
        @field:Attribute(name = "last_updated") var lastUpdated: String? = null
) : ViewType {
    override fun getType() = ViewTypes.ITEM
}

@Root(strict = false)
data class ResultTable(
        @field:Attribute(name = "type") var type: String? = null,
        @field:ElementList(name = "ranking", inline = true) var rankingList: ArrayList<Ranking>? = null
)

@Root(strict = false)
data class Ranking(
        @field:Attribute(name = "rank") var rank: Int? = null,
        @field:Attribute(name = "last_rank") var lastRank: Int? = null,
        @field:Attribute(name = "zone_start", required = false) var zoneStart: String? = null,
        @field:Attribute(name = "zone_end", required = false) var zoneEnd: String? = null,
        @field:Attribute(name = "team_id") var teamId: Long? = null,
        @field:Attribute(name = "club_name") var clubName: String? = null,
        @field:Attribute(name = "countrycode") var countryCode: String? = null,
        @field:Attribute(name = "area_id") var areaId: Long? = null,
        @field:Attribute(name = "matches_total") var matchesTotal: Int? = null,
        @field:Attribute(name = "matches_won") var matchesWon: Int? = null,
        @field:Attribute(name = "matches_draw") var matchesDraw: Int? = null,
        @field:Attribute(name = "matches_lost") var matchesLost: Int? = null,
        @field:Attribute(name = "goals_pro") var goalsPro: Int = 0,
        @field:Attribute(name = "goals_against") var goalsAgainst: Int = 0,
        @field:Attribute(name = "points") var points: Int? = null
)