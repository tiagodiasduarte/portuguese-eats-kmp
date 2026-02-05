package pt.portugueseeats.kmp.mapper

import pt.portugueseeats.kmp.data.network.model.NetworkRestaurant
import pt.portugueseeats.kmp.domain.Restaurant


fun NetworkRestaurant.toRestaurant(): Restaurant =
    Restaurant(
        id = this.id,
        name = this.name,
        description = this.description,
    )