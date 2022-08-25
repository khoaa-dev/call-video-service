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
    //create
//    fun createNewLesson(
//            @RequestBody lessonCmd: LessonCmd
//    ): ResponseEntity<LessonCmd> {
//        return lessonCmdService.createNewLesson(lessonCmd)
//    }
    @PostMapping("/lessons")
    fun createNewLesson(@Valid @RequestBody lessonCmd: LessonCmd): LessonCmd =
            lessonCmdRepository.save(lessonCmd)

    //update
    @PutMapping("/lessons/status/{id}")
    fun updateStatusById(
            @PathVariable(value = "id") lessonId: Long,
            @Valid @RequestBody newStatus: LessonCmd): ResponseEntity<LessonCmd> {

        return lessonCmdRepository.findById(lessonId).map { existingLesson ->
            val updatedLesson: LessonCmd = existingLesson
                    .copy(status = newStatus.status)
            ResponseEntity.ok().body(lessonCmdRepository.save(updatedLesson))
        }.orElse(ResponseEntity.notFound().build())

    }
//    fun update(
//            @PathVariable(value = "id") lessonId: Long,
//            @RequestBody newStatus: LessonCmd
//    ): ResponseEntity<LessonCmd> {
//        return lessonCmdService.updateStatus(lessonId, newStatus)
//    }

}