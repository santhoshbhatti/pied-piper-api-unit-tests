package com.pp.ut.hamcrest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

class JSONPathTest {
	
	private String response = "[{\"id\":10001,\"name\":\"rose-bud\",\"price\":10.4,\"quantity\":10,\"value\":104.0},"
			+ "{\"id\":10002,\"name\":\"bygon-spary\",\"price\":20.5,\"quantity\":20,\"value\":410.0},"
			+ "{\"id\":10003,\"name\":\"batata-wada\",\"price\":5.25,\"quantity\":50,\"value\":262.5},"
			+ "{\"id\":10004,\"name\":\"ajji-lehiya\",\"price\":30.9,\"quantity\":19,\"value\":587.1}]";

	@Test
	void testJsonResponse() {
		DocumentContext json = JsonPath.parse(response);
		int length = json.read("$.length()");
		assertThat(length).isEqualTo(4);
		
		List<Integer> ids=json.read("$..id");
		assertThat(ids).containsExactly(10001,10002,10003,10004);
		System.out.println(json.read("$.[1]").toString());
		System.out.println(json.read("$.[0:2]").toString());
		System.out.println(json.read("$.[?(@.name == 'batata-wada')]").toString());
		System.out.println(json.read("$.[?(@.quantity == 19)]").toString());
	}

}
