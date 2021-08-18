package com.laohu.study.platform.model

import com.google.gson.annotations.SerializedName

//学段
data class CoursePhase(
    @SerializedName("xueDuanName")
    val name: String,
    @SerializedName("xueDuanCode")
    val code: String,
    @SerializedName("nianJiList")
    val gradeList: List<CourseGrade>
)

//年级
data class CourseGrade(
    @SerializedName("njName")
    val name: String,
    @SerializedName("njCode")
    val code: String,
    @SerializedName("subjectsList")
    val subjectList: List<CourseSubject>
)

//科目
data class CourseSubject(
    @SerializedName("xkName")
    val name: String,
    @SerializedName("xkCode")
    val code: String,
    @SerializedName("danYuanList")
    val unitList: List<CourseUnit>
)

//单元
data class CourseUnit(
    @SerializedName("danyuanName")
    val name: String,
    @SerializedName("danyuanCode")
    val code: String,
    @SerializedName("danYuanText")
    val desc: String,
    @SerializedName("caseList")
    val caseList: List<CourseUnitCase>
)

//单元case
data class CourseUnitCase(
    @SerializedName("caseCode")
    val code: String,
)

