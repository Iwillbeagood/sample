package jun.sample.app.data.resository

import jun.sample.app.data.mapper.toSample
import jun.sample.app.data.mapper.toSampleEntity
import jun.sample.app.data_api.database.SampleRepository
import jun.sample.app.database.dao.SampleDao
import jun.sample.app.model.Sample
import jun.sample.app.model.etc.error.MessageType
import jun.sample.app.utils.etc.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val sampleDao: SampleDao
) : SampleRepository {

    override suspend fun upsertSample(
        sample: Sample,
        onError: (MessageType) -> Unit,
        onSuccess: () -> Unit
    ) {
        try {
            sampleDao.upsert(sample.toSampleEntity())
            onSuccess()
        } catch (e: Exception) {
            Logger.e("upsertSample error: $e")
        }
    }

    override fun getSampleListFlow(): Flow<List<Sample>> {
        return sampleDao.getFlow().map {
            it.map {
                it.toSample()
            }
        }
    }

    override suspend fun getSampleList(): List<Sample> {
        return sampleDao.get().map {
            it.toSample()
        }
    }

    override suspend fun getSampleById(id: Long): Sample {
        return sampleDao.getById(id).toSample()
    }

    override suspend fun deleteById(id: Long) {
        try {
            sampleDao.deleteById(id)
        } catch (e: Exception) {
            Logger.e("deleteById error: $e")
        }
    }
}