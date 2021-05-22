package com.pp.ut.service.impl;

import java.util.Arrays;
import java.util.OptionalInt;

import com.pp.ut.repo.PpCalcRepo;

public class PpCalcService {
	
	private PpCalcRepo ppCalciRepo;
	
	
	
	public void setPpCalciRepo(PpCalcRepo ppCalciRepo) {
		this.ppCalciRepo = ppCalciRepo;
	}



	public int sumArray(int[] array) {
		if(array == null) return 0;
		OptionalInt opt= Arrays.stream(array).reduce((a,b) -> a+b);
		if(opt.isPresent()) return opt.getAsInt();
		return 0;
		
	}
	
	public int sumArray() {
		int[] array = ppCalciRepo.retriveCalcData();
		if(array == null) return 0;
		OptionalInt opt= Arrays.stream(array).reduce((a,b) -> a+b);
		if(opt.isPresent()) return opt.getAsInt();
		return 0;
		
	}
	
	
	

}
