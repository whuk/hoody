package me.ryan.black.hoody.api.domain

import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

internal class SampleControllerFlow(
    private val mockMvc: MockMvc
) {
    fun infoMethodTest(): String {
        val uri = "/info"

        return mockMvc.get(uri) {
            contentType = MediaType.APPLICATION_FORM_URLENCODED
        }.andExpect {
            status { is2xxSuccessful() }
        }.andReturn()
            .response
            .contentAsString
    }

    fun indexMethodTest(): String {
        val uri = "/"

        return mockMvc.get(uri) {
            contentType = MediaType.APPLICATION_FORM_URLENCODED
        }.andDo {
            print()
        }.andExpect {
            status { is2xxSuccessful() }
        }.andReturn()
            .response
            .contentAsString
    }
}
