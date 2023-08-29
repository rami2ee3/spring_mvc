package org.rami.controller;

import org.rami.domain.AjaxBoard2VO;
import org.rami.domain.AjaxBoardReply2VO;
import org.rami.service.AjaxBoard2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/ajax-board2")
public class AjaxBoard2Controller {

    private static final Logger logger = LoggerFactory.getLogger(AjaxBoard2Controller.class);

    @Inject
    private AjaxBoard2Service ajaxBoard2Service;

    @GetMapping("/list")
    public String getAjaxBoard2List(Model model) throws Exception {
        List<AjaxBoard2VO> list = ajaxBoard2Service.getAjaxBoard2ListService();
        model.addAttribute("ajax2List", list);
        return "ajax-board2/list";
    }

    @GetMapping("/detail/{id}")
    public String getAjaxBoard2(@PathVariable int id, Model model) throws Exception{
        AjaxBoard2VO detail = ajaxBoard2Service.getAjaxBoard2Service(id);
        model.addAttribute("detail", detail);

        List<AjaxBoardReply2VO> replyList = ajaxBoard2Service.getReplyListService(id);
        model.addAttribute("replyList", replyList);
        return "ajax-board2/detail";
    }

    @DeleteMapping("delete/{id}")
    public @ResponseBody int deleteAjaxBoard2(@PathVariable int id) throws Exception{
        return ajaxBoard2Service.deleteAjaxBoard2Service(id);
    }

    @GetMapping("/write")
    public String getAjaxBoard2Write() throws Exception{
        return "ajax-board2/write";
    }

    @PostMapping("/write")
    public @ResponseBody int ajaxBoard2WriteAction(AjaxBoard2VO vo) throws Exception{
        return ajaxBoard2Service.insertAjaxBoard2Service(vo);
    }

    @PostMapping("/reply")
    public @ResponseBody AjaxBoardReply2VO insertReply(AjaxBoardReply2VO vo) throws Exception{
        AjaxBoardReply2VO reply = null;
        try {
            int ajaxBoardReply2Id = ajaxBoard2Service.insertReplyService(vo);
            reply = ajaxBoard2Service.getReplyService(ajaxBoardReply2Id);
            return reply;
        } catch (Exception e){
            e.printStackTrace();
        }
        return reply;
    }

    @GetMapping("/update/{id}")
    public String updateAjaxBoard2(@PathVariable int id, Model model) throws Exception{
        AjaxBoard2VO detail = ajaxBoard2Service.getAjaxBoard2Service(id);
        model.addAttribute("detail", detail);
        return "ajax-board2/update";
    }

    @PostMapping("/update")
    public @ResponseBody int updateAction(AjaxBoard2VO vo) throws Exception{
        return ajaxBoard2Service.updateAjaxBoard2(vo);
    }
}
