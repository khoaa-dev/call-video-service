package com.intern.callvideoservice.cqrs.query.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "agoraapp")
data class AgoraApp(
    @Id
    var id: Int? = 1,

    @Column(name = "appid")
    var appID: String? = "",

    @Column(name = "app_certificate")
    var appCertificate: String? = "",
)