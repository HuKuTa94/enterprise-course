package com.hukuta94.enterprise_course.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AppApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("when call main page hello should be show")
    void appShouldBeRunTest() throws Exception {
        String expectedContent =
                mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, URI.create("/")))
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse()
                        .getContentAsString();

        Assertions.assertEquals("{\"Message\": \"Hello world!\"}", expectedContent);
    }

}
