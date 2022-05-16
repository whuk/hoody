package me.ryan.black.hoody.api.domain

import me.ryan.black.hoody.api.common.Reply
import me.ryan.black.hoody.api.common.toReply
import me.ryan.black.hoody.api.lock.EnableUserLock
import me.ryan.black.hoody.api.permission.RoleHeader
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/sample")
class SampleController {

    @EnableUserLock
    @GetMapping
    fun helloWorld(
        @RequestHeader(RoleHeader.XUser.KEY) userId: Long
    ): Reply<String> {
        return "Hello World".toReply()
    }
}
