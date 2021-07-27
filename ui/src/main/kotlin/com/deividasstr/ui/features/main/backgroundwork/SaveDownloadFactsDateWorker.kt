package com.deividasstr.ui.features.main.backgroundwork

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.deividasstr.domain.usecases.SaveDownloadFactDateUseCase
import com.deividasstr.ui.base.framework.base.BaseApplication
import javax.inject.Inject

class SaveDownloadFactsDateWorker(context: Context, val configuration: WorkerParameters) :
        CoroutineWorker(context, configuration) {

    @Inject lateinit var saveDownloadDateUseCase: SaveDownloadFactDateUseCase

    override suspend fun doWork(): Result {
        (applicationContext as BaseApplication).appComponent.inject(this)

        return try {
            saveDownloadDateUseCase.execute()
            Result.success()
        } catch (error: Throwable) {
            Result.failure()
        }
    }
}