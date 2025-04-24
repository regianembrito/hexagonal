package com.brito.hexagonal.application.ports.out

import com.brito.hexagonal.application.core.domain.Customer

interface FindCustomerByIdOutputPort {

    fun find(id: String): Customer?

}