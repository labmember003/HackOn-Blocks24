package com.falcon.unikit.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.falcon.unikit.api.Content
import com.falcon.unikit.models.item.SubjectItem
import com.falcon.unikit.repository.UnikitRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContentViewModel @Inject constructor(
    private val unikitRepository: UnikitRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val contents : StateFlow<List<Content>>
        get() = unikitRepository.content

    init {
        viewModelScope.launch {
            val subjectID = savedStateHandle.get<String>("subjectID") ?: "123"
            unikitRepository.getContent(subjectID)
        }
    }
}