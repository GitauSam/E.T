package com.zenza.et.di

import android.app.Application
import androidx.room.Room
import com.zenza.et.data.DeniRepository
import com.zenza.et.data.DeniRepositoryImpl
import com.zenza.et.data.EtDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesETDatabase(app: Application): EtDatabase {
        return Room.databaseBuilder(
            app,
            EtDatabase::class.java,
            "et_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesDeniRepository(db: EtDatabase): DeniRepository {
        return DeniRepositoryImpl(deniDao = db.deniDao)
    }
}