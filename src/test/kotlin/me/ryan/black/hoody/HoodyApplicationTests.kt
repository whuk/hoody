package me.ryan.black.hoody

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("embedded")
@SpringBootTest
class HoodyApplicationTests {

    @Test
    fun contextLoads() {
    }
}
