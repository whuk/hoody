package me.ryan.black.hoody.api.domain.admin

import org.springframework.security.crypto.password.PasswordEncoder
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Admin(
    @Column(unique = true, nullable = false)
    var username: String,
    @Column(nullable = false)
    var type: String
) {
    @Id
    @GeneratedValue
    var id: Long? = null
        protected set

    var password: String? = null

    fun encodePassword(password: String, passwordEncoder: PasswordEncoder) {
        this.password = passwordEncoder.encode(password)
    }
}