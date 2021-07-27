package com.deividasstr.domain.framework

import io.reactivex.Completable

interface CompletableUseCaseWithParameter<P> {
    suspend  fun execute(parameter: P)
}
