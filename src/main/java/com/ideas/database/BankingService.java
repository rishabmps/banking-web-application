package com.ideas.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BankingService {

	public Integer getCount(String query) {
		// TODO Auto-generated method stub
		DbManager manager = new DbManager();
		Integer count = 0;
		
			
			ResultSet executeQuery = manager.findAll(query);
		try {
			while(executeQuery.next()){
				count = executeQuery.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.closeConnection();
			
		return count;
		
	}

	public void saveAccount(Account account) {
		// TODO Auto-generated method stub
		DbManager manager = new DbManager();
		manager.Update("INSERT INTO account(account_name,birthdate,account_type,mobile_no,pan_card) "
				+ "VALUES('"+account.getName2()+"','"+account.getBirtDate2()+"','"+account.getType2()+"','"+account.getMobile2()+"','"+account.getPan_no2()+"');");
	manager.closeConnection();	
		
	}
	
	public ArrayList<Account> selectAll(){
		DbManager manager = new DbManager();
		ArrayList<Account> accounts = new ArrayList<Account>();
		ResultSet executeQuery = manager.findAll("select account_name,birthdate,account_type,mobile_no,pan_card from account");
		try {
			while(executeQuery.next()){
				String name = executeQuery.getString("account_name");
				String birthDate = executeQuery.getString("birthdate");
				String type = executeQuery.getString("account_type");
				String mobile = executeQuery.getString("mobile_no");
				String pan_no = executeQuery.getString("pan_card");
				accounts.add(new Account(name, birthDate, type, mobile, pan_no));
				
			}
			return accounts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.closeConnection();
		return accounts;
		
	}

	public Account getByPan(String query) {
		// TODO Auto-generated method stub
		DbManager manager = new DbManager();
		ResultSet executeQuery = manager.findAll(query);
		
		String birthDate;
		Account account = null;
		try {
			String name = executeQuery.getString("account_name");
			birthDate = executeQuery.getString("birthdate");
			String type = executeQuery.getString("account_type");
			String mobile = executeQuery.getString("mobile_no");
			String pan_no = executeQuery.getString("pan_card");
			account = new Account(name, birthDate, type, mobile, pan_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.closeConnection();
		return account;
		
	}

	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		DbManager manager = new DbManager();
		ResultSet executeQuery = manager.findAll("select account_name,birthdate,account_type,mobile_no,pan_card from account where account_id="+id);
		Account account = null;
		try {
			while(executeQuery.next()){
				String name = executeQuery.getString("account_name");
				String birthDate = executeQuery.getString("birthdate");
				String type = executeQuery.getString("account_type");
				String mobile = executeQuery.getString("mobile_no");
				String pan_no = executeQuery.getString("pan_card");
				account = new Account(name, birthDate, type, mobile, pan_no);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.closeConnection();
		return account;
		
	}

	public void updateAccount(String name, String birtDate, String type, String mobile, String pan_no) {
		// TODO Auto-generated method stub
		DbManager manager = new DbManager();
		String s="UPDATE account SET account_name='"+name+"',birthdate='"+birtDate+"',account_type='"+type+"',mobile_no='"+mobile+"' where pan_card='"+pan_no+"'; ";
		manager.Update(s);
		manager.closeConnection();
	}

}
