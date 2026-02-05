package pt.portugueseeats.kmp.domain.repository

import pt.portugueseeats.kmp.core.Result
import pt.portugueseeats.kmp.domain.Restaurant


interface RestaurantsRepository {

    suspend fun getRestaurants(): Result<List<Restaurant>>

}