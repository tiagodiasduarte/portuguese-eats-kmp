package pt.portugueseeats.kmp.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkRestaurant(
    val id: Int,
    val name: String,
    val description: String
)