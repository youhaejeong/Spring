package co.micol.prj.student.service;

import java.util.List;

import co.micol.prj.student.vo.StudentVO;
//둘의 메소드는 기본적으로 동일해야함 다만 매개변수가 두개이상일때는 전달하는 방법이 다를수 있음 
public interface StudentService {//dao에서 사용하는 인터페이스
	//전체회원 정보
	List<StudentVO > studentSelectList();
	//한명 정보 or 로그인처리
	StudentVO studentSelect(StudentVO vo);
	//입력 
	int studentInsert(StudentVO vo);
	//수정
	int studentUpdate(StudentVO vo);
	//삭제
	int studentDelete(StudentVO vo);
	//Id중복체크 값
	boolean idCheck(String id);

}
