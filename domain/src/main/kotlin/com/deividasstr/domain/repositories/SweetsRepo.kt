package com.deividasstr.domain.repositories

import com.deividasstr.domain.entities.models.Sweet
import io.reactivex.Completable
import io.reactivex.Single

interface SweetsRepo {

    fun getAllSweets(): Single<List<Sweet>>

     fun getSweetById(id: Long): Single<Sweet>

     fun search(name: String): Single<List<Sweet>>

    suspend fun newSweet(sweet: Sweet)

    suspend fun downloadAndSaveAllSweets()

    suspend fun downloadAndSaveNewSweets()
}