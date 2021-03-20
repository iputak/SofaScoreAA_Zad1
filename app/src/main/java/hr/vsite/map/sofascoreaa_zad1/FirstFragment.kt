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
import hr.vsite.map.sofascoreaa_zad1.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {
    private val viewModel: ContactsViewModel by activityViewModels()

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.buttonAddContact.setOnClickListener {
            val contact = Contact(
                binding.etFirstName.text.toString(),
                binding.etLastName.text.toString(),
                binding.etAge.text.toString().toInt(),
                binding.etOib.text.toString().toLong(),
                binding.etNumber.text.toString().toLong()
            )
            viewModel.addContact(contact)
            binding.etFirstName.setText("")
            binding.etLastName.setText("")
            binding.etAge.setText("")
            binding.etOib.setText("")
            binding.etNumber.setText("")
        }
        return root
    }
}