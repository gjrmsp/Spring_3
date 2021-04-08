package com.google.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.s3.board.BoardDTO;
import com.google.s3.board.BoardService;
import com.google.s3.util.Pager;
import com.google.s3.util.Pager_BackUp;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public int setReply(QnaDTO qnaDTO) throws Exception {
		//부모 글의 ref, step, depth 조회
		BoardDTO boardDTO = qnaDAO.getSelect(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		System.out.println(parent.getRef());
		System.out.println(parent.getStep());
		System.out.println(parent.getDepth());
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		int result = qnaDAO.setReplyUpdate(parent);
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		//1. row
		pager.makeRow();
		
		//2. pageing
		long totalCount = qnaDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		int result = qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		return qnaDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}
}