package hr.vsite.map.sofascoreaa_zad1.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    private val service: MetaWeatherService
    private val baseUrl = "https://www.metaweather.com/api/location/"

    init {
        val httpClient = OkHttpClient.Builder()
        val retrofit =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()).build()
        service = retrofit.create(MetaWeatherService::class.java)
    }

    fun getService(): MetaWeatherService {
        return service
    }
}