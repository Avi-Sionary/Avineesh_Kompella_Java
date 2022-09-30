package com.company.Summative_1.controllers;

import com.company.Summative_1.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Magic8Controller.class)
public class Magic8ControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing POST /magic
    @Test
    public void shouldReturnAnswerOnRequest() throws Exception {

        // ARRANGE
        Answer inputMagic8 = new Answer();
        inputMagic8.setQuestion("Are you real?");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputMagic8);

        // ACT
        mockMvc.perform(
                        post("/magic") // Perform the POST request
                                .content(inputJson) // Set the request body
                                .contentType(MediaType.APPLICATION_JSON) // Tell the server it's in JSON format
                )
                .andDo(print()) // Print results to console
                .andExpect(status().isCreated()); // ASSERT (status code is 201)
    }
}
