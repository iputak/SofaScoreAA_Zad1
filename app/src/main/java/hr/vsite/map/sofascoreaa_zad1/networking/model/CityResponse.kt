package hr.vsite.map.sofascoreaa_zad1.networking.model

import java.io.Serializable
import java.time.DateTimeException
import java.util.*

data class CityResponse(
    //consolidated_weather
    val consolidated_weather: List<City>,
    val timezone_name: String,
    val woeid: Int,
    val title: String,
    val time: DateTimeException,

) : Serializable

data class City(
    val id: Int,
    val weather_state_name: String,
    val weather_state_abbr: String,
    val wind_direction_compass: String,
    val applicable_date: Date,
    val min_temp: Int,
    val max_temp: Int,
    val the_temp: Int,
    val wind_speed: Int,
    val wind_direction: Int,
    val air_pressure: Int,
    val humidity: Int,
    val visibility: Int,
    val predictability: Int
)

