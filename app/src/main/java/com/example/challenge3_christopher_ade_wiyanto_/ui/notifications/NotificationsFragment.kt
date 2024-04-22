package com.example.challenge3_christopher_ade_wiyanto_.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge3_christopher_ade_wiyanto_.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Access RecyclerView using binding object
        binding.CompanyListRecycleView.layoutManager = LinearLayoutManager(requireContext())
        val categoryToCompaniesMap = mapOf(
            "Technology" to listOf("apple", "google", "aws", "intel", "qualcom", "meta", "microsoft", "asml", "tsmc", "amd"),
            "Finance" to listOf("google", "aws"),
            "Industry" to listOf("apple", "google", "aws"),
            "Raw Material" to listOf("tsmc", "qualcom"),
            "Luxury Goods" to listOf("aws", "apple"),
            "Transportation" to listOf("apple"),
            "Energy" to listOf("tsmc", "asml"), // Corrected list of companies for "Energy"
            "Health" to listOf("google", "intel", "amd", "meta", "microsoft") // Corrected list of companies for "Health"
        )

        binding.CompanyListRecycleView.layoutManager = LinearLayoutManager(requireContext())

        // Set adapter for RecyclerView using binding object
        val technologyCompanies = categoryToCompaniesMap["Technology"] ?: emptyList()
        binding.CompanyListRecycleView.adapter = companyListAdapter(technologyCompanies.toTypedArray())

        // Create and set adapter for alphabet RecyclerView
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
