package com.laohu.study.platform.page.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.laohu.study.platform.model.CoursePhase
import com.laohu.study.platform.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val courseRepository: CourseRepository) : ViewModel() {
    val coursePhase: LiveData<List<CoursePhase>> = courseRepository.queryCoursePhaseList()
}