package com.example.back

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.validation.Validator

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class BackApplicationTests {

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    @DisplayName("GET /buckets")
    fun t1() {
        val resultAcions = mvc
            .perform(
                get("/buckets")
            )
            .andDo(MockMvcResultHandlers.print())

        resultAcions
            .andExpect {
                status().isOk()
            }
    }

}
