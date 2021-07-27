package com.deividasstr.domain.framework

import io.reactivex.Completable

interface CompletableUseCase {
    suspend  fun execute()
}