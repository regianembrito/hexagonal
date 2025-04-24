package com.brito.hexagonal.application.ports.out

import com.brito.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address
}