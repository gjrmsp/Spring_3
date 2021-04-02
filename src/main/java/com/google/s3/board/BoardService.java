package com.google.s3.board;

import java.util.List;

import com.google.s3.util.Pager;

public interface BoardService {

	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;
}
