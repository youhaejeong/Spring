package co.micol.prj.student.service;

import java.util.List;

import co.micol.prj.student.vo.StudentVO;

public interface StudentMapper { //mybatis에서 사용하는 인터페이스
	
		List<StudentVO > studentSelectList();//전체회원 정보
		StudentVO studentSelect(StudentVO vo);//한명 정보 or 로그인처리
		int studentInsert(StudentVO vo);//입력 
		int studentUpdate(StudentVO vo);//수정
		int studentDelete(StudentVO vo);//삭제
		boolean idCheck(String id); //id중복 체크
}
