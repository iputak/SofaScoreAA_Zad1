package hr.vsite.map.sofascoreaa_zad1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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
        viewModel.contacts.observe(viewLifecycleOwner, Observer {

            val stringArray = arrayListOf<String>()
            for (contact in it){
                stringArray.add(contact.toString())
            }
            val adapter = ArrayAdapter(requireContext(), R.layout.text_view_row, stringArray)

            binding.listView.adapter = adapter
        })

        return root
    }
}