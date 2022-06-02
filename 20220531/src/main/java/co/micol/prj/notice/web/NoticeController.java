package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;

	@Autowired
	private String saveDir; // Ioc에서 저장된 것을 가져온다.

	@RequestMapping("/noticeList.do") // 전체목록보기
	public String noticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList(1, "전체"));
		return "notice/noticeList";
	}

	@RequestMapping("/noticeInsertFrom.do")
	public String noticeInsertFrom() {

		return "notice/noticeInsertFrom";
	}

	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) {

		String fileName = file.getOriginalFilename();
		//파일이 없을떄 임시방편으로 초기화 하여 사용
		//vo.setNoticeAttech("");
		//vo.setNoticeDir("")

		//파일이 존재한다면,
		if (fileName != null && !fileName.isEmpty() && fileName.length() !=0) {
			
			//UUID 사용하여 파일명 변경 
			String uid = UUID.randomUUID().toString();
			String saveFileName = uid +fileName.substring(fileName.indexOf("."));
			//uuid.xml
			//UUID로 만든 파일명 넣기 
			File target = new File(saveDir, saveFileName);
			
			vo.setNoticeAttech(fileName); //파일명 
			vo.setNoticeDir(saveFileName);
			//vo.setNoticeDir(target.toString()); // 실제 저장 경로를 담고
			try {
				FileCopyUtils.copy(file.getBytes(), target); // 실제 파일을 저장

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		noticeDao.noticeInsert(vo); // 파일이 있을떄 파일을 먼저 업로드 하고 db에 저장
		return "redirect:noticeList.do";
	}

	@PostMapping("/getContent.do")
	public String getContent(NoticeVO vo, Model model) {
		// public String getContent(@RequestParam int noticeId) {
		// 주소창의 getContent.do?noticeId=3 의 3을 인식할수 있음 get방식일떄 requestparam을 인식할수 있다
		noticeDao.noticeHitUpdate(vo.getNoticeId());
		model.addAttribute("content", noticeDao.noticeSelect(vo));
		return "notice/noticeContent";
	}
	//파일 다운로드 
	@RequestMapping("/downLoad.do")
	public void downLoad(@RequestParam("saveName") String saveName,@RequestParam("fileName") String fileName, HttpServletResponse resp) {
		//file을 배열로 전환 
		try {
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(
					new File(saveDir+File.separator+saveName));
			resp.reset(); //response 객체 초괴화 
			//응답하는 객체를 넘겨줌 resp에다가  
			//모든 타입의 데이터를 전송할때 사용 
			resp.setContentType("application/octet-stream");
			//파일 길이만큼 사이즈 설정
			resp.setContentLength(fileByte.length);
			//파일을 다운 받기위한 설정 
			resp.setHeader("Content-Disposition", 
				"attachment; filename=\""+URLEncoder.encode(fileName,"UTF-8")+"\"");
			//화면의 데이터를 다운할수있게끔 설정 
			
			resp.getOutputStream().write(fileByte); //실제 파일 저장 
			resp.getOutputStream().flush();
			resp.getOutputStream().close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//게시글 삭제 
	@RequestMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo) {
		noticeDao.noticeDelete(vo);
		return "redirect:noticeList.do";
	}
	
	@RequestMapping("/noticeModifyFrom.do")
	public String noticeModifyFrom(NoticeVO vo,Model model) {
		model.addAttribute("notice", noticeDao.noticeSelect(vo));
		return  "notice/noticeModifyFrom";
	}
	@RequestMapping("/noticeModify.do")
	public String noticeModify(NoticeVO vo, MultipartFile file) {
		
		String fileName = file.getOriginalFilename();

		//파일이 존재한다면,
		if (fileName != null && !fileName.isEmpty() && fileName.length() !=0) {
			
			//UUID 사용하여 파일명 변경 
			String uid = UUID.randomUUID().toString();
			String saveFileName = uid +fileName.substring(fileName.indexOf("."));
			//uuid.xml
			//UUID로 만든 파일명 넣기 
			File target = new File(saveDir, saveFileName);
			
			vo.setNoticeAttech(fileName); //파일명 
			vo.setNoticeDir(saveFileName);
			//vo.setNoticeDir(target.toString()); // 실제 저장 경로를 담고
			try {
				FileCopyUtils.copy(file.getBytes(), target); // 실제 파일을 저장

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		noticeDao.noticeUpdate(vo);
		
		return "redirect:noticeList.do";
	}
	
	//검색 기능 
	@PostMapping("/ajaxSearchList.do")
	@ResponseBody
	public List<NoticeVO> ajaxSearchList(@RequestParam("state") int state, @RequestParam("key") String key) {
		return noticeDao.noticeSelectList(state, key);
	}
}
