package com.example.architecture_example.data

import com.example.architecture_example.data.model.CardResponse
import com.example.architecture_example.data.model.ProductCountResponse

fun getCardMock(): CardResponse = CardResponse(
    name = "Тестовое название товара",
    brand = "Тестовое название бренда",
    category = "Тестовое название категории"
)

fun getProductCountMock(): ProductCountResponse = ProductCountResponse(
    count = 16
)