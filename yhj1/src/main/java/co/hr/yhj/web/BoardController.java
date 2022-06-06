package co.hr.yhj.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hr.yhj.service.BoardService;
import co.hr.yhj.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardDao;
	
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		model.addAttribute("board", boardDao.boardSelectList(1,"전체"));
		return "board//boardList";
	}
	@RequestMapping("/boardInsertForm.do")
	public String boardInsertForm() {
		
		return "board/boardInsertForm";
	}
	@PostMapping("/boardInsert.do")
	public String boardInsert(BoardVO vo) {
		boardDao.boardInsert(vo);
		return "redirect:boardList.do";
	}
	@RequestMapping("/content.do")
	public String content(BoardVO vo, Model model) {
		
		boardDao.boardHitUpdate(vo.getBoardNum());
		model.addAttribute("content", boardDao.boardSelect(vo));
		return "board/boardContent";
	}
	@RequestMapping("/boardDelete.do")
	public String boardDelete(BoardVO vo) {
		boardDao.boardDelete(vo);
		return "redirect:boardList.do";
	}
	@RequestMapping("/boardModifyFrom.do")
	public String boardModifyFrom(BoardVO vo,Model model) {
		model.addAttribute("board", boardDao.boardSelect(vo));
		return "board/boardModifyFrom";
	}
	@RequestMapping("/boardModify.do")
	public String boardModify(BoardVO vo) {
		boardDao.boardUpdate(vo);
		return "redirect:boardList.do";
	}
	@PostMapping("/ajaxSelect.do")
	@ResponseBody
	public List<BoardVO> ajaxSelect(@RequestParam(value = "state") int state, @RequestParam("key") String key){
		return boardDao.boardSelectList(state, key);
	}
	
}
