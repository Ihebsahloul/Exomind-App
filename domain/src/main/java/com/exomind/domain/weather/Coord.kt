package com.exomind.domain.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Coord (
    @SerializedName("lon")
    @Expose
    var lon: Double? = null,

    @SerializedName("lat")
    @Expose
    var lat: Double? = null

) : Serializable