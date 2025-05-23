package com.brito.hexagonal.adapters.out

import com.brito.hexagonal.adapters.out.repository.CustomerRepository
import com.brito.hexagonal.application.core.domain.Customer
import com.brito.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
) : FindCustomerByIdOutputPort {

    override fun find(id: String): Customer? =
        customerRepository.findById(id)
            .getOrNull()
            .let {
                return it?.toCustomer()
            }

}