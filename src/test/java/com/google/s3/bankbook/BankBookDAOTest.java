package com.google.s3.bankbook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s3.MyAbstractTest;

public class BankBookDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void setWriteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookname("Test");
		bankBookDTO.setBookrate(0.12);
		bankBookDTO.setBooksale("Y");
		int result = bankBookDAO.setWrite(bankBookDTO);
		
		assertEquals(1, result);
	}
	
}
