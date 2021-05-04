package hr.vsite.map.sofascoreaa_zad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cities.City
import hr.vsite.map.sofascoreaa_zad1.databinding.ActivityCollapsibleToolbarBinding

class CollapsibleToolbarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollapsibleToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollapsibleToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        val contact = intent.getSerializableExtra("contact") as City
        var cUrl = intent.getStringExtra("url")

        var cAge = intent.getStringExtra("age")
        var cOib = intent.getStringExtra("oib")
        var cNumber = intent.getStringExtra("number")
        var cGender = intent.getStringExtra("gender")
        var cLanguage = intent.getStringExtra( "language")

        var cName = contact.firstName + " " + contact.lastName

        //binding.backdrop.setImageResource(cUrl.toInt())
        binding.titleOnAppbar.text = cName
        binding.subtitleOnAppbar.text = cOib
        binding.title.text = cName
        binding.age.text = cAge
        binding.oib.text = cOib
        binding.number.text = cNumber
        binding.gender.text = cGender
        binding.language.text = cLanguage


         */
    }
}

