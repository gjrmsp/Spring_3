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
	
	public int setUpdate(MemberDTO memberDTO) throws Exception {
		return sqlsession.update(NAMESPACE+"setUpdate", memberDTO);
	}

	public int setDelete(MemberDTO memberDTO) throws Exception {
		return sqlsession.delete(NAMESPACE+"setDelete", memberDTO);
	}

	public int setWrite(MemberDTO memberDTO) throws Exception {
		return sqlsession.insert(NAMESPACE+"setWrite", memberDTO);
	}

	//memberJoin 데이터를 받아서 DB에 insert하는 메서드
	public int memberJoin(MemberDTO memberDTO) throws Exception{
	
		
		return result;
		
	}

		//login - id pw를 받아서 조회
	public MemberDTO login(MemberDTO memberDTO) throws Exception{

		//1. 로그인 정보 
		String user="user01";
		String password="user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. 클래스 로딩
		Class.forName(driver);

		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);

		//4. SQL문 생성
		String sql ="SELECT * FROM member WHERE id=? and pw=?";

		//5. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		//6. ? 세팅
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());

		//7. 최종 전송 후 처리
		ResultSet rs = st.executeQuery();

		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setPhone(rs.getString("phone"));
		} else {
			memberDTO = null;
		}

		//8. 해제
		rs.close();
		st.close();
		con.close();

		return memberDTO;
	}

}