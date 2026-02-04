package pt.portugueseeats.kmp.presentation.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pt.portugueseeats.kmp.core.Result
import pt.portugueseeats.kmp.domain.use_case.GetRestaurantsUseCase

class RestaurantsViewModel(
    private val getRestaurants: GetRestaurantsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(RestaurantsUiState())
    val state: StateFlow<RestaurantsUiState> = _state

    fun load() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            when (val result = getRestaurants()) {
                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            restaurants = result.data
                        )
                    }
                }

                is Result.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.error
                        )
                    }
                }
            }
        }
    }
}