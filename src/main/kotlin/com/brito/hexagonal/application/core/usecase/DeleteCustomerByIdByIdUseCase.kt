package com.brito.hexagonal.application.core.usecase

import com.brito.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.brito.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.brito.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
) : DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        // Check if the customer exists
        findCustomerByIdInputPort.find(id)
        deleteCustomerByIdOutputPort.delete(id)
    }
}