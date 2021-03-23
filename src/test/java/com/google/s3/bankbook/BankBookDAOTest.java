package com.google.s3.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s3.MyAbstractTest;

public class BankBookDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void setUpdateTest()throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBooknumber(5);
		
		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
		
		bankBookDTO.setBookname("New Poduct");
		
		int result = bankBookDAO.setUpdate(bankBookDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void setDeleteTest()throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBooknumber(9);
		int result = bankBookDAO.setDelete(bankBookDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void getListTest()throws Exception{
		List<BankBookDTO> ar = bankBookDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void getSelectTest()throws Exception{
		BankBookDTO bankBookDTO = bankBookDAO.getSelect(null);
		assertNotNull(bankBookDTO);
	}
	
	//@Test
	public void setWriteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookname("Test");
		bankBookDTO.setBookrate(0.12);
		bankBookDTO.setBooksale("Y");
		int result = bankBookDAO.setWrite(bankBookDTO);
		
		assertEquals(1, result);
	}
	
	

}