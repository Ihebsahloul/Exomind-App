package com.exomind.task.models

import android.os.Parcelable
import com.exomind.domain.weather.*
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityWeatherUiModel(

        val coord: Coord? = null,

        val weather: List<Weather>? = null,

        val base: String? = null,

        val main: Main? = null,

        val visibility: Int? = null,

        val wind: Wind? = null,

        val clouds: Clouds? = null,

        val dt: Int? = null,

        val sys: Sys?,

        val timezone: Int? = null,

        val id: Int? = null,

        val name: String? = null,

        val cod: Int? = null
) : Parcelable, BaseUiModel