package hr.vsite.map.sofascoreaa_zad1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import hr.vsite.map.sofascoreaa_zad1.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    private val viewModel: CityViewModel by activityViewModels()

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val root = binding.root
        var searchEditText = "Test123"

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Getting search editText
                searchEditText = binding.search.query.toString()
                binding.tvHeadline.text = searchEditText
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        binding.btTest.setOnClickListener {
            binding.tvAbout.text = ("Test1234")
        }

        return root
    }
}