package pt.portugueseeats.kmp.domain.use_case

import pt.portugueseeats.kmp.core.Result
import pt.portugueseeats.kmp.domain.Restaurant
import pt.portugueseeats.kmp.domain.repository.RestaurantsRepository

class GetRestaurantsUseCase(
    private val repository: RestaurantsRepository
) {
    suspend operator fun invoke(): Result<List<Restaurant>> {
        return repository.getRestaurants()
    }
}