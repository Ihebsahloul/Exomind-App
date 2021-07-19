package com.exomind.task.di.modules.trendingreposearch


import com.exomind.data.repository.CityWeatherRepository
import com.exomind.domain.repository.ICityWeatherRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class CityWeatherBindingModule {

    @Singleton
    @Binds
    abstract fun bindCityWeatherRepository(
        cityWeatherRepository: CityWeatherRepository
    ): ICityWeatherRepository

}