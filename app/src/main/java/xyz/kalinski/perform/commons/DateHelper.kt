package xyz.kalinski.perform.commons

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    val DEFAULT_FORMAT = "EEE, dd MMM yyyy HH:mm:ss Z"
    val USER_FRIENDLY_FORMAT = "EEEE, d MMMM yyyy, H:mm"

    fun parseDate(date: Date, format: String = DEFAULT_FORMAT): String {
        val tempDate = date
        val dateString: String

        val simpleDateFormat = SimpleDateFormat(format, Locale.ENGLISH)
        simpleDateFormat.timeZone = TimeZone.getDefault()
        dateString = simpleDateFormat.format(tempDate)

        return dateString
    }

    fun parseString(stringDate: String, format: String = DEFAULT_FORMAT): Date {
        val date: Date
        val simpleDateFormat = SimpleDateFormat(format, Locale.ENGLISH)
        date = simpleDateFormat.parse(stringDate)

        return date
    }
}