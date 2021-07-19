package com.exomind.task.mappers

import com.exomind.domain.weather.WeatherResponse
import com.exomind.task.models.CityWeatherUiModel



fun WeatherResponse.toPresentation(): CityWeatherUiModel {
    return CityWeatherUiModel(
        this.coord,
        this.weather,
        this.base,
        this.main,
        this.visibility,
        this.wind,
        this.clouds,
        this.dt,
        this.sys,
        this.timezone,
        this.id,
        this.name,
        this.cod





    )
}