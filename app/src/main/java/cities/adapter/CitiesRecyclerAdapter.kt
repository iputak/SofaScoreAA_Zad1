package cities.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import cities.City
import hr.vsite.map.sofascoreaa_zad1.CollapsibleToolbarActivity
import hr.vsite.map.sofascoreaa_zad1.R
import hr.vsite.map.sofascoreaa_zad1.databinding.SearchCityItemViewBinding


class CitiesRecyclerAdapter(private val context: Context, private val cityList: ArrayList<City>) : RecyclerView.Adapter<CitiesRecyclerAdapter.CitiesViewHolder>() {


    class CitiesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = SearchCityItemViewBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val view = LayoutInflater.from(this.context).inflate(R.layout.search_city_item_view, parent, false)
        return CitiesViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        val city = cityList[position]
        //Coil part for image
        /*val load = holder.binding.tempIcon.load(city.imageUrl) {
            placeholder(R.drawable.lc)
            transformations(RoundedCornersTransformation())
        }*/
        val abbr = city.weather_state_abbr

        //Location
        val loc = city.latt_long.split(".", ",") // split the text by spaces
        val locN = loc[1].take(2)
        var location = loc[0] + "°"+ loc[1].take(2) + "′N, " + loc[2] + "°"+ loc[3].take(2) + "′W"

        // TODO: Postaviti putanju prema dobivenom abbr-u
        val imgSource = R.drawable.lc
        holder.binding.tempIcon.setImageResource(imgSource)

        holder.binding.tvAbout.text = city.title

        //holder.binding.tvLocation.text = city.age.toString() + ", " + city.firstName
        //holder.binding.tvDistance.text = city.gender
        //holder.binding.tvTemp.text = city.oib.toString()

        holder.binding.root.setOnClickListener{v: View ->
            println(position)
            val intent = Intent(holder.binding.root.context, CollapsibleToolbarActivity::class.java)
            intent.putExtra("city", city)
            //Slanje podataka activitiy-u CollapsibleToolbarActivity
            intent.putExtra("url", "https://www.sofascore.com/static/images/apple-icon-180x180.png")
            intent.putExtra("firstname", "Ivan" )
            intent.putExtra("lastname","Putak")
            intent.putExtra("age", "26")
            intent.putExtra("oib", "44971009900")
            intent.putExtra("number", "385917644529")
            intent.putExtra("gender","Male")
            intent.putExtra("language", "Croatian")
            holder.binding.root.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return cityList.size
    }
}