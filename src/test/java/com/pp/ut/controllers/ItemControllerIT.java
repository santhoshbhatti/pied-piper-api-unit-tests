package com.pp.ut.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemControllerIT {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void testFindAll() throws JSONException {
		String response = restTemplate.getForObject("/item-from-db", String.class);
		JSONAssert.assertEquals("[{id: 10001},{id: 10002},{id: 10003},{id: 10004}]",response, false);
	}

}
