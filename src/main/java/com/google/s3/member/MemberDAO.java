package com.google.s3.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.jdbc.driver.DBConversion;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="com.google.s3.member.MemberDAO.";
	
	//Update
	public int memberUpdate(MemberDTO memberDTO) throws Exception {	
		//id를 제외하고 나머지 수정
		return sqlsession.update(NAMESPACE+"memberUpdate",memberDTO);
	}
	
	//Delete
	public int memberDelete(MemberDTO memberDTO) throws Exception {	
		return sqlsession.delete(NAMESPACE+"memberDelete",memberDTO);
	}
	
	//Join
	public int memberJoin(MemberDTO memberDTO) throws Exception {	
		//id를 제외하고 나머지 수정
		return sqlsession.insert(NAMESPACE+"memberJoin",memberDTO);
	}

	//login - id pw를 받아서 조회
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return sqlsession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	}

}