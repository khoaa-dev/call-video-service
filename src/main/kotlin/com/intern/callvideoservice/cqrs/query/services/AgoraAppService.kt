package com.intern.callvideoservice.cqrs.query.services

import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import com.intern.callvideoservice.cqrs.query.exception.AgoraAppException
import com.intern.callvideoservice.cqrs.query.repositories.AgoraAppRepository
import io.agora.media.RtcTokenBuilder
import io.agora.media.RtcTokenBuilder.Role
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*


@Component
class AgoraAppService(val agoraAppRepository: AgoraAppRepository) {

    fun getAgoraAppInfo(id: Long): AgoraApp? {
        return agoraAppRepository.findByIdOrNull(id)
    }

    fun getToken(appID: String?, appCertificate: String?, channelName: String?): MutableMap<String, String> {
        if(appID.isNullOrEmpty()) throw AgoraAppException("appID not found")
        if(appCertificate.isNullOrEmpty()) throw AgoraAppException("appCertificate not found")
        if(channelName.isNullOrEmpty()) throw AgoraAppException("channelName not found")

        var tokens: MutableMap<String, String> = mutableMapOf()
        var tokenBuilder = RtcTokenBuilder()
        var timestamp: Int = ((System.currentTimeMillis() / 1000 + 3600).toInt())
        var token: String = tokenBuilder.buildTokenWithUid(appID, appCertificate, channelName, 0, Role.Role_Publisher, timestamp)
        tokens["token"] = token
        return tokens
    }
}