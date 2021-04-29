package hr.vsite.map.sofascoreaa_zad1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import hr.vsite.map.sofascoreaa_zad1.databinding.FragmentSettings2Binding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettings2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSettings2Binding.inflate(inflater, container, false)
        val root = binding.root

        //Change app language - spinner
        val languageList = resources.getStringArray(R.array.languages_array)
        binding.spLanguage.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, languageList)

        //Change city - spinner
        val cityList = resources.getStringArray(R.array.cities_array)
        binding.spCity.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, cityList)

        return root
    }
}


