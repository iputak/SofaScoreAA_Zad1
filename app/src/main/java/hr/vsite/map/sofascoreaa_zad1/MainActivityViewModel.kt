package hr.vsite.map.sofascoreaa_zad1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import contacts.Contact
import hr.vsite.map.sofascoreaa_zad1.networking.Network
import hr.vsite.map.sofascoreaa_zad1.networking.model.City
import hr.vsite.map.sofascoreaa_zad1.networking.model.CityResponse
import hr.vsite.map.sofascoreaa_zad1.networking.model.LocationResponse
import kotlinx.coroutines.launch

class MainActivityViewModel() : ViewModel() {
    val contacts = MutableLiveData<ArrayList<Contact>>()

    //City

    val locationDetails = MutableLiveData<ArrayList<LocationResponse>>()
    val cityDetails = MutableLiveData<ArrayList<City>>()

    init {
        contacts.value = arrayListOf()
    }

    fun addContact(contact: Contact) {
        // Do an asynchronous operation to fetch users.
        contacts.value?.add(contact)
    }

    fun getCity(citySearchName: String) {
        viewModelScope.launch {
            val locationResponse = Network().getService().getLocation(citySearchName)
            locationDetails.value = locationResponse.woeid as ArrayList<LocationResponse>
            val cityId = locationDetails.value as Int
            val cityResponse = Network().getService().getCity(cityId)
            cityDetails.value = cityResponse.consolidated_weather as ArrayList<City>
        }
    }


}

