package com.laohu.study.platform.repository.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.laohu.study.platform.model.CourseGrade
import com.laohu.study.platform.model.CoursePhase
import com.laohu.study.platform.model.CourseSubject
import com.laohu.study.platform.model.CourseUnit
import com.laohu.study.platform.model.CourseUnitCase

@Database(
    entities = [CoursePhase::class, CourseGrade::class, CourseSubject::class, CourseUnit::class, CourseUnitCase::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao
}