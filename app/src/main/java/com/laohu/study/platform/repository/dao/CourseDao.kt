package com.laohu.study.platform.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.laohu.study.platform.model.CourseGrade
import com.laohu.study.platform.model.CoursePhase
import com.laohu.study.platform.model.CourseSubject
import com.laohu.study.platform.model.CourseUnit
import com.laohu.study.platform.model.CourseUnitCase

@Dao
interface CourseDao {

    @Query("select * from course_phase")
    fun queryCoursePhaseList(): LiveData<List<CoursePhase>>

    @Query("select * from course_grade where phase_code = :phaseCode")
    fun queryCourseGradeListByPhase(phaseCode: String): LiveData<List<CourseGrade>>

    @Query("select * from course_subject where grade_code = :gradeCode")
    fun queryCourseSubjectListByGrade(gradeCode: String): LiveData<List<CourseSubject>>

    @Query("select * from course_unit where subject_code = :subjectCode")
    fun queryCourseUnitListBySubject(subjectCode: String): LiveData<List<CourseUnit>>

    @Query("select * from course_unit_case where unit_code = :unitCode")
    fun queryCourseUnitCaseListByUnit(unitCode: String): LiveData<List<CourseUnitCase>>
}