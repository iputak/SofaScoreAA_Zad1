package hr.vsite.map.sofascoreaa_zad1.networking.model

import java.io.Serializable
import java.time.DateTimeException
import java.util.*

data class CityResponse(
    val woeid: Int,
    val title: String,
    val weather_state_name: String,
    val applicable_date: Date,
    val time: DateTimeException,
    val timezone_name: String,
    val min_temp: Int,
    val max_temp: Int,
    val the_temp: Int,
    val wind_speed: Int,
    val air_pressure: Int,
    val humidity: Int,
    val visibility: Int,
    val predictability: Int
) : Serializable

