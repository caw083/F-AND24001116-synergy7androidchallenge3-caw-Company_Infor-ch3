package com.example.challenge3_christopher_ade_wiyanto_

object Company_List {
    val company_list: List<Category> =
        listOf(
            Category(
                id = 1,
                name = "technology",
                listCompany = listOf(
                    Company(1, "apple"),
                    Company(2, "google"),
                    Company(3, "aws"),
                    Company(4, "Apache")
                )
            )
        )
}
