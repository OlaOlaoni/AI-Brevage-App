package com.example.brevageaiapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecognitionListViewModel: ViewModel() {

    private val _recognitionList = MutableLiveData<List<Recognition>>()
    val recognitionList: LiveData<List<Recognition>> get() = _recognitionList

    fun UpdateData(recognition: List<Recognition>){
        _recognitionList.postValue(recognition)
    }
}

data class Recognition (val label: String, val confidence: Float){

    override fun toString(): String {
        return "$label / $probabilityString"
    }

    // Output probability as a string to enable easy data binding
    val probabilityString = String.format("%.1f%%", confidence * 100.0f)
}