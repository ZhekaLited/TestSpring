package org.itstep.helloworldspring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

        @SpringBootTest
        public class SpringBoostTest {
        private static MockMvc mvc;

        @BeforeAll
        public static void setUp() {
            mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
        }

        @Test
        public void hello() throws Exception {
            mvc.perform(MockMvcRequestBuilders.get("/")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(equalTo("Hello World")));
        }
    }
