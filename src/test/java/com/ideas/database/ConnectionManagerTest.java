package com.ideas.database;

import org.junit.Test;

import junit.framework.Assert;

public class ConnectionManagerTest {
	
	
	@Test
	public void checkConnection(){
		ConnectionManager manager  = new ConnectionManager();
		Assert.assertNotNull(manager.connect());
	}
	
}
