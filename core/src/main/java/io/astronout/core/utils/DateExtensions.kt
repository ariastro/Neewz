package io.astronout.core.utils

import java.time.Instant
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.formatDate(desireFormat: ConverterDate = ConverterDate.FULL_DATE_TIME): String {
    val instant = Instant.parse(this)
    val zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC)
    val formatter = DateTimeFormatter.ofPattern(desireFormat.formatter)
    return zonedDateTime.format(formatter)
}
