package com.anveshreddyt.fifththirdcodetest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anveshreddyt.fifththirdcodetest.model.ServicesSetterGetter
import com.anveshreddyt.fifththirdcodetest.repository.MainActivityRepository

class MainActivityViewModel: ViewModel() {

    var servicesLiveData: MutableLiveData<ServicesSetterGetter>? = null

    fun getTemperature(tag: Any): LiveData<ServicesSetterGetter>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall(tag)
        return servicesLiveData
    }

}