package com.brito.hexagonal.application.core.usecase

import com.brito.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.brito.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.brito.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort,
): FindCustomerByIdInputPort {

    override fun find(id: String) =
        findCustomerByIdOutputPort.find(id)
        ?: throw ObjectNotFoundException("Customer with id $id not found")

}