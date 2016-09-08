package com.ideas;

import org.springframework.stereotype.Service;

@Service("Arithmaticcalculator")
public class CalculatorArithmatic implements Calculator {

	public int add(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("using Arithmatics");
		return i+j;
	}

}
