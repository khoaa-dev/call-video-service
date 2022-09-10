package com.intern.callvideoservice

import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import com.intern.callvideoservice.cqrs.query.services.AgoraAppService
import com.ninjasquad.springmockk.MockkBean
import com.ninjasquad.springmockk.MockkClear.Companion.get
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity.status
import org.springframework.test.web.client.match.MockRestRequestMatchers.content
import org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
class AgoraAppControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var agoraAppService: AgoraAppService

    @Test
    fun givenExistingAgoraApp_whenGetRequest_thenReturnsAgoraAppJsonWithStatus200() {
        var agoraApp: AgoraApp? = null

        every { agoraAppService.getAgoraAppInfo(1) } returns agoraApp


//        mockMvc.perform(get("/api/agoraApp/id=1"))
//            .andExpect(status().isOk)
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("$.id").value(1))
    }
}