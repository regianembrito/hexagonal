package com.brito.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(
    @field:NotBlank(message = "Name is required")
    val name: String,
    @field:NotBlank(message = "Street is required")
    val cpf: String,
    @field:NotBlank(message = "Zip code is required")
    val zipCode: String
)
