package com.example.architecture_example.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture_example.domain.GetCardInteractor
import com.example.architecture_example.domain.GetProductCountInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getProductCountInteractor = GetProductCountInteractor()
    private val getCardInteractor = GetCardInteractor()

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val card = getCardInteractor.getCard()
                val amount = getProductCountInteractor.getProductCount()

                _state.update {
                    it.copy(
                        name = card.name,
                        brand = card.brand,
                        category = card.category,
                        count = amount.count,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = "Не удалось загрузить данные: ${e.message}"
                    )
                }
            }
        }
    }
}