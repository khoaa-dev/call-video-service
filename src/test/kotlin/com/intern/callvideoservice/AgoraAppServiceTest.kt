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


class AgoraAppServiceTest {
    private val agoraAppRepository: AgoraAppRepository = mockk()
    private val agoraAppService = AgoraAppService(agoraAppRepository)


    @Test
    fun whenGetAppIDAndCertificate_thenReturnAppIDAndCertificate() {
        var agoraApp: AgoraApp? = null
        //given
        every { agoraAppRepository.findByIdOrNull(1) } returns agoraApp;

        //when
        val result = agoraAppService.getAgoraAppInfo(1);

        //then
        verify(exactly = 1) { agoraAppRepository.findByIdOrNull(1) };
        assertEquals(agoraApp, result)
    }
}

