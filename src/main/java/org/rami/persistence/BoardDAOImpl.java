package org.rami.persistence;

import org.apache.ibatis.session.SqlSession;
import org.rami.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    SqlSession sqlSession;

    private static final String NAMESPACE = "org.rami.mapper.boardMapper";
    @Override
    public int insertBoard(BoardVO vo) throws Exception {
        return sqlSession.insert(NAMESPACE+ ".insertBoard", vo);
    }

    @Override
    public List<BoardVO> getBoardList() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getBoardList");
    }
}
