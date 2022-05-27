package co.micol.prj.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.student.service.StudentService;

@Controller //무조건
public class StudentController {
	@Autowired
	StudentService studentDao;  //DAO객체를 자동으로 주입 
	
	//호출명 메소드명 ??? 모두 일치 시킴 
	//왠만하면 model객체를 따라다님 
	@RequestMapping("/studentList.do")
	public String studentList(Model model) {
		
		model.addAttribute("students", studentDao.studentSelectList());
		return "student/studentList";
	}

}
