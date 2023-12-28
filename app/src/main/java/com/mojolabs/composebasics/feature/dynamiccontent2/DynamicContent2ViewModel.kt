package com.mojolabs.composebasics.feature.dynamiccontent2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DynamicContent2ViewModel : ViewModel() {

    val newNameState = MutableLiveData("")

    fun updateNewName(value: String) {
        newNameState.value = value
    }

    val nameListState = MutableLiveData(mutableListOf<String>())

    fun updateNameList(value: String) {
        nameListState.value?.add(value)
    }
}
