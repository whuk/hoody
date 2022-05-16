package me.ryan.black.hoody.api.domain

import io.kotest.matchers.shouldBe
import me.ryan.black.hoody.api.config.FlowTestSupport
import org.junit.jupiter.api.Test

internal class SampleControllerTest : FlowTestSupport() {

    @Test
    fun helloWorld() {
        // Given
        val sampleControllerFlow = SampleControllerFlow(mockMvc)
        // When
        val reply = sampleControllerFlow.helloWorld()
        // Then
        reply shouldBe "Hello World"
    }
}
