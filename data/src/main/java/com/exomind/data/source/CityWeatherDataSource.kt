package com.exomind.data.source


import com.exomind.data.global.Constants
import com.exomind.data.mappers.toEntity
import com.exomind.data.model.ResourceRepoApiService
import com.exomind.data.model.weather.WeatherResponseEntity
import com.exomind.data.utils.SharedPrefsHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CityWeatherDataSource @Inject constructor(
    private val apiService: ResourceRepoApiService,
    private val sharedPrefsHelper: SharedPrefsHelper
) {

    /**
     * Takes in [params] to be used for the search
     * @return list of search results
     */
    suspend fun getCityWeather(city: String) : Flow<WeatherResponseEntity> {

        val cityWeatherResponse = apiService.getCityWeather(city,Constants.METRIC,Constants.BASE_URL)
        val callData = cityWeatherResponse



        return flow { emit(callData.toEntity()) }
    }
}