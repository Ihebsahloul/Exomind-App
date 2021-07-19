package com.exomind.task.weather

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.exomind.domain.usecase.CityWeatherUseCase
import com.exomind.task.commons.Loading
import com.exomind.task.commons.Success
import com.exomind.task.commons.UiStateViewModel
import com.exomind.task.mappers.toPresentation
import com.exomind.task.models.CityWeatherUiModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val categoryRepositoryUseCase: CityWeatherUseCase
) : UiStateViewModel() {

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var searchJob: Job? = null

    val id = MutableLiveData<Int>()

    val searchResultsCategories: LiveData<CityWeatherUiModel>
        get() = _searchResultsCategoryRepository



    private var _searchResultsCategoryRepository: MutableLiveData<CityWeatherUiModel> =
        MutableLiveData()







    fun executeCityWeather(city: String) {
        _uiState.value = Loading
        viewModelScope.launch(handler) {
            categoryRepositoryUseCase(city).collect { results ->

                _searchResultsCategoryRepository.value = results.toPresentation()
                _uiState.value = Success
            }
        }
    }








    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        searchJob?.cancel()
    }
}