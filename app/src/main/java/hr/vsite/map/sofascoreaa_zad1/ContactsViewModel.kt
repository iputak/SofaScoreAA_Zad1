package hr.vsite.map.sofascoreaa_zad1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import contacts.Contact

class ContactsViewModel () : ViewModel(){

    val contacts = MutableLiveData<ArrayList<Contact>>()
    init {
        contacts.value = arrayListOf()
    }

    fun addContact(contact: Contact) {
    // Do an asynchronous operation to fetch users.
        contacts.value?.add(contact)
    }


}

