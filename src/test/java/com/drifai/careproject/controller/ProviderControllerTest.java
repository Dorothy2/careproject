package com.drifai.careproject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProviderControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getProvidersJSON() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/providers/SN/02494").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(populateResultJSON())));
    }

    private String populateResultJSON() {
        String result =
                "[\"{\\\"firstName\\\":\\\"Susan\\\",\\\"lastName\\\":\\\"W.\\\",\\\"vertical\\\":\\\"SN\\\",\\\"zipCode\\\":\\\"02494\\\",\\\"rate\\\":50}\",\"{\\\"firstName\\\":\\\"Marilyn\\\",\\\"lastName\\\":\\\"Q.\\\",\\\"vertical\\\":\\\"SN\\\",\\\"zipCode\\\":\\\"02494\\\",\\\"rate\\\":65}\"]";
        return result;
    }
}
