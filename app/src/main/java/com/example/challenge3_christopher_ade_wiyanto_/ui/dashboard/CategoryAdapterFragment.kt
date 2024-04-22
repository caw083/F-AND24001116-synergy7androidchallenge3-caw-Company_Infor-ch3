package com.example.challenge3_christopher_ade_wiyanto_.ui.dashboard
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge3_christopher_ade_wiyanto_.R

class CategoryAdapterFragment(private val dataSet: Array<String>, private val imageDataSet: Array<String>) :
    RecyclerView.Adapter<CategoryAdapterFragment.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
        val imageView: ImageView = view.findViewById(R.id.imageView) // Add ImageView reference

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position]
        val resourceId = holder.itemView.context.resources.getIdentifier(
            imageDataSet[position],
            "drawable",
            holder.itemView.context.packageName
        )
        holder.imageView.setImageResource(resourceId)
    }
    override fun getItemCount() = dataSet.size
}
