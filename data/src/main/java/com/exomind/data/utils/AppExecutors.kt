package com.exomind.data.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import javax.inject.Singleton

/**
 * Global executor pools for the whole application.
 *
 *
 * Grouping tasks like this avoids the effects of task starvation (e.g. disk reads don't wait behind
 * webservice requests).
 */
@Singleton
class AppExecutors(
    private val diskIO: Executor,
    private val mainThread: Executor
) {
    fun diskIO() = diskIO
    fun mainThread() = mainThread

    class MainThreadExecutor : Executor {
        private val mainThreadHandler =
            Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }

}