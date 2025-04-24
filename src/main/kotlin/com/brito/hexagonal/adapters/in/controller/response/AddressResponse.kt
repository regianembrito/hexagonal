package com.brito.hexagonal.adapters.`in`.controller.response

import com.brito.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String
) {
    constructor(address: Address): this(
        street = address.street,
        city = address.city,
        state = address.state
    )
}