package com.brito.hexagonal.application.ports.out

interface DeleteCustomerByIdOutputPort {

    fun delete(id: String)
}