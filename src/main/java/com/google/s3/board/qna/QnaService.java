package com.google.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		int perPage=10;
		int perBlock=5;

		// ---- startRow, lastRow ----
		long startRow = (pager.getCurPage()-1)*perPage+1;
		long lastRow = pager.getCurPage()*perPage;

		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);

		//1. totalCount
		long totalCount=qnaDAO.getTotalCount(pager);

		//2. totalPage
		long totalPage = totalCount / perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}

		//3. totalBlock
		long totalBlock = totalPage / perBlock;
		if(totalPage%5 != 0) {
			totalBlock++;
		}

		//4. curBlock
		long curBlock = pager.getCurPage()/perBlock;
		if(pager.getCurPage()%perBlock != 0) {
			curBlock++;
		}

		//5. startNum, lastNum
		long startNum = (curBlock-1)*perBlock+1;
		long lastNum = curBlock*perBlock;


		//6. curBlock이 마지막 block일 때 (totalBlock)
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}

		//7. 이전, 다음 block 존재 여부
		// 이전
		if(curBlock != 1) {
			pager.setPre(true);
		}

		// 다음
		if(curBlock != totalBlock) {
			pager.setNext(true);
		}

		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);

		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		int result = qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return 0;
	}
}