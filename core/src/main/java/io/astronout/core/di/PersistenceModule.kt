package io.astronout.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.astronout.core.data.source.local.room.NeewzDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideNeewzDatabase(@ApplicationContext context: Context): NeewzDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("neewz".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context.applicationContext,
            NeewzDatabase::class.java,
            "neewz_database"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}