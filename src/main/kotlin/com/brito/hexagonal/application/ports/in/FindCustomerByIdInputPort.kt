package com.brito.hexagonal.application.ports.`in`

import com.brito.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer
}