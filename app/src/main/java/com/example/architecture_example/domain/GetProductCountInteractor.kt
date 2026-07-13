package com.example.architecture_example.domain

import com.example.architecture_example.domain.model.ProductCountData
import com.example.architecture_example.domain.repository.CardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetProductCountInteractor(
    private val cardRepository: CardRepository
) {
    suspend fun getProductCount(): ProductCountData = withContext(Dispatchers.IO) {
        cardRepository.getProductCount()
    }
}
