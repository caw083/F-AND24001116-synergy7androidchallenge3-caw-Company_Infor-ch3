package com.example.challenge3_christopher_ade_wiyanto_

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge3_christopher_ade_wiyanto_.databinding.AlphabetItemBinding

class AlphabetAdapter(private val listAlphabet: List<AlphabetData>, private val listener: AlphabetItemListener) :
    RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder>() {

    inner class AlphabetViewHolder(val binding: AlphabetItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetViewHolder {
        val binding = AlphabetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlphabetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlphabetViewHolder, position: Int) {
        val alphabet = listAlphabet[position]
        holder.binding.apply {
            tvAlphabet.text = alphabet.character.toString()
            root.setOnClickListener {
                listener.onItemClick(alphabet)
            }
        }
    }

    override fun getItemCount(): Int = listAlphabet.size
}

interface AlphabetItemListener {
    fun onItemClick(alphabet:AlphabetData )
}
