package com.pp.ut.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pp.ut.repo.PpCalcRepo;
@ExtendWith(MockitoExtension.class)
class PpCalcServiceMockTest {

	@InjectMocks
	private PpCalcService service;
	@Mock
	private PpCalcRepo calcMock;
	
	
	@Test
	void sumArrayTest() {
		when(calcMock.retriveCalcData()).thenReturn(new int[] {10,20,40});
		assertEquals(70, service.sumArray());
	}
	
	@Test
	void sumArrayNullTest() {
		when(calcMock.retriveCalcData()).thenReturn(null);
		assertEquals(0, service.sumArray());
	}
	
	@Test
	void sumArrayEmptyTest() {
		when(calcMock.retriveCalcData()).thenReturn(new int[]{});
		assertEquals(0, service.sumArray());
	}
	
	@Test
	void sumArraySingleElemTest() {
		when(calcMock.retriveCalcData()).thenReturn(new int[]{3});
		assertEquals(3, service.sumArray());
	}
}
