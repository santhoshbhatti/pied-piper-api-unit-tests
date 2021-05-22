package com.pp.ut.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.pp.ut.repo.PpCalcRepo;

class PpCalcRepoStubImpl implements PpCalcRepo{
	
	private int[] retVal;


	public PpCalcRepoStubImpl(int[] retVal) {
		super();
		this.retVal = retVal;
	}


	@Override
	public int[] retriveCalcData() {
		// TODO Auto-generated method stub
		return retVal;
	}
	
}
class PpCalcServiceStubTest {

	@Test
	void sumArrayTest() {
		PpCalcService service=new PpCalcService();
		service.setPpCalciRepo(new PpCalcRepoStubImpl(new int[] {10,20,40}));
		int actual=service.sumArray();
		int expected=70;
		assertEquals(expected, actual);
	}
	
	@Test
	void sumArrayNullTest() {
		PpCalcService service=new PpCalcService();
		service.setPpCalciRepo(new PpCalcRepoStubImpl(null));
		int actual=service.sumArray();
		int expected=0;
		assertEquals(expected, actual);
	}
	
	@Test
	void sumArrayEmptyTest() {
		PpCalcService service=new PpCalcService();
		service.setPpCalciRepo(new PpCalcRepoStubImpl(new int[] {}));
		int actual=service.sumArray();
		int expected=0;
		assertEquals(expected, actual);
	}
	
	@Test
	void sumArraySingleElemTest() {
		PpCalcService service=new PpCalcService();
		service.setPpCalciRepo(new PpCalcRepoStubImpl(new int[] {3}));
		int actual=service.sumArray();
		int expected=3;
		assertEquals(expected, actual);
	}

}
