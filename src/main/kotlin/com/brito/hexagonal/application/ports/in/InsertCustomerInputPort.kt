package com.brito.hexagonal.application.ports.`in`

import com.brito.hexagonal.application.core.domain.Customer


interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)
}