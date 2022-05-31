package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(int state, String key); //전체 부분 조회
	NoticeVO noticeSelect(NoticeVO vo); //한글조회 세부목록
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	//이 위까지가 기본 CRUD
	int noticeHitUpdate(int id); //조회수 변경 
	
}
