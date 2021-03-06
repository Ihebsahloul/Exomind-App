package com.exomind.task.di

import android.content.Context
import com.exomind.task.weather.di.component.AppComponent
import com.exomind.task.di.modules.ActivityBuilderModule
import com.exomind.task.di.modules.ApplicationModule
import com.mvvmclean.trendingrepos.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        FakeWeatherApiModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface TestApplicationComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): TestApplicationComponent
    }

}