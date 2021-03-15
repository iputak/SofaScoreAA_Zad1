package contacts

class ContactRepository private constructor(private val contactDao: FakeContactDao){

    fun addContact(contact: Contact){
        contactDao.addContact(contact)
    }

    fun getContacts() = contactDao.getContacts()
    companion object{
        @Volatile private var instance: ContactRepository?= null
        fun getInstance(contactDao: FakeContactDao)=
            instance ?: synchronized(this) {
                instance ?: ContactRepository(contactDao).also { instance = it}
            }
    }
}