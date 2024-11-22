package jun.sample.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import jun.sample.app.database.dao.SampleDao
import jun.sample.app.database.entity.SampleEntity

@Database(
    entities = [
        SampleEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(
    value = [
    ]
)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun sampleDao(): SampleDao

    companion object {
        const val DATABASE_NAME = "app_database"

        const val SAMPLE_TABLE_NAME = "sample"
    }
}