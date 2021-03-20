package hr.vsite.map.sofascoreaa_zad1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import contacts.Contact
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    private val viewModel: ContactsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =  inflater.inflate(R.layout.fragment_first, container, false)
        val button = root.findViewById<Button>(R.id.button_add_contact)
        val firstName = root.findViewById<EditText>(R.id.et_first_Name)
        val lastName = root.findViewById<EditText>(R.id.et_last_name)
        val age = root.findViewById<EditText>(R.id.et_age)
        val oib = root.findViewById<EditText>(R.id.et_oib)
        val number = root.findViewById<EditText>(R.id.et_number)
        button.setOnClickListener {
            val contact = Contact(
                firstName.text.toString(),
                lastName.text.toString(),
                age.text.toString().toInt(),
                oib.text.toString().toLong(),
                number.text.toString().toLong()
            )
            viewModel.addContact(contact)
            et_first_Name.setText("")
            et_last_name.setText("")
            et_age.setText("")
            et_oib.setText("")
            et_number.setText("")
        }
        return root
    }
}