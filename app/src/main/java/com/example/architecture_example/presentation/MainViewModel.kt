package com.example.architecture_example.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture_example.data.CardRepositoryImpl
import com.example.architecture_example.data.model.MainState
import com.example.architecture_example.domain.GetCardInteractor
import com.example.architecture_example.domain.GetProductCountInteractor
import com.example.architecture_example.domain.model.CardData
import com.example.architecture_example.domain.model.ProductCountData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = CardRepositoryImpl()
    private val getProductCountInteractor = GetProductCountInteractor(repository)
    private val getCardInteractor = GetCardInteractor(repository)

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val card: CardData = getCardInteractor.getCard()
                val amount: ProductCountData = getProductCountInteractor.getProductCount()

                _state.update {
                    it.copy(
                        name = card.name,
                        brand = card.brand,
                        category = card.category,
                        count = amount.count,
                        features = listOf(
                            "Высокое качество материалов",
                            "Гарантия от производителя 2 года",
                            "Экологически чистое производство",
                            "Быстрая доставка по всей стране",
                            "Поддержка 24/7",
                            "Скидка на следующую покупку",
                            "Подарочная упаковка в комплекте"
                        ),
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
