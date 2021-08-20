package com.laohu.study.platform.page.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.laohu.study.platform.model.CoursePhase
import com.laohu.study.platform.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val courseRepository: CourseRepository) : ViewModel() {
    val coursePhase: LiveData<List<CoursePhase>> = courseRepository.queryCoursePhaseList()
}