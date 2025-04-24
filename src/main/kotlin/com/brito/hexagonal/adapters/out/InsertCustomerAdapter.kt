package com.brito.hexagonal.adapters.out

import com.brito.hexagonal.adapters.out.repository.CustomerRepository
import com.brito.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.brito.hexagonal.application.core.domain.Customer
import com.brito.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
) : InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}