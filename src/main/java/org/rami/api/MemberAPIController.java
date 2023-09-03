package org.rami.api;

import org.json.simple.JSONObject;
import org.junit.platform.commons.function.Try;
import org.rami.domain.MemberVO;
import org.rami.service.MemberService;
import org.rami.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

// @RestController 어노테이션이 붙은 컨트롤러는  모든 컨트롤러 메소드들이 @ResponseBody가 붙어있는 효과를 낸다.
@RestController
@RequestMapping("/api/member")
public class MemberAPIController {
    private static final Logger logger = LoggerFactory.getLogger(MemberAPIController.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private CommonUtil commonUtil;


    // 회원가입 API
    @PostMapping("/join")
    public JSONObject joinMemberApi(MemberVO vo) {
        JSONObject result = new JSONObject();
        try {
            JSONObject insertResult = memberService.insertMemberService(vo);
            result.put("result", insertResult);

        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", commonUtil.makeResponse(500, "fail", "서버 오류 발생"));
        }

        return result;
    }

    // 로그인 API
    @PostMapping("/login")
    public JSONObject loginMemberApi(MemberVO vo, HttpSession session) {
        JSONObject result = new JSONObject();
        try {
            JSONObject loginResult = memberService.loginMemberService(vo);
            int loginResultCode = (int) loginResult.get("code");
            if (loginResultCode == 200) {
                MemberVO memberInfo = memberService.getMemberService(vo);
                session.setAttribute("memberInfo", memberInfo);
            }
            result.put("result", loginResult);

        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", commonUtil.makeResponse(500, "fail", "서버 오류 발생"));
        }

        return result;
    }

    // 로그아웃 API
    @GetMapping("/logout")
    public JSONObject logoutMemberApi(HttpSession session) {
        JSONObject result = new JSONObject();
        try {
            session.removeAttribute("memberInfo");
            result.put("result", commonUtil.makeResponse(200, "success", "로그아웃 성공"));

        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", commonUtil.makeResponse(500, "fail", "서버 오류 발생"));
        }

        return result;
    }
}









