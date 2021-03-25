package com.google.s3.account;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s3.MyAbstractTest;

public class AccountDAOTest extends MyAbstractTest {
	
	@Autowired
	private AccountDAO accountDAO;
	
	//@Test
	public void getListTest() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId("pw1");

		List<AccountDTO> ar = accountDAO.getList(accountDTO);
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void setInsertTest() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountnumber("123-1-12345");
		accountDTO.setAccountbalance(80000);
		accountDTO.setId("minami");
		accountDTO.setBooknumber(1);
		int result = accountDAO.setInsert(accountDTO);
		assertEquals(1, result);
	}
}
