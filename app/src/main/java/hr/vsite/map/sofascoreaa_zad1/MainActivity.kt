package hr.vsite.map.sofascoreaa_zad1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import contacts.Contact
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*
import utilities.InjectorUtils


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)

        //val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment, R.id.secondFragment))
        initializeUI()
        bottomNavigationView.setupWithNavController(navController)

    }

    private fun initializeUI(){
        val factory = InjectorUtils.provideContactsViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(ContactsViewModel::class.java)

        viewModel.getContacts().observe(this, Observer { contacts ->
            val stringBuilder = StringBuilder()
            contacts.forEach { contact: Contact ->
                stringBuilder.append("$contact\n\n")
            }
            tv_contacts.text = stringBuilder.toString()
        })

        button_add_contact.setOnClickListener {

            val contact = Contact(et_first_Name.text.toString(), et_last_name.text.toString(), et_age.text.toString().toInt(), et_oib.text.toString().toInt(), et_number.text.toString().toInt())
            viewModel.addContact(contact)
            et_first_Name.setText("")
            et_last_name.setText("")
            et_age.setText("")
            et_oib.setText("")
            et_number.setText("")
        }
    }


}