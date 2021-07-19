
package com.exomind.task.di.modules

import com.exomind.task.base.BaseActivity
import com.exomind.task.weather.WeatherActivity
import com.exomind.task.weather.di.component.ActivityScope
import com.exomind.task.di.modules.base.BaseBindingModule
import com.exomind.task.di.modules.base.BaseModule
import com.exomind.task.di.modules.base.IntroBindingModule
import com.exomind.task.di.modules.base.IntroModule
import com.exomind.task.di.modules.trendingreposearch.CityWeatherBindingModule
import com.exomind.task.di.modules.trendingreposearch.CityWeatherModule
import com.exomind.task.weather.IntroActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(includes = [BaseBindingModule::class, CityWeatherBindingModule::class,IntroBindingModule::class])
abstract class ActivityBuilderModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [BaseModule::class])
    abstract fun provideBaseActivity(): BaseActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [CityWeatherModule::class])
    abstract fun provideWeatherActivity(): WeatherActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [IntroModule::class])
    abstract fun provideIntroActivity(): IntroActivity
}