package jun.sample.app.database.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jun.sample.app.database.AppDatabase
import jun.sample.app.database.AppDatabase.Companion.DATABASE_NAME
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun queryCallBackLogger() = RoomDatabase.QueryCallback { sqlQuery, bindArgs ->
        val cleanedArgs = bindArgs.joinToString(", ")
        if (jun.sample.app.utils.BuildConfig.DEBUG) {
            when {
                sqlQuery.startsWith("INSERT") -> Log.v("DatabaseInsert", "Query: $sqlQuery | Args: [$cleanedArgs]")
                sqlQuery.startsWith("UPDATE") -> Log.v("DatabaseUpdate", "Query: $sqlQuery | Args: [$cleanedArgs]")
                sqlQuery.startsWith("SELECT") -> Log.v("DatabaseSelect", "Query: $sqlQuery | Args: [$cleanedArgs]")
                sqlQuery.startsWith("DELETE") -> Log.v("DatabaseDelete", "Query: $sqlQuery | Args: [$cleanedArgs]")
                else -> {}
            }
        }
    }

//    @Provides
//    @Singleton
//    fun databaseCallBack(): RoomDatabase.Callback = object : RoomDatabase.Callback() {
//        override fun onCreate(db: SupportSQLiteDatabase) {
//            super.onCreate(db)
//
//            Executors.newSingleThreadExecutor().execute {
//                runBlocking {
//                    db.execSQL(SpendingPlanEntity.INSERT_QUERY)
//                }
//            }
//        }
//    }

    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext context: Context,
        queryCallBackLogger: RoomDatabase.QueryCallback,
//        addCallback: RoomDatabase.Callback
    ): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
        .setQueryCallback(queryCallBackLogger, Executors.newSingleThreadExecutor())
//        .addCallback(addCallback)
        .build()
}