package com.pp.ut.service.impl;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class PpListUnitTest {

	@Test
	void test_returnbasic() {
		List<String> mockList=mock(List.class);
		when(mockList.size()).thenReturn(5);
		assertEquals(5, mockList.size());
	}
	
	@Test
	void test_returnmultipleValues() {
		List<String> mockList=mock(List.class);
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
	}
	
	@Test
	void test_returnlistParams() {
		List<String> mockList=mock(List.class);
		when(mockList.get(0)).thenReturn("Hello mock");
		assertEquals("Hello mock", mockList.get(0));
		//assertEquals("Hello mock", mockList.get(1)); fails test here
		assertEquals(null, mockList.get(1));
	}
	
	@Test
	void test_returnForAnyParamlist() {
		List<String> mockList=mock(List.class);
		when(mockList.get(anyInt())).thenReturn("Hello mock");
		assertEquals("Hello mock", mockList.get(0));
		assertEquals("Hello mock", mockList.get(10));
		//assertEquals(null, mockList.get(1)); this fails as all int params will return "hello mock"
		
	}
	
	@Test
	void test_verifyCallslist() {
		//SUT
		List<String> mockList=mock(List.class);
		when(mockList.get(0)).thenReturn("Hello mock");
		String s=mockList.get(0);
		//Verification
		verify(mockList).get(0);
		s=mockList.get(0);
		//verify(mockList).get(0); fails as get called more than once
		verify(mockList,times(2)).get(0);
		//assertEquals(null, mockList.get(1)); this fails as all int params will return "hello mock"
		verify(mockList,atLeast(1)).get(0);
		verify(mockList,atMost(2)).get(0);
	}
	
	@Test
	void test_ArgumentCaptor() {
		//SUT
		List<String> mockList=mock(List.class);
		mockList.add("some string");
		
		//verification
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		//this step captures the value added to the mock 
		verify(mockList).add(captor.capture());
		//here we get the captured value and compare it to value passed to add method
		assertEquals("some string", captor.getValue());
	}
	
	@Test
	void test_MultiArgumentCaptor() {
		//SUT
		List<String> mockList=mock(List.class);
		mockList.add("some string1");
		mockList.add("some string2");
		//verification
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		//this step captures the value added to the mock 
		verify(mockList,times(2)).add(captor.capture());
		List<String> argsCaptured=captor.getAllValues();
		//here we get the captured value and compare it to value passed to add method
		assertEquals("some string1", argsCaptured.get(0));
		assertEquals("some string2", argsCaptured.get(1));
	}
	
	@Test
	void test_Mocking() {
		//SUT
		
		//all the calls to mock return default values
		//as all methods are mocked and not real
		//the size when overridden in mock returns a size of 5 in the end
		List<String> mockList=mock(ArrayList.class);
		System.out.println("getting element from list  "+mockList.get(0));
		System.out.println("printing size of list  "+mockList.size());
		System.out.println("adding test1 to list  "+mockList.add("test1"));
		System.out.println("adding test2 to list  "+mockList.add("test2"));
		System.out.println(mockList.size());
		System.out.println("mocking size to return size as 5");
		when(mockList.size()).thenReturn(5);
		System.out.println("printing size of list after mocking "+mockList.size());
		
	}
	
	@Test
	void test_Spying() {
		//SUT
		
		//when we create spy original behaviour of the spied upon class is maintained
		//So all adds and size methods return the current state of the arrylist
		//but when we override some behaviours like size in the below , it will
		//return values given to it
		List<String> spyList=spy(ArrayList.class);
		//below line fails as we are trying to call get(0) 
		//System.out.println("getting element from list  "+spyList.get(0));
		System.out.println("printing size of list  "+spyList.size());
		System.out.println("adding test1 to list  "+spyList.add("test1"));
		System.out.println("adding test2 to list  "+spyList.add("test2"));
		System.out.println(spyList.size());
		System.out.println("mocking size to return size as 5");
		when(spyList.size()).thenReturn(5);
		System.out.println("printing size of list after mocking "+spyList.size());
		
	}


}
