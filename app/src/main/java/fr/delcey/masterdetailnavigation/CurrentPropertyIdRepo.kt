package fr.delcey.masterdetailnavigation

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object CurrentPropertyIdRepo {

    private val propertyIdMutableLiveData = MutableLiveData<String>()

    @MainThread
    fun setCurrentPropertyId(propertyId: String) {
        propertyIdMutableLiveData.value = propertyId
    }

    fun getCurrentPropertyIdLiveData(): LiveData<String> = propertyIdMutableLiveData

}