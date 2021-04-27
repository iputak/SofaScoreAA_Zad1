package hr.vsite.map.sofascoreaa_zad1.networking

import hr.vsite.map.sofascoreaa_zad1.networking.model.CityResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MetaWeatherService {

    @GET("api/location/{id}")
    suspend fun getAllCities(@Path("id")cityId: Int): CityResponse
}