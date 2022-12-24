package com.anish.createlivedatafromscratch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var counter: Int = 0

    val dataProvider: MutableLiveData<Int> = MutableLiveData()
    val myDataProvider: MyOwnLiveData<Int> = MyOwnLiveData()

    fun runCounter() {
        viewModelScope.launch {
            while (counter < 10) {
                counter += 1
                dataProvider.postValue(counter)
                myDataProvider.postValue(counter)
                delay(1000)
            }
        }
    }

}