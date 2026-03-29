package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthController.class)
class HealthControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void pingReturnsOk() throws Exception {
        mockMvc.perform(get("/health/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }
}
