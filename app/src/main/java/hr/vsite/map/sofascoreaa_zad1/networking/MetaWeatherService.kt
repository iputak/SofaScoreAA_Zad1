package hr.vsite.map.sofascoreaa_zad1.networking

import hr.vsite.map.sofascoreaa_zad1.networking.model.CityResponse
import hr.vsite.map.sofascoreaa_zad1.networking.model.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MetaWeatherService {

    @GET("search/?query={query}")
    suspend fun getLocation(@Query("query") cityName: String): LocationResponse

    @GET("{id}")
    suspend fun getCity(@Path("id") cityId: Int): CityResponse
}