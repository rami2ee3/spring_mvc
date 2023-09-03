package org.rami.controller;

import org.rami.domain.ImageBoardVO;
import org.rami.domain.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/image-board")
public class ImageBoardController {

    private static final Logger logger = LoggerFactory.getLogger(ImageBoardController.class);



    @GetMapping("/list")
    public String list(HttpSession session, Model model) throws Exception {
        MemberVO memberInfo = (MemberVO) session.getAttribute("memberInfo");
        if (memberInfo == null) {
            return "redirect:/";
        } else {
            return "image-board/list";
        }
    }

    // Model 은 무조건 GET일때만 사용 ( 담아서 jsp에 전달해주는 용도 )
    @GetMapping("/write")
    public String write(HttpSession session, Model model) throws Exception {
        MemberVO memberInfo = (MemberVO) session.getAttribute("memberInfo");
        if (memberInfo == null) {
            return "redirect:/";
        } else {
            return "image-board/write";
        }
    }

    // 글쓰기 액션
    @PostMapping("/write")
    public @ResponseBody String writeAction(ImageBoardVO vo, HttpServletRequest request, MultipartFile file) throws Exception {
        try {
            System.out.println(vo);
            String path = "C:\\mvc_study\\upload";
            String fileName = file.getOriginalFilename();
            String fullPath = path + "\\" + fileName;
            File saveFile = new File(fullPath);
            file.transferTo(saveFile);
            /**
             * 테이블 구조
             * board
             *  id
             *  title
             *  content
             *  writer
             *
             * board_image
             *  id
             *  board_id
             *  file_path ( /upload/image/ )
             *  file_name ( 스위스.jpg )
             *
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) throws Exception {
        return "image-board/detail";
    }

}
