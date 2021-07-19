package com.exomind.task

import com.exomind.task.weather.di.component.AppComponent
import dagger.android.HasAndroidInjector


class CategoriesTestApplication : ExoMindApp(), HasAndroidInjector {

    override fun onCreate() {
        super.onCreate()
        getApplicationComponent().inject(this)
    }

    override fun getApplicationComponent(): AppComponent {
        return DaggerTestApplicationComponent.factory()
            .create(applicationContext)
    }

}