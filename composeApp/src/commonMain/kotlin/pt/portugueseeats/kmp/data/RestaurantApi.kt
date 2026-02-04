package pt.portugueseeats.kmp.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import pt.portugueseeats.kmp.data.network.model.NetworkRestaurant

class RestaurantApi(
    private val client: HttpClient
) {
    suspend fun getRestaurants(): List<NetworkRestaurant> =
        client.get("restaurants").body()
}