package org.rami.controller;

import org.rami.domain.FormBoardVO;
import org.rami.service.FormBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/form-board")
public class FormBoardController {

    private static final Logger logger = LoggerFactory.getLogger(FormBoardController.class);

    @Inject
    private FormBoardService formBoardService;

    // list.jsp 조회
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        List<FormBoardVO> flist = formBoardService.getFormBoardListService();
        logger.info(flist.toString());
        model.addAttribute("formBoardList", flist);
        return "form-board/list";
    }

    // detail.jsp 조회
    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) throws Exception {
        FormBoardVO detail = formBoardService.getFormBoardService(id);
        model.addAttribute("detail", detail);
        return "form-board/detail";
    }

    // write.jsp 조회
    @GetMapping("/write")
    public String write() throws Exception {
        return "form-board/write";
    }

    @PostMapping("/write")
    public void writeAction(FormBoardVO vo) throws Exception {
        formBoardService.insertFormBoardService(vo);
    }


    // modify.jsp 조회
    @GetMapping("/modify")
    public String modify(@RequestParam int id, Model model) throws Exception {
        FormBoardVO detail = formBoardService.getFormBoardService(id);
        model.addAttribute("detail", detail);
        return "form-board/modify";
    }

    @PostMapping("/modify")
    public void modifyAction(FormBoardVO vo) throws Exception {
        formBoardService.updateFormBoardService(vo);
    }

    @GetMapping("/delete")
    public String deleteAction(@RequestParam int id) throws Exception{
        formBoardService.deleteFormBoardService(id);
        return "redirect:/form-board/list";
    }
}
