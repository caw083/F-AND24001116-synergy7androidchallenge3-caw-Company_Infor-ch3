package com.example.challenge3_christopher_ade_wiyanto_

import java.io.Serializable

data class Category(
    val id: Int,
    val name: String,
    val listCompany: List<Company>
) : Serializable