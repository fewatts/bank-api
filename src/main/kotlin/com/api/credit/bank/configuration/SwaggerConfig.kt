package com.api.credit.bank.configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("SpringBankApplication-public")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()
    }
}
