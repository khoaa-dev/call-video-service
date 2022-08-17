package com.intern.callvideoservice.cqrs.command.repositories

import com.intern.callvideoservice.cqrs.command.domain.LessonCmd
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LessonCmdRepository : JpaRepository<LessonCmd, Long>