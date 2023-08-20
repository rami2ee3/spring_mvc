package org.rami.persistence;

import org.rami.domain.MemberVO;

public interface MemberDAO {

    public MemberVO getMember() throws Exception;
}
