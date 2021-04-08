package com.google.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s3.MyAbstractTest;
import com.google.s3.board.BoardDTO;
import com.google.s3.board.notice.NoticeDAO;
import com.google.s3.board.notice.NoticeDTO;
import com.google.s3.util.Pager;
import com.google.s3.util.Pager_BackUp;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;

	//@Test
	public void getSelectTest() throws Exception {
		BoardDTO boardDTO = noticeDAO.getSelect(null);

		assertNotNull(boardDTO);
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
		BoardDTO boardDTO = new NoticeDTO();
		boardDTO.setTitle("Daum");
		boardDTO = noticeDAO.getSelect(boardDTO);
		boardDTO.setContents("Daum");
		int result = noticeDAO.setUpdate(boardDTO);

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
