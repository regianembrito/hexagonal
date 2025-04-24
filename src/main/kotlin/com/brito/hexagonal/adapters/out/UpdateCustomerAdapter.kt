package com.brito.hexagonal.adapters.out

import com.brito.hexagonal.adapters.out.repository.CustomerRepository
import com.brito.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.brito.hexagonal.application.core.domain.Customer
import com.brito.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository
) : UpdateCustomerOutputPort {

    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }

}