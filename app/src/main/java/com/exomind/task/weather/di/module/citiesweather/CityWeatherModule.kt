package com.exomind.task.di.modules.trendingreposearch

import com.exomind.data.model.ResourceRepoApiService
import com.exomind.data.source.CityWeatherDataSource
import com.exomind.data.utils.SharedPrefsHelper
import com.exomind.domain.usecase.CityWeatherUseCase
import com.exomind.data.repository.CityWeatherRepository
import dagger.Module
import dagger.Provides

@Module
open class CityWeatherModule {
    @Provides
    fun provideCityWeatherUseCase(
        cityWeatherSearchRepository: CityWeatherRepository
    ): CityWeatherUseCase =
        CityWeatherUseCase(cityWeatherSearchRepository)

    @Provides
    fun provideCityWeatherDataSource(
            apiService: ResourceRepoApiService,
            sharedPrefsHelper: SharedPrefsHelper
    ): CityWeatherDataSource =
            CityWeatherDataSource(apiService, sharedPrefsHelper)
}


