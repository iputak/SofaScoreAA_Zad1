package hr.vsite.map.sofascoreaa_zad1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import contacts.Contact
import hr.vsite.map.sofascoreaa_zad1.networking.model.CityResponse

class ContactsViewModel () : ViewModel(){

    val contacts = MutableLiveData<ArrayList<Contact>>()
    val city = MutableLiveData<ArrayList<CityResponse>>()
    init {
        contacts.value = arrayListOf()
    }

    fun addContact(contact: Contact) {
    // Do an asynchronous operation to fetch users.
        contacts.value?.add(contact)
    }


}

