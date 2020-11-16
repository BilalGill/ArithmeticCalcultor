/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pm.arithmetics;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class ArithmeticOperationsControllerTests {

	@Autowired
	private MockMvc mockMvc;

    @Test
    public void doPerformWithInvalidEndpoint() throws Exception {

        this.mockMvc.perform(get("/v1/remainder")).andDo(print()).andExpect(status().is4xxClientError());
    }

	@Test
	public void doPerformWithNoBody() throws Exception {

		this.mockMvc.perform(get("/v1/add")).andDo(print()).andExpect(status().is4xxClientError());
	}

    @Test
    public void doPerformInvalidInputListTooShortError() throws Exception {

        this.mockMvc.perform(post("/v1/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[1]"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(status().reason("Too short operands"));
    }

    @Test
    public void doPerformInvalidZeroOperandForDivisionError() throws Exception {

        this.mockMvc.perform(post("/v1/divide")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[1, 0]"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(status().reason("Invalid zero operand for division"));
    }

    @Test
    public void doPerformArithmeticAddion() throws Exception {

        this.mockMvc.perform(post("/v1/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[1,2,3]"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("6.00"));
	}

    @Test
    public void doPerformArithmeticMultiplication() throws Exception {

        this.mockMvc.perform(post("/v1/multiply")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[1,2,3]"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("6.00"));
    }

    @Test
    public void doPerformArithmeticSubtraction() throws Exception {

        this.mockMvc.perform(post("/v1/divide")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[1,2,3]"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("0.17"));
    }

}
