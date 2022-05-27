package co.micol.prj.student.service;

import java.util.List;

import co.micol.prj.student.vo.StudentVO;

public interface StudentService {
		 //기본전 CRUD
		List<StudentVO> studentSelectList();
		StudentVO studentSelect(StudentVO vo); //한명의 데이터 조회 or login기능 가능 
		int studentInsert(StudentVO vo);
		int studentUpdate(StudentVO vo);
		int studentDelete(StudentVO vo);
		
		
		//아이디 중복체크
		boolean studentIdCheck(String id);
		
		

}
