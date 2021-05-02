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