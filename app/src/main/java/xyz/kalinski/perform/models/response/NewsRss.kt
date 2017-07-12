package xyz.kalinski.perform.models.response

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "rss", strict = false)
data class NewsRss(
        @field:Attribute(name = "version") var version: String? = null,
        @field:Element(name = "channel") var channel: Channel? = null
)

@Root(strict = false)
data class Channel(
        @field:Element(name = "title") var title: String? = null,
        @field:Element(name = "description", required = false) var description: String? = null,
        @field:Element(name = "language") var language: String? = null,
        @field:Element(name = "pubDate") var pubDate: String? = null,
        @field:Element(name = "link") var link: String? = null,
        @field:ElementList(inline = true, entry = "category") var categories: ArrayList<String>? = null,
        @field:ElementList(name = "item", inline = true) var items: ArrayList<Item>? = null
)

@Root(strict = false)
data class Item(
        @field:Element(name = "guid") var guid: Long? = null,
        @field:Element(name = "title") var title: String? = null,
        @field:Element(name = "pubDate") var pubDate: String? = null,
        @field:Element(name = "enclosure") var enclosure: Enclosure? = null,
        @field:Element(name = "description") var description: String? = null,
        @field:Element(name = "link") var link: String? = null,
        @field:Element(name = "category") var category: String? = null
) : Serializable

@Root(strict = false)
data class Enclosure(
        @field:Attribute(name = "length") var length: Long? = null,
        @field:Attribute(name = "url") var url: String? = null,
        @field:Attribute(name = "type") var type: String? = null
) : Serializable