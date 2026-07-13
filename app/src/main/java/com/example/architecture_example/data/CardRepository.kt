package com.example.architecture_example.data

import com.example.architecture_example.data.model.CardResponse
import com.example.architecture_example.data.model.ProductCountResponse
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

class CardRepository {
    suspend fun getCard(): CardResponse {
        delay(1500.milliseconds) // Simulate network delay
        if (Random.nextFloat() < 0.2f) { // 20% chance of failure
            throw Exception("Ошибка сети")
        }
        return getCardMock()
    }

    suspend fun getProductCount(): ProductCountResponse {
        delay(1000.milliseconds) // Simulate network delay
        return getProductCountMock()
    }
}