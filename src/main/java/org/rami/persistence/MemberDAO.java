package org.rami.persistence;


import org.rami.domain.MemberVO;

public interface MemberDAO {
    int insertMember(MemberVO vo) throws Exception;

    int countMember(String userId) throws Exception;

    MemberVO getMember(MemberVO vo) throws Exception;

    int updateMemberLastLoginAt(String userId) throws Exception;

}
