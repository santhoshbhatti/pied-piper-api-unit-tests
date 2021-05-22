package com.pp.ut.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PpCalcServiceTest {

	@Test
	void sumArrayTest() {
		PpCalcService service=new PpCalcService();
		int actual=service.sumArray(new int[] {10,20,30});
		int expected=60;
		assertEquals(expected, actual);
	}
	
	@Test
	void sumArrayNullTest() {
		PpCalcService service=new PpCalcService();
		int actual=service.sumArray(null);
		int expected=0;
		assertEquals(expected, actual);
	}
	
	@Test
	void sumArrayEmptyTest() {
		PpCalcService service=new PpCalcService();
		int actual=service.sumArray(new int[] {});
		int expected=0;
		assertEquals(expected, actual);
	}
	
	@Test
	void sumArraySingleElemTest() {
		PpCalcService service=new PpCalcService();
		int actual=service.sumArray(new int[] {3});
		int expected=3;
		assertEquals(expected, actual);
	}
	

}
