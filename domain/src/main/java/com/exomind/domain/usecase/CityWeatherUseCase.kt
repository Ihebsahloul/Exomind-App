package com.exomind.domain.usecase

import com.exomind.domain.repository.ICityWeatherRepository
import javax.inject.Inject

class CityWeatherUseCase @Inject constructor(
    private val getCityWeatherRepository: ICityWeatherRepository
) {
    suspend operator fun invoke(city: String) =
        getCityWeatherRepository.getCityWeather(city)
}