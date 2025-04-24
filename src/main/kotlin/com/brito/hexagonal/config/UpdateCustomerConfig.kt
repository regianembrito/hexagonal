package com.brito.hexagonal.config

import com.brito.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.brito.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.brito.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.brito.hexagonal.adapters.out.UpdateCustomerAdapter
import com.brito.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.brito.hexagonal.application.core.usecase.UpdateCustomerUseCase
import com.brito.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = UpdateCustomerUseCase(
        findCustomerByIdUseCase,
        findAddressByZipCodeAdapter,
        updateCustomerAdapter,
        sendCpfForValidationAdapter
    )
}