package com.example.challenge3_christopher_ade_wiyanto_.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.challenge3_christopher_ade_wiyanto_.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerViewCategory = binding.recyclerView
        val companyCategory = arrayOf(
            "Financial", "Industry", "Raw Material", "Technology",
            "LuxuryGoods", "Transportation", "Energy", "Health"
        )
        val imageDataSet = arrayOf(
            "keuangan", "factory", "raw_material", "technology",
            "luxurygoods", "zeppelin", "energy", "health"
        )

        recyclerViewCategory.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerViewCategory.adapter = CategoryAdapterFragment(companyCategory, imageDataSet)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
