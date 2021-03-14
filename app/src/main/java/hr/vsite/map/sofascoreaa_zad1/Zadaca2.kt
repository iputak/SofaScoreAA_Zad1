package hr.vsite.map.sofascoreaa_zad1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class Zadaca2 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onTap(view: View) {
        if (gumb.text == "Hide"){
            tv_poruka.visibility= View.INVISIBLE
            gumb.setText(R.string.show)
        } else{
            tv_poruka.visibility= View.VISIBLE
            gumb.setText(R.string.hide)
        }

    }
}