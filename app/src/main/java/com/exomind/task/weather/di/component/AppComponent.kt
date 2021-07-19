package com.exomind.task.weather.di.component

import android.content.Context
import com.exomind.task.ExoMindApp
import com.exomind.task.di.modules.ActivityBuilderModule
import com.exomind.task.di.modules.ApplicationModule
import com.exomind.task.di.modules.ResourceRepoApiModule
import com.mvvmclean.trendingrepos.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Core Application Dagger Component
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ResourceRepoApiModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(app: ExoMindApp)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}

