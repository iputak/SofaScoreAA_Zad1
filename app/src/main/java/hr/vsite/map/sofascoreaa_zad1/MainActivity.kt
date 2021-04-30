package hr.vsite.map.sofascoreaa_zad1

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import contacts.Contact
import hr.vsite.map.sofascoreaa_zad1.databinding.ActivityMainBinding
import hr.vsite.map.sofascoreaa_zad1.helpers.LanguageHelper
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.firstFragment, R.id.secondFragment, R.id.settingsFragment
            )
        )
        bottomNavigationView.setupWithNavController(navController)

        viewModel.addContact(Contact("https://www.sofascore.com/static/images/apple-icon-180x180.png", "Ivan", "Putak", 26, 44971009900, 385917644529, "Male", "Croatian"))
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LanguageHelper.wrapLanguage(newBase))
    }
}