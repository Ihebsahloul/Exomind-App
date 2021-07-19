package com.exomind.domain.repository

import com.exomind.domain.weather.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface ICityWeatherRepository {
    suspend fun getCityWeather(city: String): Flow<WeatherResponse>
}