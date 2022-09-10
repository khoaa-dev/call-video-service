package com.intern.callvideoservice

import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import com.intern.callvideoservice.cqrs.query.repositories.AgoraAppRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull
import org.junit.jupiter.api.Assertions.assertEquals


@DataJpaTest
class AgoraAppRepositoryTest {
    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var agoraAppRepository: AgoraAppRepository

    @Test
    fun whenGetAgoraAppInfo_thenReturnAgoraApp() {
        val ingAgoraApp = AgoraApp(1, "c7532cf603f1431b9201c6c9699a1515", "ea8c7df30bd24067b7fc324256b54a8d")
        entityManager.persist(ingAgoraApp)
        entityManager.flush()
        val ingAgoraAppFound = agoraAppRepository.findByIdOrNull(ingAgoraApp.id!!)
        assertEquals(ingAgoraApp, ingAgoraAppFound)
    }
}