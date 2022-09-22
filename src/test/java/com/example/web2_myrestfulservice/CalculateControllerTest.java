package com.example.web2_myrestfulservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CalculateController.class)
public class CalculateControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        mvc.perform(get("/calculate/add/7/6")).andExpect(status().isOk()).andExpect(jsonPath("$.result", is(13)));
    }
    @Test
    public void minus() throws Exception {
        mvc.perform(get("/calculate/minus/7/6")).andExpect(status().isOk()).andExpect(jsonPath("$.result", is(1)));
    }
    @Test
    public void multiply() throws Exception {
        mvc.perform(get("/calculate/multiply/7/6")).andExpect(status().isOk()).andExpect(jsonPath("$.result", is(42)));
    }
    @Test
    public void divide() throws Exception {
        mvc.perform(get("/calculate/divide/7/6")).andExpect(status().isOk()).andExpect(jsonPath("$.result", is(1.166)));
    }
}
