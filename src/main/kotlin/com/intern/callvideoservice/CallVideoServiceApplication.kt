package com.intern.callvideoservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class CallVideoServiceApplication

fun main(args: Array<String>) {
	runApplication<CallVideoServiceApplication>(*args)
}
