package com.brito.hexagonal.config

import com.brito.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.brito.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdAdapter: FindCustomerByIdAdapter) =
        FindCustomerByIdUseCase(findCustomerByIdAdapter)

}