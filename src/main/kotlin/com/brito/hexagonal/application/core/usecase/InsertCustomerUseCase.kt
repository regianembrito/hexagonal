package com.brito.hexagonal.application.core.usecase

import com.brito.hexagonal.application.core.domain.Customer
import com.brito.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.brito.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.brito.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.brito.hexagonal.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
): InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {
        // Logic to insert a customer
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            // Save customer to the database
            insertCustomerOutputPort.insert(it)
            sendCpfForValidationOutputPort.send(it.cpf)
        }
    }
}