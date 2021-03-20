package hr.vsite.map.sofascoreaa_zad1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import contacts.Contact
import hr.vsite.map.sofascoreaa_zad1.databinding.FragmentFirstBinding
import hr.vsite.map.sofascoreaa_zad1.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    private val viewModel: ContactsViewModel by activityViewModels()

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        val root = binding.root
        viewModel.contacts.observe(viewLifecycleOwner, Observer { contacts ->
            val stringBuilder = StringBuilder()
            contacts.forEach { contact: Contact ->
                stringBuilder.append("$contact\n\n")
            }
            binding.tvContacts.text = stringBuilder.toString()
        })

        return root
    }
}