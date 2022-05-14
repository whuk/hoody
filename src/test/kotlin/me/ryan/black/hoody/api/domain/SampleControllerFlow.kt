package me.ryan.black.hoody.api.domain

import me.ryan.black.hoody.api.common.Reply
import me.ryan.black.hoody.api.permission.RoleHeader
import me.ryan.black.hoody.utils.fromJson
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

internal class SampleControllerFlow(
    private val mockMvc: MockMvc
) {
    fun helloWorld(): String {
        val uri = linkTo<SampleController> { helloWorld(1234) }.toUri()

        return mockMvc.get(uri) {
            contentType = MediaType.APPLICATION_JSON
            header(RoleHeader.XUser.KEY, 1234)
        }.andExpect {
            status { is2xxSuccessful() }
        }.andReturn()
            .response
            .contentAsString
            .fromJson<Reply<String>>()
            .content!!
    }
}