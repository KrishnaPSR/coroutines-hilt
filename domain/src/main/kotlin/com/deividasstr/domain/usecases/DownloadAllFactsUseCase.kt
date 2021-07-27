package com.deividasstr.domain.usecases

import com.deividasstr.domain.framework.CompletableUseCase
import com.deividasstr.domain.repositories.FactRepo
import io.reactivex.Completable

class DownloadAllFactsUseCase(private val repo: FactRepo) : CompletableUseCase {

    override suspend fun execute() {
        return repo.downloadAllFactsAndSave()
    }
}