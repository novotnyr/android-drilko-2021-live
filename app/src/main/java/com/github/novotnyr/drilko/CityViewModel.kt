package com.github.novotnyr.drilko

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CityViewModel : ViewModel() {
    val selectedCity = MutableLiveData<String>()

    fun setSelectedCity(city: String) {
        selectedCity.value = city
    }
}