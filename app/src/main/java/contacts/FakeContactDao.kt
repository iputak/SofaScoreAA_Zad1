package contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeContactDao {
    private val contactList = mutableListOf <Contact>()
    private val contacts= MutableLiveData<List<Contact>>()

    init{
        contacts.value = contactList
    }

    fun addContact(contact: Contact){
        contactList.add(contact)
        contacts.value = contactList
    }

    fun getContacts() = contacts as LiveData<List<Contact>>
}