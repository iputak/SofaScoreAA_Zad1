package contacts

class FakeDatabase private constructor(){

    var contactDao = FakeContactDao()
    private set

    companion object{
        @Volatile private var instance: FakeDatabase?= null
        fun getInstance()=
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it}
            }
    }
}