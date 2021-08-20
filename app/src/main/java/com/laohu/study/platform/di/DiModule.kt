package com.laohu.study.platform.di

import android.content.Context
import androidx.room.Room
import com.laohu.study.platform.repository.dao.AppDatabase
import com.laohu.study.platform.repository.dao.CourseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object CoroutineModule {

    @Provides
    fun provideCoroutineScope(): CoroutineScope {
        return CoroutineScope(Dispatchers.Main + Job())
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
        @DatabasePath databasePath: String
    ): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, databasePath)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideCourseDao(appDatabase: AppDatabase): CourseDao {
        return appDatabase.courseDao()
    }

    @DatabasePath
    @Singleton
    @Provides
    fun provideDatabasePath(@ApplicationContext context: Context): String {
        return "${context.getExternalFilesDir(null)}/db/course.db"
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DatabasePath