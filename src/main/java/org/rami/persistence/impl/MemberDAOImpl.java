package org.rami.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.rami.domain.MemberVO;
import org.rami.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private SqlSession sqlSession;


    private static final String NAMESPACE = "org.rami.mapper.memberMapper";

    @Override
    public int insertMember(MemberVO vo) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertMember", vo);
    }

    @Override
    public int countMember(String userId) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".countMember", userId);
    }

    @Override
    public MemberVO getMember(MemberVO vo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getMember", vo);
    }

    @Override
    public int updateMemberLastLoginAt(String userId) throws Exception {
        return sqlSession.update(NAMESPACE + ".updateMemberLastLoginAt", userId);
    }
}
