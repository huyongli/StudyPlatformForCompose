package com.laohu.study.platform.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//学段
@Entity(tableName = "course_phase")
data class CoursePhase(
    @PrimaryKey
    @ColumnInfo(name = "phase_code")
    val phaseCode: String,
    @ColumnInfo(name = "phase_name")
    val phaseName: String,
)

//年级
@Entity(tableName = "course_grade")
data class CourseGrade(
    @PrimaryKey
    @ColumnInfo(name = "grade_code")
    val gradeCode: String,
    @ColumnInfo(name = "grade_name")
    val gradeName: String,
    @ColumnInfo(name = "phase_code")
    val phaseCode: String,
)

//科目
@Entity(tableName = "course_subject")
data class CourseSubject(
    @PrimaryKey
    @ColumnInfo(name = "subject_code")
    val subjectCode: String,
    @ColumnInfo(name = "subject_name")
    val subjectName: String,
    @ColumnInfo(name = "grade_code")
    val gradeCode: String
)

//单元
@Entity(tableName = "course_unit")
data class CourseUnit(
    @PrimaryKey
    @ColumnInfo(name = "unit_code")
    val unitCode: String,
    @ColumnInfo(name = "unit_name")
    val unitName: String,
    @ColumnInfo(name = "unit_desc")
    val unitDesc: String?,
    @ColumnInfo(name = "subject_code")
    val subjectCode: String
)

//单元case
@Entity(tableName = "course_unit_case")
data class CourseUnitCase(
    @PrimaryKey
    @ColumnInfo(name = "unit_case_code")
    val caseCode: String,
    @ColumnInfo(name = "unit_case_name")
    val caseName: String,
    @ColumnInfo(name = "unit_case_teacher")
    val caseTeacher: String?,
    @ColumnInfo(name = "unit_case_guide_teacher")
    val caseGuideTeacher: String?,
    @ColumnInfo(name = "unit_case_thumb_url")
    val caseThumbUrl: String?,
    @ColumnInfo(name = "unit_code")
    val unitCode: String,
) {
    val videoUrl: String
        get() {
            val thumbUrl = caseThumbUrl ?: return ""
            val start = thumbUrl.lastIndexOf("/")
            val end = thumbUrl.lastIndexOf(".")
            val fileName = thumbUrl.substring(start, end)
            val videoUrlPrefix = thumbUrl.substring(0, start).replace("/pic", "/video")
            return if (fileName.endsWith(MP4)) {
                "$videoUrlPrefix${fileName.replace(MP4, "")}.mp4"
            } else {
                "$videoUrlPrefix${fileName.replace(M3U8, "")}.m3u8"
            }
        }
}

private const val MP4 = "00000000"
private const val M3U8 = "00001000"
