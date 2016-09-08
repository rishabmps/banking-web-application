package com.ideas.database;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HibernetServiceTest {
	@Test
	public void shouldGetAllData() {
		BankingHibernateService service = new BankingHibernateService();
		List accounts = service.getAllAccountData();
		System.out.println(accounts.get(0).toString());
		Assert.assertTrue(null != accounts);
	}

	 @Test
	 public void shouldCreateNewAccount(){
	 BankingHibernateService service = new BankingHibernateService();
	 AccountEntity account = service.createAccountEntity("unit", "saving",
	 "1975-05-18", "hanaha", "1234554321");
	 }
	 
	 @Test
	 public void shouldUpdateAccount(){
		 BankingHibernateService service = new BankingHibernateService();
		 AccountEntity account = service.updateAccount(5);
		 Assert.assertTrue(account.getName().equalsIgnoreCase("LALALA"));
	 }
	 
	 @Test
	 public void shouldDeleteAccount(){
		 BankingHibernateService service = new BankingHibernateService();
		 List accounts = service.getAllAccountData();
		 AccountEntity account = service.createAccountEntity("unit", "saving",
				 "1975-05-18", "hanaha", "1234554321");
		 
		 service.deleteAccount(account.getId());
		 List accounts2 = service.getAllAccountData();
		 Assert.assertTrue(accounts2.size()==accounts.size());
		 
	 }
	 @Test
	 public void shouldFindByNamedQuery(){
		 BankingHibernateService service = new BankingHibernateService();
		List accounts = service.findByName("findByName");
		Assert.assertNotNull(accounts);
	 }
}
