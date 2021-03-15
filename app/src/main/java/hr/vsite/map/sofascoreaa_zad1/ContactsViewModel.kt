package hr.vsite.map.sofascoreaa_zad1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import contacts.Contact
import contacts.ContactRepository

class ContactsViewModel (private val contactRepository: ContactRepository) : ViewModel(){
    //fun getContacts() = contactRepository.getContacts()
    //fun addContact(contact: Contact)=  contactRepository.addContact(contact)

    private val contacts: MutableLiveData<List<Contact>> by lazy {
        MutableLiveData().also {
            loadContacts()
        }
    }

    fun getContacts(): LiveData<List<Contact>> {
        contactRepository.getContacts()
        return contacts
    }

    fun loadContacts(contact: Contact) {
    // Do an asynchronous operation to fetch users.
        contactRepository.addContact(contact)
    }


}

