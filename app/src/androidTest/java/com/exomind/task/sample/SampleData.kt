package com.exomind.task.sample

val searchSuccess = """
{
    "coord": {
        "lon": -1.5833,
        "lat": 47.1667
    },
    "weather": [
        {
            "id": 800,
            "main": "Clear",
            "description": "clear sky",
            "icon": "01d"
        }
    ],
    "base": "stations",
    "main": {
        "temp": 30.12,
        "feels_like": 30.91,
        "temp_min": 29.96,
        "temp_max": 31.5,
        "pressure": 1017,
        "humidity": 48
    },
    "visibility": 10000,
    "wind": {
        "speed": 5.14,
        "deg": 40
    },
    "clouds": {
        "all": 0
    },
    "dt": 1626703504,
    "sys": {
        "type": 1,
        "id": 6574,
        "country": "FR",
        "sunrise": 1626668993,
        "sunset": 1626724500
    },
    "timezone": 7200,
    "id": 2990968,
    "name": "Arrondissement de Nantes",
    "cod": 200
}""".trimIndent()