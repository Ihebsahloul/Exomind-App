package com.exomind.task.viewmodels

import com.exomind.domain.usecase.CityWeatherUseCase
import com.exomind.task.BaseViewModelTest
import com.exomind.task.mappers.toPresentation
import com.exomind.task.weather.WeatherViewModel
import com.exomind.task.utils.SampleData
import com.exomind.task.utils.observeOnce
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class WeatherViewModelTest : BaseViewModelTest() {

    @Mock
    lateinit var weatherUseCase: CityWeatherUseCase
    private lateinit var weatherViewModel: WeatherViewModel

    @Before
    fun setup() {
        weatherViewModel = WeatherViewModel(weatherUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun shouldReceiveSearchResults() {
        runBlockingTest {
            setMockAnswer()
            weatherViewModel.executeCityWeather("Paris")
            weatherViewModel.searchResultsCategories.observeOnce {
                Truth.assertThat(it)
                    .isEqualTo(SampleData.categoriesSearchResults.toPresentation())
            }
        }
    }

    private suspend fun setMockAnswer() {
        given(weatherUseCase("Paris")).willReturn(flow {
            emit(SampleData.categoriesSearchResults)
        })
    }
}