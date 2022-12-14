package com.intern.callvideoservice

import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
@SpringBootTest(
	classes = arrayOf(CallVideoServiceApplicationTests::class),
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	properties = ["spring.main.web-application-type=none"])
class CallVideoServiceApplicationTests {
	@Autowired
	lateinit var restTemplate: TestRestTemplate

	@Test
	fun contextLoads() {

	}

}
