package com.example.newsapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBordingViewModel @Inject constructor(
    private val appEntryUseCases : AppEntryUseCases
): ViewModel() {

    fun onEvent(event: OnBordingEvent){
        when(event){
            is OnBordingEvent.SaveAppEntry ->{
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry(){
       viewModelScope.launch{
           appEntryUseCases.saveAppEntry()
       }
    }
}

