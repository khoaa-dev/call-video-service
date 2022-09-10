package com.intern.callvideoservice.controller

import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import com.intern.callvideoservice.cqrs.query.services.AgoraAppService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
class AgoraAppController (
    val agoraAppService: AgoraAppService
) {
    @GetMapping("/agoraApp/id={id}")
    fun getAgoraAppInfo(@PathVariable id: Long): ResponseEntity<AgoraApp>? {
        var agoraApp: AgoraApp? = agoraAppService.getAgoraAppInfo(id)
        return if(agoraApp != null) {
            ResponseEntity(agoraApp, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/generateToken/appID={appID}&appCertificate={appCertificate}&channelName={channelName}")
    fun generateToken(@PathVariable appID: String?, @PathVariable appCertificate: String?, @PathVariable channelName: String?): MutableMap<String, String> {
        return agoraAppService.getToken(appID, appCertificate, channelName)
    }
}