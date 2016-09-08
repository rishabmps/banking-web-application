package com.ideas;

import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.jetty.testing.HttpTester;
import org.eclipse.jetty.testing.ServletTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyserveletTest {
	ServletTester servletTest;
		 
	@Before
	public void setup() throws Exception{
		servletTest  = new ServletTester();
		servletTest.setContextPath("/WelcomeServlet");
		servletTest.addServlet(WelcomeServlet.class, "/");
		servletTest.start();
	}
	@After
	public void After() throws Exception{
		servletTest.stop();
	}
	@Test
	public void shouldGetTheRequest() throws IOException, Exception{
		HttpTester request = new HttpTester();
		request.setMethod("GET");
		request.setHeader("Host", "127.0.0.1");
		request.setURI("/WelcomeServlet/welcome1");
		request.setVersion("HTTP/1.0");
		
		HttpTester response = new HttpTester();
		response.parse(servletTest.getResponses(request.generate()));
		assertNull(response.getMethod());
		assertEquals(200, response.getStatus());
		
	}
	@Test
	public void shouldGetTheRequestAgain() throws IOException, Exception{
		HttpTester request = new HttpTester();
		request.setMethod("POST");
		request.setHeader("Host", "127.0.0.1");
		request.setURI("/WelcomeServlet/welcome1");
		request.setVersion("HTTP/1.0");
		request.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		request.setContent("name=1&address=1"); 

		HttpTester response = new HttpTester();
		response.parse(servletTest.getResponses(request.generate()));
		
		assertNull(response.getMethod());
		assertEquals(200, response.getStatus());
	}
}
