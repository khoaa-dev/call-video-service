package com.intern.callvideoservice.cqrs.query.services

import com.intern.callvideoservice.cqrs.query.domain.Lesson
import com.intern.callvideoservice.cqrs.query.repositories.AgoraAppRepository
import com.intern.callvideoservice.cqrs.query.repositories.LessonRepository
import org.springframework.stereotype.Component

@Component
class LessonService (val lessonRepository: LessonRepository)
    {
        fun findAll(): MutableList<Lesson> {
            return lessonRepository.findAll()
        }
    }