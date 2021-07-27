package com.deividasstr.domain.repositories

import io.reactivex.Completable

interface PrefsRepo {
    suspend  fun saveSweetsDownloadTime()
    suspend  fun saveFactsDownloadTime()
}