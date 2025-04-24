package com.brito.hexagonal.adapters.out.client.response

import com.brito.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String
) {
    fun toDomain(): Address {
        return Address(
            street = street,
            city = city,
            state = state
        )
    }
}
