package org.rami.persistence;

import org.apache.ibatis.session.SqlSession;
import org.rami.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    SqlSession sqlSession;

    private static final String NAMESPACE = "org.rami.mapper.memberMapper";

    @Override
    public MemberVO getMember() throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getMember");
    }
}
