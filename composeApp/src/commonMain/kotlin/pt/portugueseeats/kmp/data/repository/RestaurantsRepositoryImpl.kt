package pt.portugueseeats.kmp.data.repository

import pt.portugueseeats.kmp.core.Result
import pt.portugueseeats.kmp.data.RestaurantApi
import pt.portugueseeats.kmp.data.network.extensions.toErrorEntity
import pt.portugueseeats.kmp.domain.Restaurant
import pt.portugueseeats.kmp.domain.repository.RestaurantsRepository
import pt.portugueseeats.kmp.mapper.toRestaurant

class RestaurantsRepositoryImpl(
    private val restaurantApi: RestaurantApi
) : RestaurantsRepository {
    override suspend fun getRestaurants(): Result<List<Restaurant>> {
        return try {
            val restaurants = restaurantApi.getRestaurants().map { it.toRestaurant() }
            Result.Success(restaurants)

        } catch (exception: Exception) {
            Result.Error(exception.toErrorEntity())
        }
    }
}