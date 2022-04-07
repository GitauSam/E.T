package com.zenza.et.data

import kotlinx.coroutines.flow.Flow

class DeniRepositoryImpl(
    private val deniDao: DeniDao
): DeniRepository {
    override suspend fun insertDeni(deni: Deni) {
        deniDao.insertDeni(deni)
    }

    override suspend fun deleteDeni(deni: Deni) {
        deniDao.deleteDeni(deni)
    }

    override suspend fun getDeniById(id: Int): Deni? {
        return deniDao.getDeniById(id)
    }

    override fun getDeni(): Flow<List<Deni>> {
        return deniDao.getDeni()
    }
}