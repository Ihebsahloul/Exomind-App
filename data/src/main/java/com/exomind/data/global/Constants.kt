package com.exomind.data.global

class Constants {


    companion object {
        const val BASE_URL: String = "http://api.openweathermap.org/data/2.5/"
        const val API_KEY :String= "55e58d5b8ad4d23be6cb470d80895246"
        const val METRIC :String = "metric"

    }


    object Urls

    object Requests

    object Parameters {
        const val DB_NAME = "cities.db"
        const val MAX_TIME_TIMER = 60000
        const val  TICK_TIME :Long = 1000
    }

    object EndPoints {

        const val ALL_CATEGORIES = "categories.json"
        const val WEATHER = "weather"
    }
    object CITIES {


        const val RENNES = "Rennes"
        const val PARIS = "Paris"
        const val NANTES = "Nantes"
        const val BORDEAUX = "Bordeaux"
        const val LYON ="Lyon"

    }


    object TIMEFRAMES
    {
        const val RENNES = 0
        const val PARIS =  10
        const val NANTES = 20
        const val BORDEAUX = 30
        const val LYON =40
    }

    object CLOUDS_STATUS
    {
        const val CLEAR = "Clear"
        const val CLOUDY =  "Clouds"

    }

}