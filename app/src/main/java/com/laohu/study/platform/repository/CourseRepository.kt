package com.laohu.study.platform.repository

import androidx.lifecycle.LiveData
import com.laohu.study.platform.model.CourseGrade
import com.laohu.study.platform.model.CoursePhase
import com.laohu.study.platform.model.CourseSubject
import com.laohu.study.platform.model.CourseUnit
import com.laohu.study.platform.model.CourseUnitCase
import com.laohu.study.platform.repository.dao.CourseDao
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CourseRepository @Inject constructor(private val courseDao: CourseDao) {
    fun queryCoursePhaseList(): LiveData<List<CoursePhase>> = courseDao.queryCoursePhaseList()

    fun queryCourseGradeListByPhase(phaseCode: String): LiveData<List<CourseGrade>> =
        courseDao.queryCourseGradeListByPhase(phaseCode)

    fun queryCourseSubjectListByGrade(gradeCode: String): LiveData<List<CourseSubject>> =
        courseDao.queryCourseSubjectListByGrade(gradeCode)

    fun queryCourseUnitListBySubject(subjectCode: String): LiveData<List<CourseUnit>> =
        courseDao.queryCourseUnitListBySubject(subjectCode)

    fun queryCourseUnitCaseListByUnit(unitCode: String): LiveData<List<CourseUnitCase>> =
        courseDao.queryCourseUnitCaseListByUnit(unitCode)
}