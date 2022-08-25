package com.intern.callvideoservice.cqrs.query.domain

import org.springframework.format.annotation.DateTimeFormat
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import kotlin.time.TimedValue

@Entity
@Table(name = "lesson")
data class Lesson(
        @Id
        var id: Long? = 1,

        @Column(name = "id_student")
        var idStudent: Int? = 1,

        @Column(name = "id_teacher")
        var idTeacher: Int? = 1,

        @Column(name = "statuss")
        var status: String? = "",

        @Column(name = "time_start")
        var timeStart: String? = "",

        @Column(name = "time_end")
        var timeEnd: String? = "",

        @Column(name = "channel_name")
        var channelName: String? = ""
)