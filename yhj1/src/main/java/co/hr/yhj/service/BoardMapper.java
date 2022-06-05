package co.hr.yhj.service;

import java.util.List;

import co.hr.yhj.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
	
	int boardHitUpdate(int num);
}
