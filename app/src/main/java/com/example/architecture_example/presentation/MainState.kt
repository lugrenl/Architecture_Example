package com.example.architecture_example.presentation

data class MainState(
    val name: String = "",
    val brand: String = "",
    val category: String = "",
    val count: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null
)