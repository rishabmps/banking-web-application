package com.ideas.database;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeviceManagerTest {
	BankingService service;
	@Before
	public void setup(){
	 service = new BankingService();
	}
	@Test
	public void shouldInsertIntoDb(){
		
		
	}
	@Test
	
	public void shouldReturnCountofAccounts(){
		
	
		Assert.assertNotNull(service.getCount("select count(*) as count from account"));
		
	}
	
	@Test
	public void shouldInsertData(){
		
		Integer preCount = service.getCount("select count(*) as count from account");
		Account account = new Account("Rishabh","1995-05-08","saving","1234567899","AYP10WERT");
		service.saveAccount(account);
		Integer postCount = service.getCount("select count(*) as count from account");
		Assert.assertEquals(preCount+ 1,postCount,0);
	}
	
	@Test
	public void findAllTest(){
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts = service.selectAll();
		
		Assert.assertEquals("1995-05-08",accounts.get(0).getBirtDate2() );
	}
	
	public void findByPanTest(){
		Account account = service.getByPan("Select account_name,birthdate,account_type,mobile_no,pan_card from account where pan_card='ASDFGHJKL'");
		Assert.assertEquals("manoj",account.getName2() );
	}
	
	
	
}
