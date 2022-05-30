package me.ryan.black.hoody.api.domain.admin

import me.ryan.black.hoody.api.domain.admin.repository.AdminRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class AdminInteraction(
    private val adminRepository: AdminRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val admin = adminRepository.findByUsername(username)
        return User.builder()
            .username(admin.username)
            .password(admin.password)
            .roles(admin.type)
            .build()
    }

    fun create(account: AdminResources.Request.Account): Admin {
        val admin = Admin(account.username, account.type)
        admin.encodePassword(account.password)
        return adminRepository.save(admin)
    }
}