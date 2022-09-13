package com.intern.callvideoservice

import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import com.intern.callvideoservice.cqrs.query.repositories.AgoraAppRepository
import com.intern.callvideoservice.cqrs.query.services.AgoraAppService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.data.repository.findByIdOrNull


internal class AgoraAppServiceTest {
    private val agoraAppRepository: AgoraAppRepository = mockk()
    private val agoraAppService = AgoraAppService(agoraAppRepository)
    private val agoraApp = AgoraApp(1, "c7532cf603f1431b9201c6c9699a1515", "ea8c7df30bd24067b7fc324256b54a8d")

    @Test
    fun `should return agora app info`() {
        //given
        every { agoraAppRepository.findByIdOrNull(1) } returns agoraApp;

        //when
        val result = agoraAppService.getAgoraAppInfo(1);

        //then
        verify(exactly = 1) { agoraAppRepository.findByIdOrNull(1) };
        assertEquals(agoraApp, result)
    }
}

