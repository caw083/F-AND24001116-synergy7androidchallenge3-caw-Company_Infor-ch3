package com.example.challenge3_christopher_ade_wiyanto_

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        val companyCategory = arrayOf(
            "Financial", "Industry", "Raw Material", "Technology",
            "LuxuryGoods", "Transportation", "Energy", "Health"
        )
        val imageDataSet = arrayOf(
            "keuangan", "factory", "raw_material", "technology",
            "luxurygoods", "zeppelin", "energy", "health"
        )

        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = CategoryAdapter(companyCategory, imageDataSet) { category ->
            navigateToCompanyFragment(category)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    private fun navigateToCompanyFragment(category: String) {
        val bundle = Bundle().apply {
            putString("category", category)
        }
        findNavController().navigate(R.id.navigateToCompanyFragment, bundle)
    }
}
