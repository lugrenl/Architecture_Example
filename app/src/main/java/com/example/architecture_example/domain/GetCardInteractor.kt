package com.example.architecture_example.domain

import com.example.architecture_example.data.CardRepository
import com.example.architecture_example.domain.model.CardData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCardInteractor(private val cardRepository: CardRepository = CardRepository()) {

    suspend fun getCard(): CardData = withContext(Dispatchers.IO) {
        val card = cardRepository.getCard()

        CardData(
            name = card.name,
            brand = card.brand,
            category = card.category
        )
    }
}