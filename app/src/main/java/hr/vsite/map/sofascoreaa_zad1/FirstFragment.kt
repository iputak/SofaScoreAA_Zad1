package hr.vsite.map.sofascoreaa_zad1

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import contacts.Contact
import hr.vsite.map.sofascoreaa_zad1.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {
    private val viewModel: ContactsViewModel by activityViewModels()

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!



    lateinit var ACTIVITY: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val root = binding.root
        var spinner = ""
        var gender = "Male"
        //Add button click
        binding.buttonAddContact.setOnClickListener {
            if(validate()){
                val contact = Contact(
                    binding.etFirstName.getCurrentText(),
                    binding.etLastName.getCurrentText(),
                    binding.etAge.text.toString().toInt(),
                    binding.etOib.text.toString().toLong(),
                    binding.etNumber.text.toString().toLong(),
                    gender,
                    spinner
                )
                //Dodavanje unesenih podataka
                viewModel.addContact(contact)
                //Reset EditText-ova
                binding.etFirstName.reset()
                binding.etLastName.reset()
                binding.etAge.setText("")
                binding.etOib.setText("")
                binding.etNumber.setText("")
            }
        }

        //Spinner
        val options = arrayOf("Croatian", "English")
        binding.spOption.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, options)
        binding.spOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                spinner = options.get(position)
            }
        }

        binding.radioGroup.radioMale.setOnClickListener { gender = "Male" }
        binding.radioGroup.radioFemale.setOnClickListener { gender = "Female" }

        return root
    }
    // Todo: Puca na klik

    private fun validate() :Boolean{
        var flag = true
        if(binding.etFirstName.getCurrentText().isNullOrEmpty()){

            flag = false
        }
        if(binding.etLastName.getCurrentText().isNullOrEmpty()){

            flag = false
        }
        if(binding.etAge.text.toString().isNullOrEmpty()){
            binding.etAge.error = "Enter your age"
            flag = false
        }
        if(binding.etOib.text.toString().isNullOrEmpty()){
            binding.etOib.error = "Enter your OIB"
            flag = false
        }
        if(binding.etNumber.text.toString().isNullOrEmpty()){
            binding.etNumber.error = "Enter your number"
            flag = false
        }
        return flag
    }
}