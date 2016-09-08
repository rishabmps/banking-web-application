package com.ideas.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BankingHibernateService {

	public List getAllAccountData() {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerfactoty = Persistence.createEntityManagerFactory("JPAExample");
		EntityManager entityManager = entityManagerfactoty.createEntityManager();

		List resultList = entityManager.createNativeQuery("Select * from account;").getResultList();
		entityManager.close();
		entityManagerfactoty.close();

		return resultList;
	}

	public AccountEntity createAccountEntity(String name, String type, String birthdate, String pan, String mobile) {
		AccountEntity account = new AccountEntity();
		account.setName(name);
		account.setType(type);
		account.setBirtDate(new Date());
		account.setMobile(mobile);
		account.setPan_no(pan);
		EntityManagerFactory entityManagerfactoty = Persistence.createEntityManagerFactory("JPAExample");
		EntityManager manager = entityManagerfactoty.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(account);
		manager.getTransaction().commit();
		manager.close();
		entityManagerfactoty.close();
		return account;
	}

	public AccountEntity updateAccount(int accountId) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerfactoty = Persistence.createEntityManagerFactory("JPAExample");
		EntityManager manager = entityManagerfactoty.createEntityManager();
		AccountEntity account = manager.find(AccountEntity.class, accountId);
		account.setName("LALALA");
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		entityManagerfactoty.close();
		return account;
	}

	public void deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerfactoty = Persistence.createEntityManagerFactory("JPAExample");
		EntityManager manager = entityManagerfactoty.createEntityManager();
		AccountEntity account = manager.find(AccountEntity.class, accountId);
		manager.remove(account);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		entityManagerfactoty.close();
	}

	public List findByName(String query) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerfactoty = Persistence.createEntityManagerFactory("JPAExample");
		EntityManager manager = entityManagerfactoty.createEntityManager();
		manager.getTransaction().begin();
		Query createNamedQuery = manager.createNamedQuery(query);
		createNamedQuery.setParameter("paraName", "manoram");
		List accounts = createNamedQuery.getResultList();
		manager.getTransaction().commit();
		manager.close();
		entityManagerfactoty.close();
		return accounts;
	}

}
