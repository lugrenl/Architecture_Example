package com.example.architecture_example.data

import com.example.architecture_example.data.model.CardResponse
import com.example.architecture_example.data.model.ProductCountResponse
import com.example.architecture_example.domain.model.CardData
import com.example.architecture_example.domain.model.ProductCountData
import com.example.architecture_example.domain.repository.CardRepository
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

class CardRepositoryImpl : CardRepository {
    override suspend fun getCard(): CardData {
        delay(1500.milliseconds) // Simulate network delay
        if (Random.nextFloat() < 0.2f) { // 20% chance of failure
            throw Exception("Ошибка сети")
        }
        val response = getCardMock()
        return CardData(
            name = response.name,
            brand = response.brand,
            category = response.category
        )
    }

    override suspend fun getProductCount(): ProductCountData {
        delay(1000.milliseconds) // Simulate network delay
        val response = getProductCountMock()
        return ProductCountData(count = response.count)
    }
}
