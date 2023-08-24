package org.rami.persistence;

import org.apache.ibatis.session.SqlSession;
import org.rami.domain.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    // TODO : 여기에서 뭔가 선언해주고 가져다 써야지?
    @Autowired
    SqlSession sqlSession;

    private static final String NAMESPACE = "org.rami.mapper.companyMapper";

    @Override
    public CompanyVO getCompany(int id) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getCompany", id);
    }
}
