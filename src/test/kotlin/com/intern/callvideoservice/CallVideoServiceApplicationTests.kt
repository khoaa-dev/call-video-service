package com.intern.callvideoservice

import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension
@SpringBootTest(
	classes = arrayOf(CallVideoServiceApplicationTests::class),
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CallVideoServiceApplicationTests {
	@Autowired
	lateinit var restTemplate: TestRestTemplate

	@Test
	fun whenGetCalled_thenShouldBadRequest() {
		val result = restTemplate.getForEntity("/api/agoraApp?id=2", AgoraApp::class.java);

		assertNotNull(result)
		assertEquals(HttpStatus.BAD_REQUEST, result?.statusCode)
	}


}
