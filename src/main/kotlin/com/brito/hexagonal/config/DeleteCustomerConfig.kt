package com.brito.hexagonal.config

import com.brito.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import com.brito.hexagonal.application.core.usecase.DeleteCustomerByIdByIdUseCase
import com.brito.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ) = DeleteCustomerByIdByIdUseCase(
        findCustomerByIdUseCase,
        deleteCustomerByIdAdapter
    )
}