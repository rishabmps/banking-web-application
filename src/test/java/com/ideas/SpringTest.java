package com.ideas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"Spring-AutoScan.xml"})
public class SpringTest {
@Qualifier("NonArithmaticcalculator")
	@Autowired
	Calculator calculator;
	@Test
	public void shouldAdd(){
		int total = calculator.add(4,8);
		System.out.println("Total is :" + total);
		Assert.assertTrue(total==12);
	}
}
