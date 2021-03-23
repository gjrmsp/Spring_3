package com.google.s3.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s3.bankbook.BankBookDAO.";

	public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}

	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", bankBookDTO);
	}

	public int setWrite(BankBookDTO bankBookDTO)throws Exception{
		int result = sqlSession.insert(NAMESPACE+"setWrite", bankBookDTO);
		return result;
	}

	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception{
		//long num=1L;
		bankBookDTO = sqlSession.selectOne(NAMESPACE+"getSelect", bankBookDTO);		
		return bankBookDTO;
	}	

	//getList
	//bankbook table의 모든 데이트 조회 후 리턴
	public List<BankBookDTO> getList()throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}

}