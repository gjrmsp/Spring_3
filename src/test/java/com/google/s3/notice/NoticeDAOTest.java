package com.google.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s3.MyAbstractTest;
import com.google.s3.board.notice.NoticeDAO;
import com.google.s3.board.notice.NoticeDTO;
import com.google.s3.util.Pager;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;

	//@Test
	public void getListTest(Pager pager) throws Exception {
		List<NoticeDTO> ar = noticeDAO.getList(pager);
		assertNotEquals(0, ar.size());
		//assertEquals(3, ar.size());
	}

	//@Test
	public void getSelectTest() throws Exception {
		NoticeDTO noticeDTO = noticeDAO.getSelect(null);

		assertNotNull(noticeDTO);
	}

	@Test
	public void setInsertTest() throws Exception {
		for(int i=0;i<120;i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("Daum"+i);
			noticeDTO.setWriter("admin"+i);
			noticeDTO.setContents("Daum"+i);
			int result = noticeDAO.setInsert(noticeDTO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
	}

	//@Test
	public void setUpdateTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Daum");
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		noticeDTO.setContents("Daum");
		int result = noticeDAO.setUpdate(noticeDTO);

		assertEquals(1, result);		
	}

	//@Test
	public void setDelete() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(3);
		int result = noticeDAO.setDelete(noticeDTO);

		assertEquals(1, result);
	}

}
