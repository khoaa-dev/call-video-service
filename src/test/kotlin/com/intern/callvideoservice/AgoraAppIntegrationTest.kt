package com.intern.callvideoservice

import com.intern.callvideoservice.base.BaseIntegrationTest
import com.intern.callvideoservice.cqrs.query.repositories.AgoraAppRepository
import com.intern.callvideoservice.seeds.AgoraAppSeed
import org.json.JSONObject
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

class AgoraAppIntegrationTest : BaseIntegrationTest() {
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var context : WebApplicationContext

    @Autowired
    private lateinit var agoraAppRepository: AgoraAppRepository

    private val id = 1

    @BeforeEach
    fun setup() {
        cleanDB()
        AgoraAppSeed(agoraAppRepository).insertAgoraAppInfo()
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    @Test
    fun `should return agoraApp Info`() {
        val request = MockMvcRequestBuilders.get("/api/agoraApp/id=$id")
        val response = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk)
        val jsonObject = JSONObject(response.andReturn().response.contentAsString)

        // Http verification
        assertEquals(jsonObject.get("id"), id.toString())
        assertEquals(jsonObject.get("appID"), "c7532cf603f1431b9201c6c9699a1515")
        assertEquals(jsonObject.get("appCertificate"), "ea8c7df30bd24067b7fc324256b54a8d")
    }
}