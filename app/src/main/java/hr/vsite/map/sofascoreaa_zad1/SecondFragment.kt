package hr.vsite.map.sofascoreaa_zad1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cities.adapter.CitiesRecyclerAdapter
import hr.vsite.map.sofascoreaa_zad1.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    //private val viewModel: ContactsViewModel by activityViewModels()
    private val viewModel: CityViewModel by activityViewModels()

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        val root = binding.root

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.contacts.observe(viewLifecycleOwner, {
            val adapter = CitiesRecyclerAdapter(requireContext(),it)
            binding.recyclerView.adapter = adapter
        })
        return root
    }
}