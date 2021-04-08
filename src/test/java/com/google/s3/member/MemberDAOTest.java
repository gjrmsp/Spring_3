package com.google.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void setMemberFileInsertTest() throws Exception {
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId("sana");
		memberFileDTO.setFileName("f1");
		memberFileDTO.setOrigineName("o1");

		int result =memberDAO.setFileInsert(memberFileDTO);
		assertEquals(1, result);

	}

	//@Test
	public void memberUpdateTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("mei");
		//		memberDTO = memberDAO.memberLogin(memberDTO);
		memberDTO.setPw("pw2");
		memberDTO.setName("mei");
		memberDTO.setPhone("01055555555");
		memberDTO.setEmail("mei@naver.com");
		assertEquals(memberDAO.memberUpdate(memberDTO), 1);
	}

	//@Test
	public void memberDeleteTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id4");
		assertEquals(memberDAO.memberDelete(memberDTO), 1);
	}

	//@Test
	public void memberJoinTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("mei");
		memberDTO.setPw("pw1");
		memberDTO.setName("mei");
		memberDTO.setEmail("mei@naver.com");
		memberDTO.setPhone("01055555555");
		assertEquals(memberDAO.memberJoin(memberDTO), 1);
	}

	//@Test
	public void memberLoginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		assertNotNull(memberDAO.memberLogin(memberDTO));
	}

}