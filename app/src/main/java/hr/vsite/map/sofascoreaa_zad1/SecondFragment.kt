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
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    private val viewModel: ContactsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_second, container, false)
        viewModel.contacts.observe(viewLifecycleOwner, Observer { contacts ->
            val stringBuilder = StringBuilder()
            contacts.forEach { contact: Contact ->
                stringBuilder.append("$contact\n\n")
            }
            tv_contacts.text = stringBuilder.toString()
        })

        return root
    }
}