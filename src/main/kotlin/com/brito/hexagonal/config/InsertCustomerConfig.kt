package com.brito.hexagonal.config

import com.brito.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.brito.hexagonal.adapters.out.InsertCustomerAdapter
import com.brito.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.brito.hexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = InsertCustomerUseCase(
        findAddressByZipCodeAdapter,
        insertCustomerAdapter,
        sendCpfForValidationAdapter
    )
}