
package com.exomind.data.model

import com.exomind.data.global.Constants.EndPoints.ALL_CATEGORIES
import com.exomind.data.global.Constants.EndPoints.WEATHER
import com.exomind.data.response.weather.CityWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ResourceRepoApiService {


    @GET(WEATHER)
    suspend fun getCityWeather(@Query("q") city: String,@Query("units") units: String,@Query("appid") apiKey: String): CityWeatherResponse
}