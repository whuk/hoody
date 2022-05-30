package me.ryan.black.hoody.api.domain.admin

import me.ryan.black.hoody.api.config.UsernameInvalidException
import org.springframework.http.HttpStatus
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class AdminController(
    private val adminInteraction: AdminInteraction
) {

    @PostMapping("/v1/admin")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody account: AdminResources.Request.Account,
        errors: Errors
    ) {
        if (errors.hasErrors()) {
            throw UsernameInvalidException()
        }
        adminInteraction.create(account)
    }
}