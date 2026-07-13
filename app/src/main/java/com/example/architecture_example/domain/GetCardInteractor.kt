package com.example.architecture_example.domain

import com.example.architecture_example.domain.model.CardData
import com.example.architecture_example.domain.repository.CardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCardInteractor(
    private val cardRepository: CardRepository
) {
    suspend fun getCard(): CardData = withContext(Dispatchers.IO) {
        cardRepository.getCard()
    }
}
