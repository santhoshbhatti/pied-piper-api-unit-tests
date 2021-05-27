package com.pp.ut.hamcrest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.hasSize;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestAssertsTests {

	@Test
	public void testList() {
		List<Integer> list = Arrays.asList(10,20,13,45,9,0,34);
		assertThat(list, hasSize(7));
		assertThat(list, everyItem(lessThan(100)));
		assertThat(list, everyItem(greaterThan(-1)));
		assertThat(list, hasItems(20,9));
	}
	
	@Test
	public void testString() {
		assertThat("", emptyString());
		assertThat("abcde", startsWith("abc"));
		assertThat("abcde", endsWith("de"));
		assertThat("abcde", hasLength(5));
		assertThat("abcde", containsString("bcd"));
	}
	

}
