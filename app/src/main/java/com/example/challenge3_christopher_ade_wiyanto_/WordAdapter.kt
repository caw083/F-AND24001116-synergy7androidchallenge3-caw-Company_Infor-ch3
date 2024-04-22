package com.example.challenge3_christopher_ade_wiyanto_

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge3_christopher_ade_wiyanto_.databinding.WordItemBinding
import android.content.Intent
import android.net.Uri


class WordAdapter(private var listOfWords: List<Word>) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    inner class WordViewHolder(val binding: WordItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = WordItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = listOfWords[position]
        holder.binding.tvWords.text = word.words
        holder.itemView.setOnClickListener {
            val searchQuery = "https://www.google.com/search?q=${word.words}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchQuery))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listOfWords.size
}