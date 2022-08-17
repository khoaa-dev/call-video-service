package com.intern.callvideoservice.controller

import com.intern.callvideoservice.cqrs.query.domain.Lesson
import com.intern.callvideoservice.cqrs.query.services.LessonService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class LessonQueryController (val lessonService: LessonService){
    @GetMapping("/lessons")
    fun getAllLessons(): List<Lesson> = lessonService.findAll()
}