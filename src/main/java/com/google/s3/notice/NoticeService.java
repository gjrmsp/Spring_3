package com.google.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.s3.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;

	public List<NoticeDTO> getList(long curPage) throws Exception {
		Pager pager = new Pager();
		long perPage = 10;
		long startRow = (curPage-1)*perPage+1;
		long lastRow = curPage*perPage;
		
		System.out.println(startRow);
		System.out.println(lastRow);
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		return noticeDAO.getList(pager);
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getSelect(noticeDTO);
	}

	public int setInsert(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setInsert(noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setDelete(noticeDTO);
	}
	
}
