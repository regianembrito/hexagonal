package com.brito.hexagonal.application.ports.`in`

import com.brito.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)
}