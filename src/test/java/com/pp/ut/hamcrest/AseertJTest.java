package com.pp.ut.hamcrest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AseertJTest {

	@Test
	public void testList() {
		List<Integer> list = Arrays.asList(10,20,13,45,9,0,34);
		assertThat(list)
		.isNotEmpty()
		.hasSize(7)
		.allMatch(a -> a < 100)
		.allMatch(a -> a > -1)
		.contains(13,45);
		/*assertThat(list, hasSize(7));
		assertThat(list, everyItem(lessThan(100)));
		assertThat(list, everyItem(greaterThan(-1)));
		assertThat(list, hasItems(20,9));*/
	}
	
	@Test
	public void testString() {
		/*assertThat("", emptyString());
		assertThat("abcde", startsWith("abc"));
		assertThat("abcde", endsWith("de"));
		assertThat("abcde", hasLength(5));
		assertThat("abcde", containsString("bcd"));*/
		assertThat("").isEmpty();
		assertThat("abcde")
		.hasSizeLessThan(10)
		.isNotBlank()
		.startsWith("abc")
		.endsWith("de")
		.contains("bcd");
	}

}
