package org.rami.controller;

import org.rami.domain.AjaxBoardReplyVO;
import org.rami.domain.AjaxBoardVO;
import org.rami.service.AjaxBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ajax-board")
public class AjaxBoardController {

    private static final Logger logger = LoggerFactory.getLogger(AjaxBoardController.class);

    @Inject
    private AjaxBoardService ajaxBoardService;

    // list
    @GetMapping("/list")
    public String getAjaxBoardList(Model model) throws Exception {
        // TODO : 모델에 list 담아서 jsp에 보여주기
        List<AjaxBoardVO> list = ajaxBoardService.getAjaxBoardListService();
        model.addAttribute("ajaxBoardList", list);
        return "ajax-board/list";
    }


    // detail
    @GetMapping("/detail/{id}")
    public String getAjaxBoardDetail(@PathVariable int id, Model model) throws Exception {
        // 글 내용 불러오기
        AjaxBoardVO detail = ajaxBoardService.getAjaxBoardService(id);
        model.addAttribute("detail", detail);

        // TODO : 댓글 불러오기
        List<AjaxBoardReplyVO> replyList = ajaxBoardService.getReplyListService(id);
        model.addAttribute("replyList", replyList);

        return "ajax-board/detail";
    }

    // 글 삭제
    @DeleteMapping("delete/{id}")
    public @ResponseBody int deleteBoardAction(@PathVariable int id) throws Exception {
        return ajaxBoardService.deleteAjaxBoardService(id);
    }

    // 글 등록 페이지 조회
    @GetMapping("/write")
    public String getAjaxBoardWrite() throws Exception {
        return "ajax-board/write";
    }

    // 글 등록 액션
    @PostMapping("/write")
    public @ResponseBody int ajaxBoardWriteAction(AjaxBoardVO vo) throws Exception {
        return ajaxBoardService.ajaxBoardWriteService(vo);
    }


    // update
    @GetMapping("/update")
    public String getAjaxBoardUpdate() throws Exception {
        return "ajax-board/update";
    }

    // reply 작성하는 post 컨트롤러
    @PostMapping("/reply")
    public @ResponseBody AjaxBoardReplyVO insertReply(AjaxBoardReplyVO vo) throws Exception {
        int ajaxBoardReplyId = ajaxBoardService.insertReplyService(vo);
        // TODO : 댓글 내용 조회
        AjaxBoardReplyVO reply = ajaxBoardService.getReplyService(ajaxBoardReplyId);
        return reply;
    }


}
