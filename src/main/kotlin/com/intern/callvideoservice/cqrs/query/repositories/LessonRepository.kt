package com.intern.callvideoservice.cqrs.query.repositories

import com.intern.callvideoservice.cqrs.query.domain.Lesson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LessonRepository : JpaRepository<Lesson, Long>