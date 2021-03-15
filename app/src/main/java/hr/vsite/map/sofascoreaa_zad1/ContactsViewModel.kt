package hr.vsite.map.sofascoreaa_zad1

import androidx.lifecycle.ViewModel
import contacts.Contact
import contacts.ContactRepository

class ContactsViewModel(private val contactRepository: ContactRepository) : ViewModel(){
    fun getContacts() = contactRepository.getContacts()
    fun addContact(contact: Contact)=  contactRepository.addContact(contact)

}