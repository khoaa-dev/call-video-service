package com.intern.callvideoservice.cqrs.query.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

class AgoraAppException(override val message: String) : RuntimeException(message)

@ControllerAdvice
class AgoraAppExceptionHandler {
    @ExceptionHandler(AgoraAppException::class)
    fun handleMonitoringException(ex: AgoraAppException): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(ex.message)
    }

}