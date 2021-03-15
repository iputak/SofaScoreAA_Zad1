package contacts

data class Contact(val firstName: String, val lastName: String, val age: Int, val oib: Int, val number: Int){
    override fun toString(): String {
        return "$firstName $lastName, $age, $oib, $number"
    }
}