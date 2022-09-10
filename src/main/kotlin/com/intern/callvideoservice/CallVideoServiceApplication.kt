package com.intern.callvideoservice

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@OpenAPIDefinition
@SpringBootApplication
@EnableJpaAuditing
class CallVideoServiceApplication {
	fun main(args: Array<String>) {
		runApplication<CallVideoServiceApplication>(*args)
	}

	@Bean
	fun corsConfigurer(): WebMvcConfigurer? {
		return object : WebMvcConfigurer {
			override fun addCorsMappings(registry: CorsRegistry) {
				registry.addMapping("/api").allowedOrigins("http://localhost:8080")
			}
		}
	}
}










