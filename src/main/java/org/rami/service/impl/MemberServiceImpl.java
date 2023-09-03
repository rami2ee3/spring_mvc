package org.rami.service.impl;

import org.json.simple.JSONObject;
import org.rami.domain.MemberVO;
import org.rami.persistence.MemberDAO;
import org.rami.service.MemberService;
import org.rami.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private CommonUtil commonUtil;

    @Override
    public JSONObject insertMemberService(MemberVO vo) throws Exception {
        // 중복체크
        int memberCount = memberDAO.countMember(vo.getUserId());
        if (memberCount > 0) {
            return commonUtil.makeResponse(500, "fail", "중복된 아이디입니다.");
        }
        int memberRegResult = memberDAO.insertMember(vo);
        if (memberRegResult == 1) {
            return commonUtil.makeResponse(200, "success", "회원가입이 완료되었습니다.");
        } else {
            return commonUtil.makeResponse(500, "fail", "회원가입에 실패하였습니다.");
        }
    }

    @Override
    public JSONObject loginMemberService(MemberVO vo) throws Exception {
        // 회원 정보 있는지 없는지 체크
        MemberVO memberInfo = memberDAO.getMember(vo);
        // 없는 회원일경우
        if (memberInfo == null) {
            return commonUtil.makeResponse(500, "fail", "아이디, 또는 패스워드가 올바르지 않습니다.");
        } else {
            // 로그인 성공하면 lastLoginAt을 업데이트
            memberDAO.updateMemberLastLoginAt(vo.getUserId());
            return commonUtil.makeResponse(200, "success", "로그인에 성공하였습니다.");
        }
    }
}
