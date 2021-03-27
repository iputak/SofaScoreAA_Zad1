package hr.vsite.map.sofascoreaa_zad1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
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

        //Change app language
        val languageList = resources.getStringArray(R.array.languages_array)

        //Spinner

        binding.spLanguage.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, languageList)
        binding.spLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {

                }

        }
        return root
    }



}


