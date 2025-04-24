package com.brito.hexagonal.adapters.out

import com.brito.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.brito.hexagonal.application.core.domain.Address
import com.brito.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
) : FindAddressByZipCodeOutputPort {

    // Simulating a database or external service call
    override fun find(zipCode: String): Address = findAddressByZipCodeClient.find(zipCode).toDomain()

}