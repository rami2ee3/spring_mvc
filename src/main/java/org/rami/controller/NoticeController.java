package org.rami.controller;

import org.rami.domain.NoticeVO;
import org.rami.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Inject
	private NoticeService noticeService;


	// TODO : 공지사항 목록 페이지 구현하세요
	@GetMapping("/list")
	public String noticeList(Model model) throws Exception{
		List<NoticeVO> list = noticeService.getNoticeListService();
		System.out.println(list);
		model.addAttribute("noticeList", list);
		return "notice/list";
	}

	@GetMapping("/write")
	public String noticeWrite() throws Exception{
		return "notice/write";
	}
	
	// TODO : 공지사항 작성 구현하세요
//	@PostMapping("/write")
//	public void noticeWriteAction(HttpServletRequest request) throws Exception{
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String writer = request.getParameter("writer");
//
//		NoticeVO vo = new NoticeVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setWriter(writer);
//		noticeService.insertNoticeService(vo);
//	}
//위 과정이랑 아래랑 같음.
	@PostMapping("/writer")
	public void noticeWriteAction (NoticeVO vo) throws Exception {
		noticeService.insertNoticeService(vo);
	}
}

