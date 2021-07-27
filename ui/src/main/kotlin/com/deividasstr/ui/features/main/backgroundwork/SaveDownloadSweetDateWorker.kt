package com.deividasstr.ui.features.main.backgroundwork

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.deividasstr.domain.usecases.SaveDownloadSweetDateUseCase
import com.deividasstr.ui.base.framework.base.BaseApplication
import javax.inject.Inject

class SaveDownloadSweetDateWorker(context: Context, val configuration: WorkerParameters) :
        CoroutineWorker(context, configuration){

    @Inject lateinit var saveDownloadSweetDateUseCase: SaveDownloadSweetDateUseCase

    override suspend fun doWork(): Result {
        (applicationContext as BaseApplication).appComponent.inject(this)


        return try {
            saveDownloadSweetDateUseCase.execute()
            Result.success()
        } catch (error: Throwable) {
            Result.failure()
        }
    }
}