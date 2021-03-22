package com.google.s3;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionTest extends MyAbstractTest {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void connectionTest() throws Exception {
		assertNotNull(dataSource.getConnection());
	}

}
