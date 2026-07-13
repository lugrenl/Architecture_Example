package com.example.architecture_example.domain.repository

import com.example.architecture_example.domain.model.CardData
import com.example.architecture_example.domain.model.ProductCountData

interface CardRepository {
    suspend fun getCard(): CardData
    suspend fun getProductCount(): ProductCountData
}
