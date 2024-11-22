package jun.sample.app.data_api.database

import jun.sample.app.model.Sample
import jun.sample.app.model.etc.error.MessageType
import kotlinx.coroutines.flow.Flow

interface SampleRepository {

    suspend fun upsertSample(
        sample: Sample,
        onError: (MessageType) -> Unit,
        onSuccess: () -> Unit
    )

    fun getSampleListFlow(): Flow<List<Sample>>

    suspend fun getSampleList(): List<Sample>

    suspend fun getSampleById(id: Long): Sample

    suspend fun deleteById(id: Long)
}