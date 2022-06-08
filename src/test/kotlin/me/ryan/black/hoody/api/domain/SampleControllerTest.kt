package me.ryan.black.hoody.api.domain

import io.kotest.matchers.string.shouldContain
import me.ryan.black.hoody.api.config.FlowTestFormSupport
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.security.test.context.support.WithMockUser

internal class SampleControllerTest : FlowTestFormSupport() {

    @Test
    @DisplayName("info 페이지 테스트")
    fun infoMethodTest() {
        // Given
        val sampleControllerFlow = SampleControllerFlow(mockMvc)
        // When
        val reply = sampleControllerFlow.infoMethodTest()
        // Then
        reply shouldContain "<h1>Info</h1>"
    }

    @Test
    @DisplayName("index 페이지 테스트")
    @WithMockUser(username = "ryan", password = "1234", roles = ["USER"])
    fun indexPageTest() {
        // Given
        val sampleControllerFlow = SampleControllerFlow(mockMvc)
        // When
        val reply = sampleControllerFlow.indexMethodTest()
        // Then
        reply shouldContain "<h1>Hello~!! ryan</h1>"
    }
}
