package com.intern.callvideoservice.controller

import com.intern.callvideoservice.cqrs.command.domain.LessonCmd
import com.intern.callvideoservice.cqrs.command.repositories.LessonCmdRepository
import com.intern.callvideoservice.cqrs.command.services.LessonCmdService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class LessonCommandController (val lessonCmdRepository: LessonCmdRepository){
    @PostMapping("/create")
    fun createNewLesson(@Valid @RequestBody lessonCmd: LessonCmd): LessonCmd =
            lessonCmdRepository.save(lessonCmd)

}