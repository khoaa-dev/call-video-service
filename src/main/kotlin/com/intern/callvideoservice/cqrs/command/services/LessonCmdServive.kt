package com.intern.callvideoservice.cqrs.command.services

import com.intern.callvideoservice.cqrs.command.domain.LessonCmd
import com.intern.callvideoservice.cqrs.command.repositories.LessonCmdRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

class LessonCmdService (val lessonCmdRepository: LessonCmdRepository)
{
//    fun createNewLesson(lessonCmd: LessonCmd): ResponseEntity<LessonCmd> {
//        return ResponseEntity.ok(lessonCmdRepository.save(lessonCmd))
//    }

}
