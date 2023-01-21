package com.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    //    var name = MutableLiveData<String>()
    var name = MutableLiveData("")
//    var name: LiveData<String> = _name
//    private var _name = shoe.value?.name
//    val name = Transformations.map(_shoe) { it.name }

    //    var company = MutableLiveData<String>()
    var company = MutableLiveData("")
//    var company: LiveData<String> = _company
//    private var _company = shoe.value?.company

    //    var size = MutableLiveData<String>()
    var size = MutableLiveData("")
//    var size: LiveData<String> = _size
//    private var _size = shoe.value?.size

    //    var description = MutableLiveData<String>()
    var description = MutableLiveData("")
//    var description: LiveData<String> = _description
//    private var _description = shoe.value?.description


    private var _shoeList = MutableLiveData<List<String>>()
    var shoeList: LiveData<List<String>> = _shoeList


    fun addNewShoe() {

        val newShoe =
            "Name: ${name.value} \nCompany: ${company.value} \nSize: ${size.value} \nDescription: ${description.value} \n\n"

        val currentShoes = shoeList.value ?: emptyList()
//        _shoeList.postValue(currentShoes + newShoe)
        _shoeList.value = currentShoes.plus(newShoe)
    }

}
