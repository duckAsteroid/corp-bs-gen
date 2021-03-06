/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.asteroid.duck.corp.bs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@ContextConfiguration(classes = {Controller.class, App.class})
@WebMvcTest
class AppTest {
    @Autowired
    public MockMvc mockMvc;

    @Test
    void appHasAGreeting() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/rest/bs")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andReturn();

        String message = result.getResponse().getContentAsString();
        assertNotNull(message);
        System.out.println(message);
    }
}
