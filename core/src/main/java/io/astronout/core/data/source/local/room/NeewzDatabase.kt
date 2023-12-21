package io.astronout.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import io.astronout.core.data.source.local.dao.ArticleDao
import io.astronout.core.data.source.local.entity.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NeewzDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}