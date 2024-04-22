package com.example.challenge3_christopher_ade_wiyanto_
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.net.Uri

class companyListAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<companyListAdapter.CompanyListViewHolder>() {
    class CompanyListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_title)
        val imageView: ImageView = view.findViewById(R.id.image_poster)
        init {
            // Set click listener for the item view
            itemView.setOnClickListener {
                val companyName = textView.text.toString()
                // Perform Google search when an item is clicked
                val searchQuery = "https://www.google.com/search?q=${companyName}_Inc"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchQuery))
                itemView.context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.company_list, parent, false)
        return CompanyListViewHolder(view)
    }
    override fun onBindViewHolder(holder: CompanyListViewHolder, position: Int) {
        holder.textView.text = dataSet[position].capitalize()
        val resourceId = holder.itemView.context.resources.getIdentifier(
            dataSet[position],
            "drawable",
            holder.itemView.context.packageName
        )
        holder.imageView.setImageResource(resourceId)
    }
    override fun getItemCount() = dataSet.size
}
