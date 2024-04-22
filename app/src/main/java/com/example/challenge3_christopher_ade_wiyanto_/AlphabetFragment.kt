package com.example.challenge3_christopher_ade_wiyanto_


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.challenge3_christopher_ade_wiyanto_.databinding.FragmentAlphabetBinding

class AlphabetFragment : Fragment() {
    private lateinit var binding: FragmentAlphabetBinding
    private lateinit var alphabetAdapter: AlphabetAdapter
    private lateinit var alphabetList: List<AlphabetData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlphabetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAlphabetRecyclerView()
    }

    private fun navigateToWordFragment(alphabet: AlphabetData) {
        val bundle = Bundle().apply {
            putSerializable("key", alphabet)
        }
        findNavController().navigate(R.id.navigateToWordFragment, bundle)
    }

    private fun setupAlphabetRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 3)
        alphabetList = AlphabetListData.alphabetList
        alphabetAdapter = AlphabetAdapter(alphabetList, object : AlphabetItemListener {
            override fun onItemClick(alphabet: AlphabetData) {
                navigateToWordFragment(alphabet)
            }
        })
        binding.rvAlphabet.apply {
            adapter = alphabetAdapter
            this.layoutManager = layoutManager
        }
    }
}
