package org.rami.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.rami.domain.BoardVO;
import org.rami.domain.CompanyVO;
import org.rami.domain.MemberVO;
import org.rami.service.BoardService;
import org.rami.service.CompanyService;
import org.rami.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private MemberService memberService;
	@Inject
	private CompanyService companyService;
	@Inject
	private BoardService boardService;

	@GetMapping("/")
	public String home(HttpServletRequest request, Model model) throws Exception{
		String id = request.getParameter("id");
		// 파라미터가 빈값일경우 에러나니까 기본값 넣어주는거임
		if (id == null){
			id = "1";
		}
		
		// 멤버 객체를 불러와서 모델에 담아준다
		MemberVO member = memberService.getMember();
		model.addAttribute("member", member);

		// TODO : 컴패니 서비스에서 회사 객체 불러와서 모델에 담아준다
		CompanyVO company = companyService.getCompanyService(Integer.parseInt(id));
										// myCompany라는 이름으로 모델에 company객체를 담아서 전달하겠다
		model.addAttribute("myCompany", company);

		return "home";
	}

	// GET : write 라는 url을 브라우저에서 주소로 들어왔을때 동작하는거 해주세요~
	@GetMapping("/write")
	public String write() throws Exception{
		return "write";
	}
	

	// 글 쓰려고 만들어 놓은 컨트롤러
	// POST : post method로 write 라는 url로 호출되면 동작되는거에요~
	@PostMapping("/write")
	public String write(HttpServletRequest request) throws Exception {
		String title = request.getParameter("title");
        String content = request.getParameter("content");

		// TODO : 서비스 호출해서 이제 글을 넣어봅시다
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		boardService.insertBoardService(vo);

		return null;
	}


	// 글 목록을 보는 컨트롤러 만들어주세요 ( GET )
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		// list.jsp 에다가
		// List<BoardVO>를 불러와서 전달하고싶어
		// 그러면 Model에 담아서주면됩니다!
		// 모델은 어떻게 쓸까?
		// 저렇게 파라미터 안에다가 넣으면 됩니다
		// 이제 모델에다가 서비스 호출한거를 담아보자
		List<BoardVO> list = boardService.getBoardListService();
		// 모델에다가 담는거는 어떻게 쓸까?
		// 키, 벨류
		model.addAttribute("boardList", list);
		return "list";
	}




}
