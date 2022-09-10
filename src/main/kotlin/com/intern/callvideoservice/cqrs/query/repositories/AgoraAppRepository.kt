package com.intern.callvideoservice.cqrs.query.repositories


import com.intern.callvideoservice.cqrs.query.domain.AgoraApp
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AgoraAppRepository : CrudRepository<AgoraApp, Long>
