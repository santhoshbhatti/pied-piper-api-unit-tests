package com.pp.ut.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
@WebMvcTest(PiedPiperRestController.class)
public class PiedPiperRestControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	@Test
	public void testHelloSimple() throws Exception {
		
		RequestBuilder builder = MockMvcRequestBuilders.get("/hello")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(builder).andReturn();
		String responseBody=result.getResponse().getContentAsString();
		assertEquals(responseBody, "Hello World");
	}
	
	

}
