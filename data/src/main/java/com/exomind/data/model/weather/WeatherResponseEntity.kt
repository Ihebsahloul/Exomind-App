package com.exomind.data.model.weather

import com.exomind.domain.weather.*

data class WeatherResponseEntity (


    val coord: Coord? = null,

    val weather: List<Weather>? = null,

    val base: String? = null,

    val main: Main? = null,

    val visibility: Int? = null,

    val wind: Wind? = null,

    val clouds: Clouds? = null,

    val dt: Int? = null,

    val sys: Sys? = null,

    val timezone: Int? = null,

    val id: Int? = null,

    val name: String? = null,

    val cod: Int? = null

)