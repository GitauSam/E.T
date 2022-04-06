package com.zenza.et.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Deni::class
    ],
    version = 1
)
abstract class EtDatabase: RoomDatabase() {

    abstract val deniDao: DeniDao
}