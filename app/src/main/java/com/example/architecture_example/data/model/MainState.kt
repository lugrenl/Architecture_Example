package com.example.architecture_example.data.model

data class MainState(
    val name: String = "",
    val brand: String = "",
    val category: String = "",
    val count: Int = 0,
    val features: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
