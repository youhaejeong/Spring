package co.hr.yhj.service;

import java.util.List;

import co.hr.yhj.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList(int state, String key);
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
	
	int boardHitUpdate(int num);
}
