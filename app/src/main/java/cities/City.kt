package cities

import java.io.Serializable
import java.time.DateTimeException
import java.util.*

data class City(
    val timezone_name: String,
    val woeid: Int,
    val title: String,
    val latt_long: String,
    val time: DateTimeException,
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
) : Serializable {
    override fun toString(): String {
        return "$timezone_name, $woeid, $title, $latt_long, $time, $id, $weather_state_name, $weather_state_abbr, $wind_direction_compass, $applicable_date, $min_temp, $max_temp, $the_temp, $wind_speed, $wind_direction, $air_pressure, $humidity, $visibility, $predictability"
    }
}