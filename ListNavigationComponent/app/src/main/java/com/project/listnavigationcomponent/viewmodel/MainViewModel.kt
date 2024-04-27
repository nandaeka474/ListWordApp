package com.project.listnavigationcomponent.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val isListView = MutableLiveData(true)
}