package jun.sample.app.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import jun.sample.app.database.AppDatabase.Companion.SAMPLE_TABLE_NAME
import jun.sample.app.database.entity.SampleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SampleDao {

    @Upsert
    suspend fun upsert(entity: SampleEntity)

    @Query("SELECT * FROM $SAMPLE_TABLE_NAME")
    fun getFlow(): Flow<List<SampleEntity>>

    @Query("SELECT * FROM $SAMPLE_TABLE_NAME")
    suspend fun get(): List<SampleEntity>

    @Query("SELECT * FROM $SAMPLE_TABLE_NAME WHERE id = :id")
    suspend fun getById(id: Long): SampleEntity

    @Query("DELETE FROM $SAMPLE_TABLE_NAME WHERE id = :id")
    suspend fun deleteById(id: Long)
}