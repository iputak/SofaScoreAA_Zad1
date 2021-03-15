package utilities

import contacts.ContactRepository
import contacts.FakeDatabase
import hr.vsite.map.sofascoreaa_zad1.ContactsViewModelFactory

object InjectorUtils {
    fun provideContactsViewModelFactory(): ContactsViewModelFactory{
        val contactRepository = ContactRepository.getInstance(FakeDatabase.getInstance().contactDao)
        return ContactsViewModelFactory(contactRepository)
    }
}