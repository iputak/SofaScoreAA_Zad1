package hr.vsite.map.sofascoreaa_zad1

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import contacts.Contact
import hr.vsite.map.sofascoreaa_zad1.databinding.FragmentFirstBinding

class CityFragment : Fragment() {
    private val viewModel: ContactsViewModel by activityViewModels()

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val root = binding.root
        var spinner = ""
        var gender = "Male"
        //Add button click
        binding.buttonAddContact.setOnClickListener {
            if(binding.etFirstName.validate() && binding.etLastName.validate() && binding.etAge.validate() && binding.etOib.validate() && binding.etNumber.validate()) {
                val contact = Contact(
                    binding.etImage.getCurrentText(),
                    binding.etFirstName.getCurrentText(),
                    binding.etLastName.getCurrentText(),
                    binding.etAge.getCurrentText().toInt(),
                    binding.etOib.getCurrentText().toLong(),
                    binding.etNumber.getCurrentText().toLong(),
                    gender,
                    spinner
                )
                //Dodavanje unesenih podataka
                viewModel.addContact(contact)
                //Kreiranje snackbar-a
                createSnackbar()
                //Reset EditText-ova
                binding.etImage.reset()
                binding.etFirstName.reset()
                binding.etLastName.reset()
                binding.etAge.reset()
                binding.etOib.reset()
                binding.etNumber.reset()
            }
        }

        //Spinner
        val options = resources.getStringArray(R.array.languages_array)
        binding.spOption.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, options)
        binding.spOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                spinner = options[position]
            }
        }

        binding.radioGroup.radioMale.setOnClickListener { gender = "Male" }
        binding.radioGroup.radioFemale.setOnClickListener { gender = "Female" }

        return root
    }

    private fun createSnackbar() {

        activity?.let {
            Snackbar.make(it.findViewById(android.R.id.content), R.string.snackbarPost, Snackbar.LENGTH_LONG)
                .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE)
                .setBackgroundTint(Color.BLACK)
                .setAction(R.string.ok){
                    Toast.makeText(activity, R.string.toastPost, Toast.LENGTH_LONG).show()
                }.show()
        }
    }
}