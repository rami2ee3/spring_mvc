package org.rami.service;

import org.rami.domain.MemberVO;
import org.rami.persistence.MemberDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MemberServiceImpl implements MemberService{

    @Inject
    private MemberDAO memberDAO;

    @Override
    public MemberVO getMember() throws Exception {
        return memberDAO.getMember();
    }
}
