package hr.vsite.map.sofascoreaa_zad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import hr.vsite.map.sofascoreaa_zad1.databinding.ActivityAboutBinding
import hr.vsite.map.sofascoreaa_zad1.databinding.ActivityMainBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    private val viewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //reference to ImageView
        val backClick = binding.backButton as ImageView
        backClick.setOnClickListener {
            finish()
        }
    }


}