package me.ryan.black.hoody.api.domain.admin.repository

import me.ryan.black.hoody.api.domain.admin.Admin
import org.springframework.data.jpa.repository.JpaRepository

interface AdminRepository : JpaRepository<Admin, Long> {
    fun findByUsername(username: String) : Admin
}