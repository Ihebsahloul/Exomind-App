package com.exomind.data.utils

interface GetTaskCallback<T> {
    fun onTaskLoaded(loadedTask: T)
    fun onDataNotAvailable()
}