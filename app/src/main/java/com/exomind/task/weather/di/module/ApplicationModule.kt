package com.exomind.task.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.exomind.data.utils.AppExecutors
import com.exomind.data.utils.DiskIOThreadExecutor
import com.exomind.data.utils.SharedPrefsHelper
import com.exomind.data.global.Constants.Parameters.DB_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * This is a Dagger provider module
 */
@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            SharedPrefsHelper.PREF_NAME,
            Context.MODE_PRIVATE
        )
    }


    @Singleton
    @Provides
    fun provideAppExecutors(): AppExecutors {
        return AppExecutors(
            DiskIOThreadExecutor(),
            AppExecutors.MainThreadExecutor()
        )
    }

    @Provides
    @Named("databaseName")
    fun provideDatabaseName(): String = DB_NAME

}