package com.lianwenhong.tradition_app.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val randomTxt = listOf("Oh My God !!!", "Ur so Handsome", "So Great")

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    override fun onCleared() {
        super.onCleared()
        Log.d("lianwenhong", " >>> onCleared() invoked <<<")
    }
}