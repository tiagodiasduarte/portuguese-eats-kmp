package pt.portugueseeats.kmp.presentation.restaurants

import pt.portugueseeats.kmp.domain.Restaurant
import pt.portugueseeats.kmp.domain.error.ErrorEntity

data class RestaurantsUiState(
    val isLoading: Boolean = false,
    val restaurants: List<Restaurant> = emptyList(),
    val error: ErrorEntity? = null
)
