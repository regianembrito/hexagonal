package com.brito.hexagonal.application.core.usecase

import com.brito.hexagonal.application.core.domain.Customer
import com.brito.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.brito.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.brito.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.brito.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import com.brito.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
) : UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException("Customer ID cannot be null")
        val savedCpf = findCustomerByIdInputPort.find(customer.id).cpf

        // Save customer to the database
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            // Assuming there's an output port for updating the customer
            updateCustomerOutputPort.update(it)
            if (savedCpf != it.cpf) {
                // Send CPF for validation if it has changed
                sendCpfForValidationOutputPort.send(it.cpf)
            }
        }
    }
}