package hr.vsite.map.sofascoreaa_zad1.networking.model

import java.io.Serializable
import java.time.DateTimeException
import java.util.*

data class LocationResponse(
    val woeid: Int,
    val title: String,
    val lat_long: String
) : Serializable