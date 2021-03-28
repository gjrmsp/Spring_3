package com.google.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s3.MyAbstractTest;

public class NoticeDAOTest extends MyAbstractTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void getListTest() throws Exception {
		List<NoticeDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}

	//@Test
	public void getSelectTest() throws Exception {
		NoticeDTO noticeDTO = noticeDAO.getSelect(null);
		
		assertNotNull(noticeDTO);
	}
	
	//@Test
	public void setInsertTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(4);
		noticeDTO.setTitle("Google");
		noticeDTO.setWriter("gjrmsp");
		noticeDTO.setContents("Running Man");
		int result = noticeDAO.setInsert(noticeDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void setUpdateTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("PES_2021");
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		noticeDTO.setContents("Chelsea");
		int result = noticeDAO.setUpdate(noticeDTO);
		
		assertEquals(1, result);		
	}
	
	@Test
	public void setDelete() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(3);
		int result = noticeDAO.setDelete(noticeDTO);
		
		assertEquals(1, result);
	}
	
}
