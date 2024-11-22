package jun.sample.app.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jun.sample.app.data.resository.SampleRepositoryImpl
import jun.sample.app.data_api.database.SampleRepository

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindsSampleRepository(
        repository: SampleRepositoryImpl
    ): SampleRepository
}
