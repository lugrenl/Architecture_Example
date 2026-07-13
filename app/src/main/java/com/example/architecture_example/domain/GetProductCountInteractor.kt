package com.example.architecture_example.domain

import com.example.architecture_example.data.CardRepository
import com.example.architecture_example.domain.model.ProductCountData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetProductCountInteractor(
    private val cardRepository: CardRepository = CardRepository()
)
{

    suspend fun getProductCount(): ProductCountData = withContext(Dispatchers.IO) {
        val data = cardRepository.getProductCount()

        ProductCountData(count = data.count)
    }

}