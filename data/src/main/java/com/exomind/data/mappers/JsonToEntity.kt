package com.exomind.data.mappers

import com.exomind.data.model.weather.WeatherResponseEntity
import com.exomind.data.response.weather.CityWeatherResponse


internal fun CityWeatherResponse.toEntity(): WeatherResponseEntity {
    return WeatherResponseEntity(

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