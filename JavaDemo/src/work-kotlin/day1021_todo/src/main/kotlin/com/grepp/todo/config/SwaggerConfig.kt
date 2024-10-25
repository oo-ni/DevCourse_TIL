package com.grepp.todo.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun swaggerAPI(): OpenAPI {
        val info = Info()
            .title("Programmer 백엔드 데브코스 API")
            .description("서비스 설명이 들어갑니당")
            .version("v87.0.u14")
        return OpenAPI().info(info)
    }
}