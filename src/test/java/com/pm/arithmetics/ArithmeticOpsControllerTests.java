package com.pm.arithmetics;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ArithmeticOpsControllerTests {

	@Autowired
	private MockMvc mockMvc;

    // Perform post request to invalid endpoint
    @Test
    public void doPerformWithInvalidEndpoint() throws Exception {
        this.mockMvc.perform(get("/v1/remainder")).andDo(print()).andExpect(status().is4xxClientError());
    }

    // Perform post request to empty request body
	@Test
	public void doPerformWithNoBody() throws Exception {
		this.mockMvc.perform(get("/v1/add")).andDo(print()).andExpect(status().is4xxClientError());
	}

    // Perform post request with only one operand to get expected "NotEnoughOperandException" exception
    @Test
    public void doPerformInvalidInputListTooShortError() throws Exception {
        this.mockMvc.perform(post("/v1/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[1]"))
        .andDo(print())
        .andExpect(status().isUnprocessableEntity())
        .andExpect(status().reason("Not Enough operands"));
    }

    // Perform post request division with 0 to get expected "InvalidOperandException" exception
    @Test
    public void doPerformInvalidZeroOperandForDivisionError() throws Exception {
        this.mockMvc.perform(post("/v1/divide")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[1, 0]"))
        .andDo(print())
        .andExpect(status().isUnprocessableEntity())
        .andExpect(status().reason("Invalid operand exception"));
    }

    // Perform post addition request
    @Test
    public void doPerformArithmeticAddition() throws Exception {
        this.mockMvc.perform(post("/v1/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[1,2,3]"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("6.00"));
	}

    // Perform post subtraction request
    @Test
    public void doPerformArithmeticSubtraction() throws Exception {
        this.mockMvc.perform(post("/v1/subtract")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[1,2,3]"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("-4.00"));
    }

    // Perform post multiplication request
    @Test
    public void doPerformArithmeticMultiplication() throws Exception {
        this.mockMvc.perform(post("/v1/multiply")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[1,2,3]"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("6.00"));
    }

    // Perform post division request
    @Test
    public void doPerformArithmeticDivision() throws Exception {
        this.mockMvc.perform(post("/v1/divide")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[1,2,3]"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("0.17"));
    }
}
