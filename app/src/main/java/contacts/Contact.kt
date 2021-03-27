package contacts

import android.widget.Spinner

data class Contact(val imageUrl:String, val firstName: String, val lastName: String, val age: Int, val oib: Long, val number: Long, val gender: String, val spinner: String){
    override fun toString(): String {
        return "$imageUrl, $firstName $lastName, $age, $oib, $number, $gender, $spinner"
    }
}