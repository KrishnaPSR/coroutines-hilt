package com.deividasstr.ui.features.main.backgroundwork

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.deividasstr.domain.usecases.DownloadAllSweetsUseCase
import com.deividasstr.ui.base.framework.base.BaseApplication
import javax.inject.Inject

class DownloadAllSweetsWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {

    companion object { const val KEY_ERROR = "KEY_ERROR" }

    @Inject
    lateinit var downloadAllSweetsUseCase: DownloadAllSweetsUseCase

    override suspend fun doWork(): Result {
        (applicationContext as BaseApplication).appComponent.inject(this)
        return try {
            downloadAllSweetsUseCase.execute()
            Result.success()
        } catch (error: Throwable) {
            Result.failure()
        }
    }
}