package hr.vsite.map.sofascoreaa_zad1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import contacts.Contact
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*
import utilities.InjectorUtils

class SecondFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    private fun initializeUI(){
        val factory = InjectorUtils.provideContactsViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(ContactsViewModel::class.java)

        viewModel.getContacts().observe(viewLifecycleOwner, Observer { contacts ->
            val stringBuilder = StringBuilder()
            contacts.forEach { contact: Contact ->
                stringBuilder.append("$contact\n\n")
            }
            tv_contacts.text = stringBuilder.toString()
        })
/*
        button_add_contact.setOnClickListener {

            val contact = Contact(et_first_Name.text.toString(), et_last_name.text.toString(), et_age.text.toString().toInt(), et_oib.text.toString().toInt(), et_number.text.toString().toInt())
            viewModel.loadContacts(contact)
            et_first_Name.setText("")
            et_last_name.setText("")
            et_age.setText("")
            et_oib.setText("")
            et_number.setText("")
        }
    */

    }
}