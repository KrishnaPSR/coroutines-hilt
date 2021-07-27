package com.deividasstr.ui.features.main.backgroundwork

import androidx.work.*
import java.util.*


class BackgroundWorkManager {

    companion object {
        const val SWEETS_DOWNLOAD_NAME = "SWEETS_DOWNLOAD"
        const val FACTS_DOWNLOAD_NAME = "FACTS_DOWNLOAD"
    }

    fun downloadSweetsAndSaveDownloadDate(): UUID {
        val constraints = Data.Builder()
            .build()

        val downloadWork = OneTimeWorkRequest.Builder(DownloadAllSweetsWorker::class.java)
            .setInputData(constraints)
            .build()

        val saveDownloadSweetsDateWork = OneTimeWorkRequest.Builder(SaveDownloadSweetDateWorker::class.java).build()

        val workManager = WorkManager.getInstance()

        workManager.beginUniqueWork(
            SWEETS_DOWNLOAD_NAME,
            ExistingWorkPolicy.REPLACE,
            downloadWork
        ).then(saveDownloadSweetsDateWork).enqueue()

        return downloadWork.id
    }

    fun downloadFactsAndSaveDownloadDate(): UUID {
        val constraints = Data.Builder()
                .build()

        val downloadWork = OneTimeWorkRequest.Builder(DownloadAllFactsWorker::class.java)
                .setInputData(constraints)
            .build()

        val saveDownloadFactsDateWork = OneTimeWorkRequest.Builder(SaveDownloadFactsDateWorker::class.java).build()

        val workManager = WorkManager.getInstance()

        workManager.beginUniqueWork(
            FACTS_DOWNLOAD_NAME,
            ExistingWorkPolicy.REPLACE,
            downloadWork
        ).then(saveDownloadFactsDateWork).enqueue()

        return downloadWork.id
    }
}