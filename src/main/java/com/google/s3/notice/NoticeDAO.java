package com.google.s3.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.google.s3.notice.NoticeDAO.";
	
	//getList
	public List<NoticeDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
		
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception {
		noticeDTO = sqlSession.selectOne(NAMESPACE+"getSelect", noticeDTO);
		return noticeDTO;
	}
	
	public int setInsert(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", noticeDTO);
	}
}
