package hr.vsite.map.sofascoreaa_zad1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cities.City

import hr.vsite.map.sofascoreaa_zad1.networking.model.CityResponse

class CityViewModel () : ViewModel(){

    val contacts = MutableLiveData<ArrayList<City>>()
    val city = MutableLiveData<ArrayList<CityResponse>>()
    init {
        contacts.value = arrayListOf()
    }

    fun addCity(city: City) {
    // Do an asynchronous operation to fetch users.
        contacts.value?.add(city)
    }


}

