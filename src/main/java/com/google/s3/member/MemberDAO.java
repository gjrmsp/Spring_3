package com.google.s3.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.net.aso.m;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.google.s3.member.MemberDAO.";
	
	//setFileInsert
	public int setFileInsert(MemberFileDTO memberFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setFileInsert", memberFileDTO);
	}

	//Update
	public int memberUpdate(MemberDTO memberDTO) throws Exception {	
		//id를 제외하고 나머지 수정
		return sqlSession.update(NAMESPACE+"memberUpdate",memberDTO);
	}
	
	//Delete
	public int memberDelete(MemberDTO memberDTO) throws Exception {	
		return sqlSession.delete(NAMESPACE+"memberDelete",memberDTO);
	}
	
	//Join
	public int memberJoin(MemberDTO memberDTO) throws Exception {	
		return sqlSession.insert(NAMESPACE+"memberJoin",memberDTO);
	}

	//login - id pw를 받아서 조회
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	}
	
	public MemberFileDTO memberLoginFile(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberLoginFile", memberDTO);
	}

}