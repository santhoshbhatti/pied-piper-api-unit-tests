package com.pp.ut.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JSONAssertTest {
	
	String actual="{\"id\":10,\"name\":\"Tennis Ball\",\"price\":10.5,\"quantity\":10}";

	@Test
	void testJsonAssertWithStrictCheck() throws JSONException {
		//in this test the expected json has extra spaces.
		//but the test succeeds as jsonassert with strict as true does not mind spaces
		String expected="{\"id\":10, \"name\":\"Tennis Ball\",\"price\":10.5,\"quantity\":10}";
		JSONAssert.assertEquals(expected, actual, true);
	}
	
	@Test
	void testJsonAssertWithStrictCheckFieldsMissing() throws JSONException {
		//in this test the expected json has extra spaces.
		//but the test succeeds as jsonassert with strict as true does not mind spaces
		String expected="{\"id\":10, \"name\":\"Tennis Ball\",\"price\":10.5}";
		//this below assert fails as we enabled strict checking and the expected json 
		//does not have quantity property
		//JSONAssert.assertEquals(expected, actual, true);
		
		JSONAssert.assertNotEquals(expected, actual, true);
	}
	
	@Test
	void testJsonAssertWithStrictCheckDisabledFieldsMissing() throws JSONException {
		//in this test the expected json has extra spaces.
		//but the test succeeds as jsonassert with strict as true does not mind spaces
		String expected="{\"id\":10, \"name\":\"Tennis Ball\",\"price\":10.5}";
		//Since strict check is disabled all the existing fields in expected
		//are compared with corresponding fields in actual json
		//so below assert will succeed
		
		JSONAssert.assertEquals(expected, actual, false);
	}
	
	@Test
	void testJsonAssertWithoutEscapesequenceinjson() throws JSONException {
		//in this test the expected json has extra spaces.
		//but the test succeeds as jsonassert with strict as true does not mind spaces
		
		//as can be seen all escape seq is removed from expected string
		//only the values which have spaces in them are escaped
		String expected="{id:10, name:\"Tennis Ball\",price:10.5}";
		
		
		JSONAssert.assertEquals(expected, actual, false);
	}
	
	@Test
	void testJsonAssertWithStrictWithoutEscape() throws JSONException {
		//in this test the expected json has no double quotes for fields
		//only field values having spce in them are enclosed in double quotes
		//but the test succeeds as jsonassert with strict as true does not mind
		String expected="{id: 10, name:\"Tennis Ball\",price:10.5,quantity:10}";
		JSONAssert.assertEquals(expected, actual, true);
	}

}
