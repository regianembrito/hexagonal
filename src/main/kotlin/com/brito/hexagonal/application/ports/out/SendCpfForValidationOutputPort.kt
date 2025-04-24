package com.brito.hexagonal.application.ports.out

interface SendCpfForValidationOutputPort {

    fun send(cpf: String)
}