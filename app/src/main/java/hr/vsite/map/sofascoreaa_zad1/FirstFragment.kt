package hr.vsite.map.sofascoreaa_zad1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import contacts.Contact
import hr.vsite.map.sofascoreaa_zad1.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {
    private val viewModel: ContactsViewModel by activityViewModels()

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    var gender = "Male"
    var spinner = "Croatian"

    lateinit var option: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val root = binding.root

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
                viewModel.addContact(contact)
                binding.etFirstName.reset()
                binding.etLastName.reset()
                binding.etAge.setText("")
                binding.etOib.setText("")
                binding.etNumber.setText("")
            }
        }

        //Spinner
        val options = arrayOf("Croatian", "English")
       // Todo: Ovdje puca
        // option.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, options)
/*
        binding.spOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                spinner = options.get(position)
            }
        }
*/


        return root
    }
    // Todo: Puca na klik
    fun onRadioButtonClick(view: View){

        if (view is RadioButton){

            when(view.id){
                R.id.radio_male -> {
                    //gender = "Male"
                }
                R.id.radio_female -> {
                    //gender = "Female"
                }
            }
        }
    }

    private fun validate() :Boolean{
        if(binding.etFirstName.getCurrentText().isEmpty()){
            // Todo: postaviti error --> kako ga dohvatiti?

            return false
        }
        if(binding.etLastName.getCurrentText().isEmpty()){
            // Todo: postaviti error --> kako ga dohvatiti?

            return false
        }
        if(binding.etAge.toString().isEmpty()){
            binding.etAge.error = "Upisite godine"
            return false
        }
        if(binding.etOib.toString().isEmpty()){
            binding.etOib.error = "Upisite godine"
            return false
        }
        return true
    }
}