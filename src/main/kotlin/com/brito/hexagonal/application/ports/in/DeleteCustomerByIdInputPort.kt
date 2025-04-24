package com.brito.hexagonal.application.ports.`in`

interface DeleteCustomerByIdInputPort {

    fun delete(id: String)
}