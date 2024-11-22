package jun.sample.app.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jun.sample.app.database.AppDatabase
import jun.sample.app.database.dao.SampleDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    @Singleton
    fun provideSampleDao(
        database: AppDatabase,
    ) : SampleDao = database.sampleDao()
}
