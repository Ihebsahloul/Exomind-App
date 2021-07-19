package com.exomind.task.helpers

import com.exomind.task.sample.searchSuccess
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

/**
 * Handles Requests from mock web server
 */
internal class CategoriesRequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "https://api.openweathermap.org/data/2.5/weather?q=nantes&units=metric&appid=55e58d5b8ad4d23be6cb470d80895246" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(searchSuccess)
            }
            else -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
            }
        }
    }

}