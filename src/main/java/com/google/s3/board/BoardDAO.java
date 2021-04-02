package com.google.s3.board;

import java.util.List;

import com.google.s3.util.Pager;

public interface BoardDAO {
	//상수, 추상 메서드
	//접근 지정자는 무조건 public abstract
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;

}
