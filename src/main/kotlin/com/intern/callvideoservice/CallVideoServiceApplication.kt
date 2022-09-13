package com.intern.callvideoservice

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@OpenAPIDefinition
@SpringBootApplication
//@Configuration
//@EnableJpaAuditing

//Use for test
//@EnableAutoConfiguration(exclude=[DataSourceAutoConfiguration::class])
class CallVideoServiceApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
	runApplication<CallVideoServiceApplication>(*args)
}






