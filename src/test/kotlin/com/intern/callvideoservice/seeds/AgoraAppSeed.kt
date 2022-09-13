package com.intern.callvideoservice.seeds

import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import com.intern.callvideoservice.cqrs.query.repositories.AgoraAppRepository

class AgoraAppSeed(private val agoraAppRepository: AgoraAppRepository) {
    fun insertAgoraAppInfo() {
        agoraAppRepository.save(AgoraApp(1, "c7532cf603f1431b9201c6c9699a1515", "ea8c7df30bd24067b7fc324256b54a8d"))
    }
}