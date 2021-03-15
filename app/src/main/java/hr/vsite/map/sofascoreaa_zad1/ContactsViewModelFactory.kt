package hr.vsite.map.sofascoreaa_zad1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import contacts.ContactRepository

class ContactsViewModelFactory (private val contactRepository: ContactRepository) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContactsViewModel(contactRepository) as T
    }
}