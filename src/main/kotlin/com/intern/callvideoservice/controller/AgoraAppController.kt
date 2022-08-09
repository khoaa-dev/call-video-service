package com.intern.callvideoservice.controller

import com.intern.callvideoservice.cqrs.query.repositories.AgoraApp
import com.intern.callvideoservice.cqrs.query.repositories.AgoraAppRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AgoraAppController (private val agoraAppRepository: AgoraAppRepository) {

    @GetMapping("/agoraApp")
    fun getAgoraAppInfo(): List<AgoraApp> = agoraAppRepository.findAll()

}