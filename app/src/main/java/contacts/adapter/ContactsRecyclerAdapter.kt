package contacts.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import contacts.Contact
import hr.vsite.map.sofascoreaa_zad1.CollapsibleToolbarActivity
import hr.vsite.map.sofascoreaa_zad1.MainActivity
import hr.vsite.map.sofascoreaa_zad1.R
import hr.vsite.map.sofascoreaa_zad1.databinding.ContactItemViewBinding
import kotlinx.android.synthetic.main.contact_item_view.view.*

class ContactsRecyclerAdapter(private val context: Context, private val contactsList: ArrayList<Contact>) : RecyclerView.Adapter<ContactsRecyclerAdapter.ContactViewHolder>() {


    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ContactItemViewBinding.bind(view)

        init{
            view.setOnClickListener{v: View ->
                val position: Int = adapterPosition
                println(position)
                val intent = Intent(view.context, CollapsibleToolbarActivity::class.java)

                //Todo: zamjeniti s pravim podatcima - kako dobiti podatak iz objekta koji se nalazi u ArrayList[position]
                //Slanje podataka activitiy-u CollapsibleToolbarActivity
                intent.putExtra("url", "https://www.sofascore.com/static/images/apple-icon-180x180.png")
                intent.putExtra("firstname", "Ivan" )
                intent.putExtra("lastname","Putak")
                intent.putExtra("age", "26")
                intent.putExtra("oib", "44971009900")
                intent.putExtra("number", "385917644529")
                intent.putExtra("gender","Male")
                intent.putExtra("language", "Croatian")
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(this.context).inflate(R.layout.contact_item_view, parent, false)
        return ContactViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactsList[position]
        //Coil part for image
        holder.binding.image.load(contact.imageUrl){
            placeholder(R.drawable.person_placeholder)
            transformations(RoundedCornersTransformation())
        }
        holder.binding.name.text ="${contact.lastName}, ${contact.firstName}"
        holder.binding.age.text = contact.age.toString()
        holder.binding.gender.text = contact.gender
        holder.binding.oib.text = contact.oib.toString()
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}