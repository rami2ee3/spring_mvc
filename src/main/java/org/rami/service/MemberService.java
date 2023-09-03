package org.rami.service;

import org.json.simple.JSONObject;
import org.rami.domain.MemberVO;

public interface MemberService {

    JSONObject insertMemberService(MemberVO vo) throws Exception;

    JSONObject loginMemberService(MemberVO vo) throws Exception;


}
