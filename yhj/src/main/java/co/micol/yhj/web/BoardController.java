package co.micol.yhj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.yhj.service.BoardService;
import co.micol.yhj.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	public BoardService BoardDao;
	
 @RequestMapping("/boardList.do")
 public String boardList(Model model) {
	 model.addAttribute("board",BoardDao.boardSelectList());
	 return "board/boardList";
 }
 @RequestMapping("/boardInsertForm.do")
 public String boardInsertForm() {
	 return "board/boardInsertForm";
 }
 @PostMapping("/boardInsert.do")
 public String boardInsert(BoardVO vo) {
	 
	 BoardDao.boardInsert(vo);
	 return "redirect:boardList.do";
 }
 
 
 
}
