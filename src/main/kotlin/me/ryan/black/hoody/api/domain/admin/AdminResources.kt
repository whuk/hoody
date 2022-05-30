package me.ryan.black.hoody.api.domain.admin

import javax.validation.constraints.Email

class AdminResources {

    class Request {

        data class Account(
            @field:Email
            var username: String,
            var password: String,
            var type: String
        )
    }
}