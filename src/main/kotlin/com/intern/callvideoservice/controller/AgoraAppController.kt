package com.intern.callvideoservice.controller

import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import com.intern.callvideoservice.cqrs.query.services.AgoraAppService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AgoraAppController (
    val agoraAppService: AgoraAppService
) {
    @GetMapping("/agoraApp")
    fun getAgoraAppInfo(): List<AgoraApp> = agoraAppService.findAll()

    @GetMapping("/generateToken/appID={appID}&appCertificate={appCertificate}&channelName={channelName}")
    fun generateToken(@PathVariable appID: String?, @PathVariable appCertificate: String?, @PathVariable channelName: String?): MutableMap<String, String> {
        return agoraAppService.getToken(appID, appCertificate, channelName)
    }
}