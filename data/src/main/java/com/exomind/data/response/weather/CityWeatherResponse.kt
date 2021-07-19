package com.exomind.data.response.weather

import com.exomind.domain.weather.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityWeatherResponse(

        var coord: Coord? = null,

        var weather: List<Weather>? = null,

        var base: String? = null,

        var main: Main? = null,

        var visibility: Int? = null,

        var wind: Wind? = null,

        var clouds: Clouds? = null,

        var dt: Int? = null,

        var sys: Sys? = null,

        var timezone: Int? = null,

        var id: Int? = null,

        var name: String? = null,

        var cod: Int? = null

)