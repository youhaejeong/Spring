package co.micol.yhj.service;

import java.util.List;

import co.micol.yhj.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);

}
