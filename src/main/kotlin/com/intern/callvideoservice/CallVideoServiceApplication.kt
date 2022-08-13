package com.intern.callvideoservice

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@OpenAPIDefinition
@SpringBootApplication
@EnableJpaAuditing
class CallVideoServiceApplication

fun main(args: Array<String>) {
	runApplication<CallVideoServiceApplication>(*args)
}
