package com.brito.hexagonal.adapters.out.repository.entity

import com.brito.hexagonal.application.core.domain.Address

data class AddressEntity(
    val street: String,
    val city: String,
    val state: String
) {
    constructor(address: Address): this(
        street = address.street,
        city = address.city,
        state = address.state
    )

    fun toAddress(): Address {
        return Address(
            street = street,
            city = city,
            state = state
        )
    }
}
