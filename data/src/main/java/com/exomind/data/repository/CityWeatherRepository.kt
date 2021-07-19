package com.exomind.data.repository

import com.exomind.data.mappers.toDomain
import com.exomind.data.source.CityWeatherDataSource
import com.exomind.domain.repository.ICityWeatherRepository
import com.exomind.domain.weather.WeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CityWeatherRepository @Inject constructor(
    private val cityWeatherDataSource: CityWeatherDataSource
) : ICityWeatherRepository {


    override suspend fun getCityWeather(city: String): Flow<WeatherResponse> {
        return cityWeatherDataSource.getCityWeather(city)
            .map { it.toDomain() }
    }
}

