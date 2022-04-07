package com.zenza.et.data

import kotlinx.coroutines.flow.Flow

interface DeniRepository {

    suspend fun insertDeni(deni: Deni)

    suspend fun deleteDeni(deni: Deni)

    suspend fun getDeniById(id: Int): Deni?

    fun getDeni(): Flow<List<Deni>>
}