package com.intern.callvideoservice.cqrs.command.domain

import javax.persistence.*

@Entity
@Table(name = "lesson")
data class LessonCmd(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = 1,

        @Column(name = "id_student")
        var idStudent: Int? = 1,

        @Column(name = "id_teacher")
        var idTeacher: Int? = 1,

        @Column(name = "statuss")
        var status: String? = "",

        @Column(name = "time_start")
        var timeStart: String? = "",

        @Column(name = "time_end")
        var timeEnd: String? = ""
)