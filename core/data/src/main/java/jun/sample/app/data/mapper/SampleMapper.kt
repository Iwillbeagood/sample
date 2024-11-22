package jun.sample.app.data.mapper

import jun.sample.app.database.entity.SampleEntity
import jun.sample.app.model.Sample

internal fun SampleEntity.toSample(): Sample {
    return Sample(
        id = id,
        title = title
    )
}

internal fun Sample.toSampleEntity(): SampleEntity {
    return SampleEntity(
        id = id,
        title = title
    )
}
