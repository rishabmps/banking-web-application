package com.ideas;

import org.springframework.stereotype.Service;

@Service("NonArithmaticcalculator")
public class Nonarithmatic implements Calculator {

	public int add(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("HeyHey");
	return a+b;
	}

}
