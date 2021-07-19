package com.exomind.domain.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Clouds (
    @SerializedName("all")
    @Expose
    var all: Int? = null

    ) : Serializable