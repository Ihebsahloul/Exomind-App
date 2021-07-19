package com.exomind.domain.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherResponse (
    @SerializedName("coord")
    @Expose
    var coord: Coord? = null,

    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null,

    @SerializedName("base")
    @Expose
    var base: String? = null,

    @SerializedName("main")
    @Expose
    var main: Main? = null,

    @SerializedName("visibility")
    @Expose
    var visibility: Int? = null,

    @SerializedName("wind")
    @Expose
    var wind: Wind? = null,

    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null,

    @SerializedName("dt")
    @Expose
    var dt: Int? = null,

    @SerializedName("sys")
    @Expose
    var sys: Sys? = null,

    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("cod")
    @Expose
    var cod: Int? = null

) : Serializable