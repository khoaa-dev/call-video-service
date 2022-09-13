package com.intern.callvideoservice

import com.intern.callvideoservice.controller.AgoraAppController
import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import com.intern.callvideoservice.cqrs.query.repositories.AgoraAppRepository
import com.intern.callvideoservice.cqrs.query.services.AgoraAppService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
internal class AgoraAppControllerTest(@Autowired val mockMvc: MockMvc) {
    @MockkBean
    lateinit var agoraAppService : AgoraAppService


    val agoraApp = AgoraApp(1, "c7532cf603f1431b9201c6c9699a1515", "ea8c7df30bd24067b7fc324256b54a8d")

    @Nested
    @DisplayName("GET /api/agoraApp/id={id}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAgoraApp {
        @Test
        fun `given existing agoraApp - when get request - then return agoraApp json with status 200`() {
            //given
            val id = 1
            every { agoraAppService.getAgoraAppInfo(1) } returns  agoraApp

             //when/then
            mockMvc.perform(get("/api/agoraApp/id=$id"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.appID").value(agoraApp.appID))
                .andExpect(jsonPath("$.appCertificate").value(agoraApp.appCertificate))
        }

        @Test
        fun `given appId, appCertificate, channelName - when get request - then return token json with status 200`() {
            //given
            val appID = "c7532cf603f1431b9201c6c9699a1515"
            val appCertificate = "ea8c7df30bd24067b7fc324256b54a8d"
            val channelName = "test"

            //when/then
            mockMvc.perform(get("/generateToken/appID=$appID&appCertificate=$appCertificate&channelName=$channelName"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.token").isNotEmpty)
        }
    }
}