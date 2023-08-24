package org.rami.persistence;

import org.apache.ibatis.session.SqlSession;
import org.rami.domain.FormBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FormBoardDAOImpl implements FormBoardDAO {

    @Autowired
    SqlSession sqlSession;

    // 무슨 매퍼를 쓸건지
    private static final String NAMESPACE = "org.rami.mapper.formBoardMapper";

    @Override
    public int insertFormBoard(FormBoardVO vo) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertFormBoard", vo);
    }

    @Override
    public FormBoardVO getFormBoard(int id) throws Exception {
        FormBoardVO resultVO = sqlSession.selectOne(NAMESPACE + ".getFormBoard", id);
        return resultVO;
    }

    @Override
    public List<FormBoardVO> getFormBoardList() throws Exception {
        return sqlSession.selectList(NAMESPACE+ ".getFormBoardList");
    }

    @Override
    public int updateFormBoard(FormBoardVO vo) throws Exception {
        return sqlSession.update(NAMESPACE+ ".updateFormBoard", vo);
    }

    @Override
    public int deleteFormBoard(int id) throws Exception {
        return sqlSession.update(NAMESPACE + ".deleteFormBoard", id);
    }
}
