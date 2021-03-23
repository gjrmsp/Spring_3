package com.google.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void memberUpdate() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id10");
		memberDTO = memberDAO.memberLogin(memberDTO);
		memberDTO.setPw("pw999");
		assertEquals(memberDAO.memberUpdate(memberDTO), 1);
	}
	
	//@Test
	public void memberDelete() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id10");
		assertEquals(memberDAO.memberDelete(memberDTO), 1);
	}
	
	//@Test
	public void memberJoin() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id10");
		memberDTO.setPw("pw10");
		memberDTO.setName("id10");
		memberDTO.setEmail("id10@id10.id10");
		memberDTO.setPhone("01000000000");
		assertEquals(memberDAO.memberJoin(memberDTO), 1);
	}
	
	//@Test
	public void memberLoginTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		assertNotNull(memberDAO.memberLogin(memberDTO));
	}

}