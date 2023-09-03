package org.rami.controller;

import org.json.simple.JSONObject;
import org.rami.domain.MemberVO;
import org.rami.service.MemberService;
import org.rami.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private CommonUtil commonUtil;


    // 회원가입 API
    @PostMapping("/join")
    public @ResponseBody JSONObject joinMember(MemberVO vo) throws Exception {
        JSONObject result = new JSONObject();
        try {
            JSONObject insertResult = memberService.insertMemberService(vo);
            result.put("result", insertResult);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", commonUtil.makeResponse(500, "fail", "서버에 오류가 발생하였습니다."));

        }
        return result;
    }

    // 로그인 API
    @PostMapping("/login")
    public @ResponseBody JSONObject loginMember(MemberVO vo) throws Exception {
        JSONObject result = new JSONObject();
        try {
            JSONObject loginResult = memberService.loginMemberService(vo);
            result.put("result", loginResult);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", commonUtil.makeResponse(500, "fail", "서버에 오류가 발생하였습니다."));
        }
        return result;
    }


}
