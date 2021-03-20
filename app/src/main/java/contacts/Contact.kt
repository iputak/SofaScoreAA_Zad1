package contacts

data class Contact(val firstName: String, val lastName: String, val age: Int, val oib: Long, val number: Long){
    override fun toString(): String {
        return "$firstName $lastName, $age, $oib, $number"
    }
}