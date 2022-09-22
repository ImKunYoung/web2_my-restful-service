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
        String a = "7";
        String b = "6";

        int result = Integer.parseInt(a) + Integer.parseInt(b);

        mvc.perform(get("/calculate/add/"+a+"/"+b))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(13)));
    }
    @Test
    public void minus() throws Exception {
        String a = "7";
        String b = "6";

        int result = Integer.parseInt(a) - Integer.parseInt(b);

        mvc.perform(get("/calculate/minus/"+a+"/"+b))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(result)));
    }
    @Test
    public void multiply() throws Exception {
        String a = "7";
        String b = "6";

        int result = Integer.parseInt(a) * Integer.parseInt(b);

        mvc.perform(get("/calculate/multiply/"+a+"/"+b))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(result)));
    }
    @Test
    public void divide() throws Exception {
        String a = "7";
        String b = "6";

        float result = Float.parseFloat(a) / Float.parseFloat(b);

        mvc.perform(get("/calculate/divide/"+a+"/"+b))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(String.format("%.2f", result))));
    }
}
