package contacts.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import contacts.Contact
import hr.vsite.map.sofascoreaa_zad1.R
import hr.vsite.map.sofascoreaa_zad1.databinding.ContactItemViewBinding

class ContactsRecyclerAdapter(private val context: Context, private val contactsList: ArrayList<Contact>) : RecyclerView.Adapter<ContactsRecyclerAdapter.ContactViewHolder>() {

    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ContactItemViewBinding.bind(view)
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