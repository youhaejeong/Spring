package co.micol.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList(@Param("state") int state,@Param("key") String key); //하나이상의 매개변수를 받을려면 @Param("----") 받아야함 
	NoticeVO noticeSelect(NoticeVO vo); //한글조회 세부목록
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	//이 위까지가 기본 CRUD
	int noticeHitUpdate(int id); //조회수 변경 
}
