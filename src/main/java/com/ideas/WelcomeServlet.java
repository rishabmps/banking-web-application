package com.ideas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import com.google.gson.Gson;
import com.ideas.database.Account;
import com.ideas.database.BankingService;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome1"})
public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BankingService service = new BankingService();
		fetchAccountDetails(req, resp, service);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BankingService service = new BankingService();
		
		if(null != req.getParameter("operation") && req.getParameter("operation").equalsIgnoreCase("save")){
			resp.setContentType("text/html");
			System.out.println("Calling doPost");
			String name = req.getParameter("Account_name");
			String birtDate = req.getParameter("BirthDate");
			String type = req.getParameter("Account_type");
			String mobile  = req.getParameter("Mobile_no");
			String pan_no  = req.getParameter("Pan_no");
			
			
			Account account = new Account(name, birtDate, type, mobile, pan_no);
			System.out.println(account.getBirtDate2());
			service.saveAccount(account);
			fetchAccountDetails(req, resp, service);
		}
		if(null!=req.getParameter("value")){
			resp.setContentType("text/plain");
			
			Account account = service.getAccountById(Integer.parseInt(req.getParameter("value")));
			PrintWriter writer = resp.getWriter();
			writer.write(AccountToJson(account));
			
		}
		if(null!=req.getParameter("operation")&&req.getParameter("operation").equalsIgnoreCase("update")){
			String name = req.getParameter("name");
			String birtDate = req.getParameter("birthdate");
			String type = req.getParameter("type");
			String mobile  = req.getParameter("Mobile_no");
			String pan_no  = req.getParameter("Pan_no");
			service.updateAccount(name,birtDate,type,mobile,pan_no);
			fetchAccountDetails(req, resp, service);
			
		}
		
		
		
//		req.setAttribute("name", list);
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HelloWorld.jsp");
//		dispatcher.forward(req,resp);
//		String education = req.getParameter("education");
//		String city = req.getParameter("city");
//		String date = req.getParameter("joining_date");
//		String Experience = req.getParameter("Experience");
//		String subject[] = req.getParameterValues("subject");
//		String s="";
//		for(int i=0;i<subject.length;i++){
//			s = s +" " +subject[i];
//		}
//		PrintWriter writer = resp.getWriter();
//		writer.write("Your name is: ");
//		writer.println(name);
//		writer.write("<br>Your Education level is : "+education);
//		writer.write("<br> Your current city is : "+city);
//		writer.println("<br>Your favourite subjects are : "+s);
//		writer.println("<br>Your Joining date is : "+date);
//		writer.println("<br>Your experience at the company : "+Experience);
//		

	}

	private String AccountToJson(Account account) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		return gson.toJson(account);
	}

	private void fetchAccountDetails(HttpServletRequest req, HttpServletResponse resp, BankingService service)
			throws ServletException, IOException {
		ArrayList<Account> accounts;
		accounts = service.selectAll();
		req.setAttribute("list", accounts);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HelloWorld.jsp");
		dispatcher.forward(req,resp);
	}
}
