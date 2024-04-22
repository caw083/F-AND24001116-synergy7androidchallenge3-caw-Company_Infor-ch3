package com.example.challenge3_christopher_ade_wiyanto_

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompanyListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_company_list, container, false)

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


        val category = arguments?.getString("category")
        val companies = categoryToCompaniesMap[category]

        // Initialize RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.companyRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Create and set adapter with the list of companies
        companies?.let {
            val adapter = companyListAdapter(it.toTypedArray())
            recyclerView.adapter = adapter
        }

        return view
    }
}