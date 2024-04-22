package com.example.challenge3_christopher_ade_wiyanto_

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.challenge3_christopher_ade_wiyanto_.databinding.FragmentWordBinding

class WordFragment : Fragment() {
    private lateinit var binding: FragmentWordBinding
    private lateinit var wordAdapter: WordAdapter
    private lateinit var wordList: List<Word>
    private lateinit var alphabet: AlphabetData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWordBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWordRecyclerView()
    }

    private fun generateWordList(): List<Word> {
        val bundle = arguments
        if (bundle != null) {
            alphabet = bundle.getSerializable("key") as AlphabetData
            return alphabet.listWords
        }
        return emptyList()
    }

    private fun setupWordRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        wordList = generateWordList()
        wordAdapter = WordAdapter(wordList)
        binding.rvWords.apply {
            adapter = wordAdapter
            this.layoutManager = layoutManager
        }
    }
}
