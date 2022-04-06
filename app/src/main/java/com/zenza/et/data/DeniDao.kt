package com.zenza.et.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DeniDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeni(deni: Deni)

    @Delete
    suspend fun deleteDeni(deni: Deni)

    @Query("SELECT * FROM deni WHERE id = :id")
    suspend fun getDeniById(id: Int): Deni?

    @Query("SELECT * FROM deni")
    fun getTodo(): Flow<List<Deni>>
}